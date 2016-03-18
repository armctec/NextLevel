package com.armctec.nl.general.utility;

public class NoiseGenerator 
{
	private byte cache[][] = null;
	private byte cache_gen[][][] = null;
	private int width_cache = 0;
	private int height_cache = 0;
	private long seed_base = 0;
	private int filter = 0;
	private int limite = 4;
	private int width = 0;
	private int height = 0;
			
	public NoiseGenerator(int width, int height) 
	{
		cache = new byte[width][height];
		cache_gen = new byte[1][width][height];
		this.width = width;
		this.height = height;
		this.height_cache = height;
		this.width_cache = width;
		
		GenerateNoise(0,0);
	}
	
	public void setTamanho(int width, int height)
	{
		if(!(width<width_cache && height<height_cache))
		{
			cache = new byte[width][height];
			int off = (filter<<1);
			cache_gen = new byte[1+filter][width+off][height+off];
			this.height_cache = height;
			this.width_cache = width;			
		}

		this.width=width;
		this.height=height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public byte [][] getCache()
	{
		return cache;
	}
	
	public void setSeed(long seed)
	{
		seed_base = seed;	
	}
	
	public void setFilter(int filter, int limite)
	{
		this.limite = limite;
		
		if(this.filter != filter)
		{
			int off = (filter<<1);
			cache_gen = new byte[1+filter][width+off][height+off];
		}

		this.filter = filter;
	}
	
	private byte getCor(int x, int y, int nivel)
	{
		if(nivel == 0)
			return 0;
		
		int off = nivel - 1;
		
		byte cor0[] = new byte[]{	cache_gen[off][x+1][y],
									cache_gen[off][x-1][y],
									cache_gen[off][x][y+1],
									cache_gen[off][x][y-1],
									cache_gen[off][x+1][y+1],
									cache_gen[off][x+1][y-1],
									cache_gen[off][x-1][y+1],
									cache_gen[off][x-1][y-1]};
		byte cont = 0;
		
		for(int i =0;i<cor0.length;i++)
			if(cor0[i] == 1)
				cont++;
		
		return cont;
	}
		
	private void getFilter(int nivel)
	{
		if(nivel > filter)
			return;
		if(nivel == 0)
			return;
		
		int off = nivel;
		int cwidth = width+(filter<<1)-nivel;
		int cheight = height+(filter<<1)-nivel;
		
		//int calc = cwidth - off; 
		//System.out.println("Nivel:"+nivel+" Width:"+calc+" Start:"+off+" End:"+(cwidth-1));
		
		for(int x=off;x<cwidth;x++)
		{
			for(int y=off;y<cheight;y++)
			{
				int cont = getCor(x,y,nivel);
				cache_gen[nivel][x][y] = (byte) ((cont > limite)?1:0);
			}
		}
	}	
	
	public void GenerateNoise(int xini, int yini)
	{
		int off = filter<<1;
		
		for(int x=0;x<(width+off);x++)
		{
			for(int y=0;y<(height+off);y++)
			{
				cache_gen[0][x][y] = (byte) ((getRandom(xini + x , yini + y))?1:0); 
			}
		}

		for(int i=0;i<filter;i++)
			getFilter(i+1);	
		
		//System.out.println("Out: Start:"+(filter)+" End:"+(width+filter-1));
		
		for(int x=0;x<width;x++)
			for(int y=0;y<height;y++)
				cache[x][y]=cache_gen[filter][x+filter][y+filter];
	}
	
	public boolean getRandom(int xini, int yini)
	{
		long seed_gen = seed_base << 7 + seed_base;
		seed_gen = seed_gen ^ xini;
		seed_gen = (-seed_gen) ^ (xini + yini);
		seed_gen = (-seed_gen) ^ yini;
		seed_gen = seed_gen ^ (xini - yini);
		
		long result0 = seed_gen % 33;
		long result1 = result0 % 9;
		long result2 = result1 % 2;
		
		return (result0==0 || result1==0 || result2==0)?true:false;
	}
	
	
}
