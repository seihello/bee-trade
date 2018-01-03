package com.momoiropuchoman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;

class MessageBoard {

	private String name = "";
	private List<String> messages = new ArrayList<String>();
	private String overMessage = "";
	private String underMessage = "";
	private int index = 0;

	public static final int X = 100;
	public static final int Y = 400;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 150;

	public static final Color tGray = new Color(50, 50, 50, 200);

	protected void draw(Graphics g) {
		g.setColor(tGray);
		g.fillRect(X, Y, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		g.drawString(overMessage,
			X + 30,
			Y + 60);
		g.drawString(underMessage,
			X + 30,
			Y + 100);
	}

	void newMessage(List<String> messages) {
		this.messages = messages;
		showMessage();
	}

	private void showMessage() {
		underMessage = "";
		overMessage = "";
		if(messages.size() - index == 1 ) {
			overMessage = messages.get(index);
		} else {
			overMessage = messages.get(index);
			index ++;
			underMessage = messages.get(index);
		}
	}

	boolean nextMessage() {
		index ++;
		if(messages.size() <= index) {
			removeMessage();
			return false;
		} else {
			showMessage();
			return true;
		}
	}

	void removeMessage() {
		messages = null;
		index = 0;
	}



}