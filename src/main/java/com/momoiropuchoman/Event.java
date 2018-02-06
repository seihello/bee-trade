package com.momoiropuchoman;

import java.util.List;
import java.util.ArrayList;

class Event {
	private List<String> message = new ArrayList<String>();

	Event() {
		message.add("おはよう");
		message.add("こんにちは");
		message.add("こんばんは");
	}

	List<String> getMessage() {
		return message;
	}

}