package com.momoiropuchoman;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

class Drawing extends JPanel implements Common {
	Field field;
	Player player;

	Drawing(Field field, Player player) {

		this.setBounds(0, 0, Common.WIDTH, Common.HEIGHT);
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);

		setField(field);
		this.player = player;
	}

	void setField(Field field) {
		this.field = field;
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);	
		field.draw(graphics, player.getPosition().x - MASS_X_NUM / 2, player.getPosition().y - MASS_Y_NUM / 2, player.getDx(), player.getDy());
		player.draw(graphics, (MASS_X_NUM / 2) * MASS_SIZE, (MASS_Y_NUM / 2) * MASS_SIZE);
	}


}