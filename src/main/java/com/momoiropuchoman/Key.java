package com.momoiropuchoman;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Key implements KeyListener, Common {

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

	private void setPressedKey(int key) {
		pressedKey = key;
	} 

	private int toDirection(int keyCode) {
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

	public void keyPressed(KeyEvent keyEvent) {
		setPressedKey(toDirection(keyEvent.getKeyCode()));

		/*
		if(code >= KeyEvent.VK_LEFT && code <= KeyEvent.VK_DOWN) {
			DirectionKey.setPressedKey(convertKeyIntoDirection(code));
		}
		*/
	}

	public void keyReleased(KeyEvent keyEvent) {
		setPressedKey(NO);
	}
	
	public void keyTyped(KeyEvent keyEvent) {

	}
}