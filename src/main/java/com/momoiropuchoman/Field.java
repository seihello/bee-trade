package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import java.util.HashSet;
import java.util.Set;

class Field implements Common {
	Mass[][] map;
	Mass outOfField;
	
	Set<AroundSprite> charas = new HashSet<AroundSprite>();

	private static BufferedImage massImage;


	Field(String fieldName) {
		map = MapLoader.load(fieldName);
		outOfField = new Mass('海');


		charas = new FieldDB().getCharasAsAroundSprite(fieldName, map);

		if(massImage == null) {
			massImage = ImageLoader.getImage(path + "image/mass.gif");
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
					outOfField.draw(graphics, offsetX, offsetY);
				}
			}
		}

		// Sprite描画
		for(Object object: charas) {
			AroundSprite sprite = (AroundSprite)object;
			int offsetX = (sprite.getPosition().x - initX) * MASS_SIZE + dx;
			int offsetY = (sprite.getPosition().y - initY) * MASS_SIZE + dy;
			sprite.draw(graphics, offsetX, offsetY);
		}
	}

	void update(int initX, int initY) {
		for(Object object: charas) {
			AroundSprite sprite = (AroundSprite)object;
			sprite.update();
		}
	}



	Mass[][] getMap() {
		return map;
	}



}