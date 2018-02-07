package com.momoiropuchoman;

import javax.sound.sampled.*;

import java.io.File;

class AudioPlayer {

	Clip clip;
	FloatControl floatControl;

	AudioPlayer(String fileName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			floatControl.setValue(-20.0f); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	boolean start() {
		try {
			clip.start();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	boolean loop() {
		try {
			clip.loop(5000);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}