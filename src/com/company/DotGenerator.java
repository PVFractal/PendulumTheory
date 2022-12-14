package com.company;

import java.awt.Color;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
import java.util.Date;
import java.io.*;	

public class DotGenerator {




	 public DotGenerator(String num, String file) {
	 
		 int width = 1000,	height = 1000;
		 double max	= 1000;
		  
		 BufferedImage	image	= new	BufferedImage(width,	height, BufferedImage.TYPE_INT_RGB);
		 
					
		 int color = Color.HSBtoRGB(0.5f, 1, 1); // Makes the	color	blue somehow
		  
		 int black = 0; // Makes the color black somehow

		  

		 
		 //Creates the	image	to	be	black
		 for (int row = 0; row < height;	row++) {
				for (int	col =	0;	col <	width; col++) {
					image.setRGB(col,	row, black);
				}
		 }
		 
		 
		try {
   		Scanner scanner = new Scanner(new File(file));
   		while(scanner.hasNextInt())
   		{
   			double dx = scanner.nextDouble();
   			double dy = scanner.nextDouble();
   			
   			dx	/=	max;
   			dy	/=	max;
   			
   			dx	*=	(width);
   			dy	*=	(height);
   			
   			int x = (int)dx;
   			int y = (int)dy;
            
            boolean die = false;
            if (x <= 0) { die = true;}
            if (y <= 0) { die = true;}
            if (y >= height) { die = true;}
            if (x >= width) { die = true;}
            
            
   			if (!die) {
               image.setRGB((int)x,	(int)y, color);
            }
   			
   		}
   				 
   		 
   
   		ImageIO.write(image,	"jpg", new File("Pictures2/Pic" +	num +	".jpg"));
		}
		catch(IOException	e)	{
		  System.out.println("Nothing found");
		}
		
	 }
}


