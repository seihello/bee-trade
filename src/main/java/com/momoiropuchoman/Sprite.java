package com.momoiropuchoman;

import java.awt.image.BufferedImage;

abstract class Sprite implements Common {
	protected Position position;
	protected Mass[][] map;

	protected static BufferedImage image;
	protected int imageNo;
	protected String name;

	Sprite(Position position) {
		this.position = position;
	}

	void setMap(Mass[][] map) {
		this.map = map;
	}

}