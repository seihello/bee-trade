package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Player extends Sprite {

	DirectionKey directionKey;
	private int dx = 0, dy = 0;
	private int direction = UP;
	private boolean isMoving = false;
	private static BufferedImage image;
	private String name;
	private Mass[][] map;


	Player(Position position, int imageNo, String name, Mass[][] map) {
		super(position, imageNo);
		this.name = name;
		this.map = map;
		directionKey = DirectionKey.getInstance();
		if(image == null) {
			image = ImageLoader.getImage(path + "image/chara.gif");
		}
	}


	void draw(Graphics graphics, int offsetX, int offsetY) {
		graphics.drawImage(image,
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

	private void updatePosition() {
		switch(direction) {
			case UP:
			position.y--;
			break;
			case DOWN:
			position.y++;
			break;
			case LEFT:
			position.x--;
			break;
			case RIGHT:
			position.x++;
			break;

		}
	}

	private void updateDirection() {
		direction = directionKey.getPressedKey();
	}

	private void updateDefference() {
		switch(direction) {
			case UP:
			dy += ONE_FRAME;
			break;
			case DOWN:
			dy -= ONE_FRAME;
			break;
			case LEFT:
			dx += ONE_FRAME;
			break;
			case RIGHT:
			dx -= ONE_FRAME;
			break;
		}
	}

	private boolean hasMovedOneMass() {
		if(dx == MASS_SIZE || dy == MASS_SIZE || dx == -MASS_SIZE || dy == -MASS_SIZE) {
			return true;
		} else {
			return false;
		}
	}


	private boolean canMove() {
		try {
			if(map[getNextX()][getNextY()].isHit()) {
				return false;
			} else {
				return true;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	void update() {

		if(!isMoving && directionKey.getPressedKey() != NO) {
			if(directionKey.getPressedKey() == direction && canMove()) {
				isMoving = true;
			} else {
				updateDirection();
			}
		}
		
		if(isMoving) {
			updateDefference();
			if(hasMovedOneMass()) {
				dx = 0; dy = 0;
				isMoving = false;
				updatePosition();
			}
		}

	}



	int getNextX() {
		switch(direction) {
			case UP:
			return position.x;
			case DOWN:
			return position.x;
			case LEFT:
			return position.x - 1;
			case RIGHT:
			return position.x + 1;
		}
		return 0;
	}

	int getNextY() {
		switch(direction) {
			case UP:
			return position.y - 1;
			case DOWN:
			return position.y + 1;
			case LEFT:
			return position.y;
			case RIGHT:
			return position.y;
		}
		return 0;
	}


	int getDx() {
		return dx;
	}

	int getDy() {
		return dy;
	}

	int getDirection() {
		return direction;
	}

	boolean isMoving() {
		return isMoving;
	}

	void setMap(Mass[][] map) {
		this.map = map;
	}


}