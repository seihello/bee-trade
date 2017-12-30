package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.Random;

class Chara extends Sprite {
	private static BufferedImage image;
	private String name;
	private int direction = DOWN;
	private static Random random;

	Chara(Position position, int imageNo, String name) {
		super(position, imageNo);
		this.name = name;
		if(image == null) {
			image = ImageLoader.getImage(path + "image/chara.gif");
		}
		if(random == null) {
			random = new Random(System.currentTimeMillis());
		}
	}

	void draw(Graphics g, int initX, int initY, int dx, int dy) {
		int offsetX = (position.x - initX) * MASS_SIZE + dx;
		int offsetY = (position.y - initY) * MASS_SIZE + dy;
		g.drawImage(image,	      
			offsetX,
			offsetY - SPRITE_ADJUST,
			offsetX + MASS_SIZE,
			offsetY + MASS_SIZE - SPRITE_ADJUST, 
			(imageNo % 8) * (CS * 2),
			(imageNo / 8) * (CS * 4) + direction * CS,
			(imageNo % 8) * (CS * 2) + CS,
			(imageNo / 8) * (CS * 4) + direction * CS + CS,
			null);
	}

	void update() {
		int randomValue = random.nextInt(100);
		if(randomValue < 4) {
			direction = randomValue;
		}
	}
}