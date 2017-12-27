package com.momoiropuchoman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Player implements Common {
	private Position position;
	private int dx = 0, dy = 0;
	private Direction direction = Direction.UP;
	private boolean isMoving = false;
	private static BufferedImage image;
	private int imageNo = 0;

	Player(Position position) {
		this.position = position;
		if(image == null) {
			image = ImageLoader.getImage(path + "image/chara.gif");
		}
	}

	int getX() {
		return position.x;
	}

	int getY() {
		return position.y;
	}

	void draw(Graphics graphics) {
		graphics.drawImage(image,
			(MASS_X_NUM / 2) * MASS_SIZE,
			(MASS_Y_NUM / 2) * MASS_SIZE - SPRITE_ADJUST,
			(MASS_X_NUM / 2) * MASS_SIZE + MASS_SIZE,
			(MASS_Y_NUM / 2) * MASS_SIZE + MASS_SIZE - SPRITE_ADJUST,
			(imageNo % 8) * (CS * 2),
			(imageNo / 8) * (CS * 4) + direction.ordinal() * CS,
			(imageNo % 8) * (CS * 2) + CS,
			(imageNo / 8) * (CS * 4) + direction.ordinal() * CS + CS,
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

	int getDx() {
		return dx;
	}

	int getDy() {
		return dy;
	}

	Direction getDirection() {
		return direction;
	}

	void update() {

		if(!isMoving) {
			if(DirectionKey.getPressedKey() != Direction.NO) {
				if(DirectionKey.getPressedKey() == direction) {
					isMoving = true;
				} else {
					direction = DirectionKey.getPressedKey();
				}
			}
		} 
		if(isMoving) {
			int oneFrame = MASS_SIZE / 4;
			switch(direction) {
				case UP:
				dy += oneFrame;
				break;
				case DOWN:
				dy -= oneFrame;
				break;
				case LEFT:
				dx += oneFrame;
				break;
				case RIGHT:
				dx -= oneFrame;
				break;
			}

			if(dx == MASS_SIZE || dy == MASS_SIZE || dx == -MASS_SIZE || dy == -MASS_SIZE) {
				dx = 0;
				dy = 0;
				updatePosition();
				isMoving = false;
			}
		}

	}

	boolean isMoving() {
		return isMoving;
	}


}