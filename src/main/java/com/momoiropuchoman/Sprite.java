package com.momoiropuchoman;

import java.awt.image.BufferedImage;

import java.awt.Graphics;

abstract class Sprite implements Common {

	protected Position position;
	protected int imageNo;

	Sprite(Position position, int imageNo) {
		this.position = position;
		this.imageNo = imageNo;
	}

	abstract void draw(Graphics graphics, int offsetX, int offsetY);

	Position getPosition() {
		return position;
	}

}