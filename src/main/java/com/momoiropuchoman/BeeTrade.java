package com.momoiropuchoman;

import javax.swing.JFrame;

class BeeTrade extends JFrame implements Common {



	BeeTrade() {
		this.getContentPane().setLayout(null);
		this.setSize(Common.WIDTH, Common.HEIGHT + BAR);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void run() {

		this.addKeyListener(Key.getInstance());
		Game game = new Game();
		this.add(game.getDrawing());
		game.run();
	}


	public static void main(String[] args) {
		new BeeTrade().run();
	}
}