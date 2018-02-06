package com.momoiropuchoman;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class InputHandler implements KeyListener, Common {

	// 唯一のインスタンス
	private static InputHandler inputHandler = new InputHandler();

	Key key;
	Player player;

	private InputHandler() {
		// do nothing.
	}

	static InputHandler getInstance() {
		return inputHandler;
	}

	void setPlayer(Player player) {
		this.player = player;
	}

	void setKey(Key key) {
		this.key = key;
	}

	public void keyPressed(KeyEvent keyEvent) {
		int code = keyEvent.getKeyCode();
		if(code >= KeyEvent.VK_LEFT && code <= KeyEvent.VK_DOWN) {
			key.setPressedKey(key.toDirection(keyEvent.getKeyCode()));
		} else if(code == KeyEvent.VK_ENTER) {
			if(player.getMode() == Player.MOVABLE) {
				player.talk();
			} else if(player.getMode() == Player.TALKING) {
				player.nod();
			}

		}
	}

	public void keyReleased(KeyEvent keyEvent) {
		key.setPressedKey(NO);
	}
	
	public void keyTyped(KeyEvent keyEvent) {

	}

}