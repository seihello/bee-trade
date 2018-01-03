package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import java.util.HashSet;
import java.util.Set;

class Field implements Common {
	Mass[][] map;
	
	Set<Chara> charas = new HashSet<Chara>();

	private static BufferedImage massImage;


	Field(String fieldName) {
		map = MapLoader.load(fieldName);
		if(massImage == null) {
			massImage = ImageLoader.getImage(path + "image/mass.gif");
		}

		charas = new FieldDB().getCharas(fieldName);

		for(Object object: charas) {
			Chara chara = (Chara)object;
			map[chara.getPosition().x][chara.getPosition().y].setSprite(chara);
		}

	}

	void draw(Graphics graphics, int initX, int initY, int dx, int dy) {

		graphics.drawString("", 0, 0);  
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	

		// マップ描画
		for(int j = initY - 1; j < initY + MASS_Y_NUM + 1; j++) { 
			for(int i = initX - 1; i < initX + MASS_X_NUM + 1; i++) { 
				int offsetX = (i - initX) * MASS_SIZE + dx;
				int offsetY = (j - initY) * MASS_SIZE + dy;
				try {
					map[i][j].draw(graphics, offsetX, offsetY);
				} catch(ArrayIndexOutOfBoundsException e) {
					// System.out.println("範囲外");
					int imageNo = 64;
					graphics.drawImage(massImage,
						offsetX,
						offsetY,
						offsetX + MASS_SIZE,
						offsetY + MASS_SIZE,
						(imageNo % 16) * CS,
						(imageNo / 16) * CS,
						(imageNo % 16) * CS + CS,
						(imageNo / 16) * CS + CS,
						null);
				}
			}
		}

		// Sprite描画
		for(Object object: charas) {
			Chara chara = (Chara)object;
			int offsetX = (chara.getPosition().x - initX) * MASS_SIZE + dx;
			int offsetY = (chara.getPosition().y - initY) * MASS_SIZE + dy;
			chara.draw(graphics, offsetX, offsetY);
		}
	}

	void update() {
		for(Object object: charas) {
			Chara chara = (Chara)object;
			chara.update();
		}
	}

	Mass[][] getMap() {
		return map;
	}



}