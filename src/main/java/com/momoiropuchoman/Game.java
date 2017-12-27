package com.momoiropuchoman;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

class Game extends JPanel implements Common {

	Field field;
	Player player;

	Game() {
		this.setBounds(0, 0, Common.WIDTH, Common.HEIGHT);
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);

		player = new Player(new Position(10, 10));
		field = new Field(player);
		
	}

	void run() {

		// メインループ
		while(true) {
			update();
			repaint();
			try {
				Thread.sleep(50); 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		// field.update();
		player.update();
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);		
		field.draw(graphics);
		player.draw(graphics);
	}

}