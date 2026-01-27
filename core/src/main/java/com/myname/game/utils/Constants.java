package com.myname.game.utils;

public class Constants {

    //World Variables
    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 360;
    public static final float PPM = 1/32f;

    //Player Variables
    public static final float PLAYER_SPEED = 5f;
    public static final float PLAYER_HITBOX_OFFSET_X = 11*PPM;     //Player x + this
    public static final float PLAYER_HITBOX_OFFSET_Y = 1*PPM;
    public static final float PLAYER_HITBOX_OFFSET_WIDTH = 25*PPM; //Player width - this
    public static final float PLAYER_HITBOX_OFFSET_HEIGHT = 26*PPM;

}
