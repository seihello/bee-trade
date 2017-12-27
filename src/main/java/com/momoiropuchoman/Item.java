package com.momoiropuchoman;

class Item {
	private int id;
	private String name;
	private int num;
	private int currentRate;

	Item(int ID, String name, int num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}

	int getID() {
		return id;
	}

	String getName() {
		return name;
	}

	int getNum() {
		return num;
	}

	int getCurrentRate() {
		return currentRate;
	}

	/**
	 *	@param	num	増やす数
	 */
	void add(int num) {
		this.num += num;
	}
}