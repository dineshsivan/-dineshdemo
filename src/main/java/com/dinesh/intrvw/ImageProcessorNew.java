package com.dinesh.intrvw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;

public class ImageProcessorNew {
	public static void main(String[] args) throws IOException {
		System.setProperty("http.agent", "Chrome");
		int splitWidth = 260;

		MarvinImage sourceImg = MarvinImageIO.loadImage("E:\\Test Img\\Source1.png");
		MarvinPluginCollection.blackAndWhite(sourceImg, 150);
		spliAndWrite(sourceImg, "E:\\Test Img\\stampOnly", splitWidth,"jpg");
		combineAndWrite(sourceImg, "E:\\Test Img\\splitimg.png", splitWidth,"jpg");

		System.out.println("Sub-images have been created.");
	}

	private static void spliAndWrite(MarvinImage image, String outputPath, int splitWidth,String type) {
		type =type==null ? "jpg":type;
		MarvinImage splitImg = new MarvinImage(400, 400);
		MarvinPluginCollection.crop(image, splitImg, 0, 0, splitWidth, 400);
		MarvinPluginCollection.scale(splitImg.clone(), splitImg, 400, 400);
		if("png".equalsIgnoreCase(type)) {
		MarvinPluginCollection.boundaryFill(splitImg.clone(), splitImg, 0, 0, Color.white, 150);
		splitImg.setColorToAlpha(0, 0xFFFFFFFF);
		MarvinPluginCollection.alphaBoundary(splitImg, 5);
		}
		MarvinImageIO.saveImage(splitImg, outputPath+"."+type);
	}

	private static void combineAndWrite(MarvinImage image, String outputPath, int splitWidth, String type) throws IOException {
		type =type==null ? "jpg":type;
		MarvinImage stamp = new MarvinImage();
		MarvinImage sign = new MarvinImage();

		MarvinPluginCollection.crop(image, stamp, 0, 0, splitWidth, 400);
		MarvinPluginCollection.crop(image, sign, stamp.getWidth(), 0, (image.getWidth() - stamp.getWidth()),
				image.getHeight());
		MarvinPluginCollection.blackAndWhite(stamp, 150);
		if("png".equalsIgnoreCase(type)) {
		MarvinPluginCollection.boundaryFill(stamp.clone(), stamp, 0, 0, Color.white, 150);
		stamp.setColorToAlpha(0, 0xFFFFFFFF);
		MarvinPluginCollection.alphaBoundary(stamp, 5);
		}

		MarvinPluginCollection.blackAndWhite(sign, 150);
		if("png".equalsIgnoreCase(type)) {
		MarvinPluginCollection.boundaryFill(sign.clone(), sign, 0, 0, Color.white, 150);
		sign.setColorToAlpha(0, 0xFFFFFFFF);
		MarvinPluginCollection.alphaBoundary(sign, 5);
		}

		MarvinImageIO.saveImage(stamp, "E:\\Test Img\\stamptemp.png");
		MarvinImageIO.saveImage(sign, "E:\\Test Img\\signtemp.png");

		BufferedImage combine = new BufferedImage(600, 550, BufferedImage.TYPE_INT_ARGB);
		BufferedImage loadedStamp = stamp.getBufferedImage();
		BufferedImage loadedSign = sign.getBufferedImage();

		int x = 600 - loadedStamp.getWidth();
		int y = 550 - (loadedSign.getHeight()+loadedStamp.getHeight());
		System.out.println(x + ":" + y);
		Graphics2D g2d = combine.createGraphics();
		if(!"png".equalsIgnoreCase(type))
		{
		g2d.setPaint (Color.WHITE);
		g2d.fillRect ( 0, 0, combine.getWidth(), combine.getHeight() );
		}
		g2d.drawImage(loadedStamp, x, y, null);
		int x1 = 0;
		int y1 = 550 - loadedSign.getHeight();
		g2d.drawImage(loadedSign, x1, y1, null);
		g2d.dispose();

		ImageIO.write(combine, "png", new File("E:\\Test Img\\combine.png"));
		
		try {
		File f = new File("E:\\Test Img\\stamptemp.png");
		f.delete();
		f = new File("E:\\Test Img\\signtemp.png");
		f.delete();
		} catch (Exception e) {
			System.out.println("File deletion failed");
		}
	}

}
