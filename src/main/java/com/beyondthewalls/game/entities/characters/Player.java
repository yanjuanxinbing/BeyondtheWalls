package com.beyondthewalls.game.entities.characters;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player {
    public final Boolean isgril;

    public final double height;
    public final double width;

    public Player(Boolean isgril, double height, double width) {
        this.isgril = isgril;
        this.height = height;
        this.width = width;
    }

}