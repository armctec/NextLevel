package com.armctec.nl.general.utility;

import org.lwjgl.util.vector.Vector3f;

public class GeometryUtility
{
	 public static Vector3f[] plotSphere(int x0, int y0, int z0, int x1, int y1, int z1)
	    {                             
	        int t[] = {(x1-x0+1),(y1-y0+1),(z1-z0+1)};
	       
	        int d = t[0]*t[1]*t[2];
	        int lim = Math.max(Math.max(t[0], t[1]),t[2]) / 2;
	        lim = (int) ((lim * lim) + Math.sqrt(lim) + 1);
	       
	        Vector3f vals[] = new Vector3f[d];
	       
	        //System.out.println("D:"+d);
	       
	        int cont=0;
	        for(int x=x0;x<=x1;x++)
	        {
	            int x2 = x*x;
	            for(int y=y0;y<=y1;y++)
	            {
	                int y2= y*y;
	                for(int z=z0;z<=z1;z++)
	                {
	                    int z2 = z*z + x2 +y2;
	                    if(z2<lim)
	                    {
	                        vals[cont++] = new Vector3f(x,y,z);
	                    }
	                }
	            }
	        }
	                   
	        for(;cont<d;cont++)
	            vals[cont]=null;
	       
	        return vals;
	    }
}
