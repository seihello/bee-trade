package com.momoiropuchoman;

import java.awt.image.BufferedImage;

abstract class Sprite implements Common {
	protected Position position;

	protected int imageNo;

	Sprite(Position position, int imageNo) {
		this.position = position;
		this.imageNo = imageNo;
	}

	

	Position getPosition() {
		return position;
	}

}