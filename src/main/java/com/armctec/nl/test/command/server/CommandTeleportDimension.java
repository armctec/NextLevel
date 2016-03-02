package com.armctec.nl.test.command.server;

import java.util.List;

import com.armctec.nl.general.utility.UtilityFunctions;
import com.armctec.nl.test.world.VoidTeleporter;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class CommandTeleportDimension extends CommandBase {

	public CommandTeleportDimension() 
	{

	}

	@Override
	public String getCommandName() 
	{
		return "tpd";
	}
	
	@Override
	public int getRequiredPermissionLevel() 
	{
		return 2;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "commands.tpd.usage";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		if (args.length < 2)
        {
            throw new WrongUsageException("commands.tpd.usage", new Object[0]);
        }
		else
        {
			Entity entity;
			entity = func_175768_b(sender, args[0]);

			if(entity == null)
				throw new WrongUsageException("commands.tpd.usage", new Object[0]);
			
			if(UtilityFunctions.travelToDimensionEntityPlayer((EntityPlayerMP) entity, parseInt(args[1])) == false)
				throw new WrongUsageException("commands.tpd.usage", new Object[0]);
        }
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) 
	{
		if(args.length == 1)
			return getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames());
		
		if(args.length == 2)
		{
			Integer dims[] = DimensionManager.getIDs();
			String worlds[] = null;
			if(dims.length == 0)
				return null;
			
			worlds = new String[dims.length];
			
			for(int i = 0; i < dims.length; i++)
			{
				String dim_number = dims[i] + " ";
				worlds[i] = new String(dim_number + DimensionManager.getProvider(dims[i]).getDimensionName());
			}
			
			return getListOfStringsMatchingLastWord(args, worlds);
		}
					
		return null;
	}
	
	@Override
	public boolean isUsernameIndex(String[] args, int index) 
	{
		return index == 0;
	}
}
