package com.momoiropuchoman;

import java.awt.image.BufferedImage;

import java.awt.Graphics;

abstract class Sprite implements Common {

	static MessageBoard messageBoard;

	protected Mass[][] map;
	protected Position position;
	protected int imageNo;

	Sprite(Mass[][] map, Position position, int imageNo) {
		this.map = map;
		this.position = position;
		this.imageNo = imageNo;
	}

	abstract void draw(Graphics graphics, int offsetX, int offsetY);
	abstract void update();

	Position getPosition() {
		return position;
	}

}