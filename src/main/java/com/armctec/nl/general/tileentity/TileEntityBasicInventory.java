package com.armctec.nl.general.tileentity;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityBasicInventory extends TileEntity implements IInventory
{
	protected ItemStack[] itemStacks = null;
	protected int num_slots = 0;
	protected String NameEntity = null;
	
	public TileEntityBasicInventory()
	{
		super();
	}
	
	public TileEntityBasicInventory(String NameEntity, int num_slots) 
	{
		super();
		
		this.num_slots = num_slots;
		itemStacks = new ItemStack[num_slots];
		this.NameEntity = NameEntity;
	}

	@Override
	public String getName() 
	{
		return "container."+NameEntity+".name";
	}

	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() 
	{
		return num_slots;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index<num_slots)
			return itemStacks[index];
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if (this.itemStacks[index] != null)
        {
            ItemStack itemStackInSlot ;

            if (itemStacks[index].stackSize <= count)
            {
            	itemStackInSlot  = itemStacks[index];
                itemStacks[index] = null;
                markDirty();
                return itemStackInSlot ;
            }
            else
            {
            	itemStackInSlot  = itemStacks[index].splitStack(count);

                if (itemStacks[index].stackSize == 0)
                {
                    itemStacks[index] = null;
                }

                markDirty();
                return itemStackInSlot;
            }
        }
        else
        {
            return null;
        }
	}

	public ItemStack getStackInSlotOnClosing(int index) 
	{
        if (itemStacks[index] != null)
        {
            ItemStack itemStackInSlot = itemStacks[index];
            itemStacks[index] = null;
            return itemStackInSlot;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		if(index>num_slots || itemStacks==null)
		{	
			//System.out.println("Erro:"+index+":"+itemStacks==null);
			return;
		}
		
		//if(stack!=null)
		//	System.out.println("set Pos:"+index+"-"+stack.toString());
		//else
		//	System.out.println("set Pos:"+index+"- ");
			
		itemStacks[index] = stack;

        if (stack != null && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		if (this.worldObj.getTileEntity(this.pos) != this) 
		{
			//System.out.println("Erro: isUseableByPlayer");
			return false;
		}
		return player.getDistanceSq(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f) < 64;
	}

	@Override
	public void openInventory(EntityPlayer player) 
	{
	
	}

	@Override
	public void closeInventory(EntityPlayer player) 
	{

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public void setField(int id, int value) 
	{
		
	}

	@Override
	public int getFieldCount() 
	{
		return 0;
	}

	@Override
	public void clear() 
	{
		Arrays.fill(itemStacks, null);
	}
	
	// This is where you save any data that you don't want to lose when the tile entity unloads
	// In this case, it saves the itemstacks stored in the container
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tileEntity's location

		parentNBTTagCompound.setInteger("QuantSlots", num_slots);
		
		// to use an analogy with Java, this code generates an array of hashmaps
		// The itemStack in eac+h slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
		//   as slot=1, id=2353, count=1, etc
		// Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i) 
		{
			if (this.itemStacks[i] != null)	
			{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		// the array of hashmaps is then inserted into the parent hashmap for the container
		parentNBTTagCompound.setTag("Items", dataForAllSlots);
		
		return parentNBTTagCompound;
	}


	
	// This is where you load the data that you saved in writeToNBT
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.readFromNBT(parentNBTTagCompound); // The super call is required to save and load the tiles location
		
		num_slots = parentNBTTagCompound.getInteger("QuantSlots");
		itemStacks = new ItemStack[num_slots];
		Arrays.fill(itemStacks, null);           // set all slots to empty

		final byte NBT_TYPE_COMPOUND = 10;       // See NBTBase.createNewByType() for a listing
		NBTTagList dataForAllSlots = parentNBTTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

		for (int i = 0; i < dataForAllSlots.tagCount(); ++i) 
		{
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;

			if (slotIndex >= 0 && slotIndex < this.itemStacks.length) 
			{
				itemStacks[slotIndex] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
			}
		}
		
		//System.out.println("Tamanho Lido:"+num_slots);
		//for(int i=0;i<num_slots;i++)
		//{
		//	if(itemStacks[i]!=null)
		//		System.out.println("Num:"+i+"-"+itemStacks[i].toString());
		//	System.out.println("Num:"+i+"- ");
		//}
	}	
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		return new SPacketUpdateTileEntity(this.pos, 0, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
	    NBTTagCompound nbtTagCompound = new NBTTagCompound();
	    writeToNBT(nbtTagCompound);
	    return nbtTagCompound;
	}	

	@Override
	public void handleUpdateTag(NBTTagCompound tag)
	{
		this.readFromNBT(tag);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}		
}
