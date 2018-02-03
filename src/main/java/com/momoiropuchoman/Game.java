package com.momoiropuchoman;



class Game implements Common {

	Drawing drawing;

	Field field;
	Player player;

	private int mode = GAME;
	public static final int GAME = 0;
	public static final int MESSAGE = 1;

	Game() {

		field = new Field("France");
		player = new Player(field.getMap(), new Position(8, 6), 0, "Link");
		drawing = new Drawing(field, player);
		
	}

	void run() {

		// メインループ
		while(true) {
			if(mode == GAME) {
				update();
			}
			drawing.repaint();
			try {
				Thread.sleep(50); 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		field.update(player.getPosition().x - MASS_X_NUM / 2, player.getPosition().y - MASS_Y_NUM / 2);
		player.update();
	}

	Drawing getDrawing() {
		return drawing;
	}

}