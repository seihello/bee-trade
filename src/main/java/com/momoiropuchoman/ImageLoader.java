package com.momoiropuchoman;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

class ImageLoader {

	public static BufferedImage getImage(String fileName) {
		try {
			return ImageIO.read(new File(fileName));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}