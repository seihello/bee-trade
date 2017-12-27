package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

class Field implements Common {
	Mass[][] map;
	Player player;
	private static BufferedImage massImage;


	Field(Player player) {
		this.player = player;
		map = MapLoader.load("france");
		if(massImage == null) {
			massImage = ImageLoader.getImage(path + "image/mass.gif");
		}
	}

	void draw(Graphics graphics) {

		graphics.drawString("", 0, 0);  
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		int initX = player.getX() - MASS_X_NUM / 2;
		int initY = player.getY() - MASS_Y_NUM / 2;
		int dx = player.getDx();
		int dy = player.getDy();

		for(int j = initY - 1; j < initY + MASS_Y_NUM + 1; j++) { 
			for(int i = initX - 1; i < initX + MASS_X_NUM + 1; i++) { 
				try {
					map[i][j].draw(graphics, initX, initY, dx, dy);
				} catch(ArrayIndexOutOfBoundsException e) {
					// System.out.println("範囲外");
					int imageNo = 64;
					graphics.drawImage(massImage,
						(i - initX) * MASS_SIZE + dx,
						(j - initY) * MASS_SIZE + dy,
						(i - initX) * MASS_SIZE + MASS_SIZE + dx,
						(j - initY) * MASS_SIZE + MASS_SIZE + dy,
						(imageNo % 16) * CS,
						(imageNo / 16) * CS,
						(imageNo % 16) * CS + CS,
						(imageNo / 16) * CS + CS,
						null);
				}
			}
		}
	}



}