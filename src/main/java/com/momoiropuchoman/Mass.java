package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.HashMap;
import java.util.Map;

import java.awt.Graphics;

class Mass implements Common {
	private static BufferedImage massImage;
	private static Map<Character, Integer> converter;
	private char kind;
	private int imageNo;
	private Sprite sprite = null;

	Mass(char kind) {
		if(massImage == null) {
			massImage = ImageLoader.getImage(path + "image/mass.gif");
		}
		if(converter == null) {
			createConverter();
		}
		imageNo = converter.get(kind).intValue();

	}

	void draw(Graphics graphics, int offsetX, int offsetY) {
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

	boolean isHit() {
		if((imageNo >= 64 && imageNo < 127) || imageNo == 7 || imageNo == 8) {
			return true;
		} else if(sprite != null) {
			return true;
		} else {
			return false;
		}
	}

	void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	Sprite getSprite() {
		return sprite;
	}

	private void createConverter() {
		converter = new HashMap<Character, Integer>();
		converter.put('黒', 0);
		converter.put('草', 1);
		converter.put('砂', 2);
		converter.put('雪', 3);
		converter.put('山', 4);
		converter.put('火', 5);
		converter.put('花', 6);
		converter.put('木', 7);
		converter.put('石', 8);
		converter.put('丸', 9);

		converter.put('理', 16);
		converter.put('１', 17);
		converter.put('２', 18);
		converter.put('３', 19);
		converter.put('ア', 20);
		converter.put('イ', 21);
		converter.put('ウ', 22);
		converter.put('1', 23);
		converter.put('1', 24);

		converter.put('椅', 32);
		converter.put('４', 33);
		converter.put('５', 34);
		converter.put('６', 35);
		converter.put('1', 36);
		converter.put('1', 37);
		converter.put('1', 38);
		converter.put('1', 39);

		converter.put('段', 48);
		converter.put('７', 49);
		converter.put('８', 50);
		converter.put('９', 51);
		converter.put('1', 52);
		converter.put('1', 53);
		converter.put('1', 54);
		converter.put('埋', 55);

		converter.put('海', 64);
		converter.put('岩', 65);

		converter.put('1', 80);
		converter.put('1', 81);
		converter.put('1', 82);
		converter.put('1', 83);
		converter.put('1', 84);

		converter.put('1', 96);
		converter.put('1', 97);
		converter.put('1', 98);
		converter.put('1', 99);
		converter.put('1', 100);
	}
}