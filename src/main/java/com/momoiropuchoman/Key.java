package com.momoiropuchoman;

import java.awt.event.KeyEvent;

class Key implements Common {

	private static Key key = new Key();
	private int pressedKey = NO;

	private Key() { 
		// do nothing.
	}

	static Key getInstance() {
		return key;
	}

	int getPressedKey() {
		return pressedKey;
	}

	void setPressedKey(int key) {
		pressedKey = key;
	} 

	int toDirection(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
			return UP;
			case KeyEvent.VK_DOWN:
			return DOWN;
			case KeyEvent.VK_LEFT:
			return LEFT;
			case KeyEvent.VK_RIGHT:
			return RIGHT;
			default:
			return NO;
		}
	}

	
}