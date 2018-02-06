package com.momoiropuchoman;

abstract class AroundSprite extends Sprite {

	Event event = new Event();

	AroundSprite(Mass[][] map, Position position, int imageNo) {
		super(map, position, imageNo);
	}
	

	/**
	* @return メッセージがあればtrue
	*/
	boolean talked() {
		messageBoard.newMessage(event.getMessage());
		return true;
	}

}