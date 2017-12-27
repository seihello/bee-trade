package com.momoiropuchoman;

interface Common {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, NO
    }

    public static final int MASS_X_NUM = 15;
    public static final int MASS_Y_NUM = 15;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int BAR = 22;

    public static final int MASS_SIZE = WIDTH / MASS_X_NUM;
    public static final int CS = 32;

    public static final int SPRITE_ADJUST = MASS_SIZE / 4;

    public static final String path = "/Users/bonds-3164/Library/RPG/";
}