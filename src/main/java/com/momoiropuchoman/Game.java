package com.momoiropuchoman;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

class Game extends JPanel implements Common {

	Field field;
	Player player;

	private int mode = GAME;
	public static final int GAME = 0;
	public static final int MESSAGE = 1;

	Game() {
		this.setBounds(0, 0, Common.WIDTH, Common.HEIGHT);
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);

		
		field = new Field("France");
		player = new Player(new Position(8, 6), 0, "Link", field.getMap());
		
	}

	void run() {

		// メインループ
		while(true) {
			if(mode == GAME) {
				update();
			}
			repaint();
			try {
				Thread.sleep(50); 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		field.update();
		player.update();
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);	
		field.draw(graphics, player.getPosition().x - MASS_X_NUM / 2, player.getPosition().y - MASS_Y_NUM / 2, player.getDx(), player.getDy());
		player.draw(graphics, (MASS_X_NUM / 2) * MASS_SIZE, (MASS_Y_NUM / 2) * MASS_SIZE);
	}

}