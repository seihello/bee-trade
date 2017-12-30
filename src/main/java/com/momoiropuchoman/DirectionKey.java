package com.momoiropuchoman;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class DirectionKey implements KeyListener, Common {

	private static Direction pressedKey = Direction.NO;

	static Direction getPressedKey() {
		return pressedKey;
	}

	private static void setPressedKey(Direction key) {
		pressedKey = key;
	} 

	private static Direction toDirection(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
			return Direction.UP;
			case KeyEvent.VK_DOWN:
			return Direction.DOWN;
			case KeyEvent.VK_LEFT:
			return Direction.LEFT;
			case KeyEvent.VK_RIGHT:
			return Direction.RIGHT;
			default:
			return Direction.NO;
		}
	}

	public void keyPressed(KeyEvent keyEvent) {
		setPressedKey(toDirection(keyEvent.getKeyCode()));

		/*
		if(code >= KeyEvent.VK_LEFT && code <= KeyEvent.VK_DOWN) {
			DirectionKey.setPressedKey(convertKeyIntoDirection(code));
		}
		*/
	}

	public void keyReleased(KeyEvent keyEvent) {
		setPressedKey(Direction.NO);
	}
	
	public void keyTyped(KeyEvent keyEvent) {

	}
}