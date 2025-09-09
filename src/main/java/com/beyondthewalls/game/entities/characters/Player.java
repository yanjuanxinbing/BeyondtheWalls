package com.beyondthewalls.game.entities.characters;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player {
    // 角色属性
    private double width;
    private double height;
    private double bounceForce; // 弹跳力
    private double moveSpeed;   // 平移速度

    // 角色状态
    private boolean isOnGround = false;
    private double velocityY = 0;
    private double velocityX = 0;
    private boolean facingRight = true;

    // 外观相关
    private ImageView characterView;
    private Image[] idleImages;
    private Image[] walkImages;
    private Image[] jumpImages;
    private int currentFrame = 0;
    private Timeline animationTimeline;

    // 物理常量
    private static final double GRAVITY = 0.5;
    private static final double MAX_FALL_SPEED = 10;

    public void GameCharacter(double width, double height, double bounceForce, double moveSpeed) {
        this.width = width;
        this.height = height;
        this.bounceForce = bounceForce;
        this.moveSpeed = moveSpeed;

        // 创建角色视图
        characterView = new ImageView();
        characterView.setFitWidth(width);
        characterView.setFitHeight(height);

        // 初始化动画时间线
        setupAnimation();
    }

    private void setupAnimation() {
        // 这里应该加载实际的图像资源
        // 示例代码，实际使用时需要替换为真实图像路径
        idleImages = new Image[4];
        walkImages = new Image[6];
        jumpImages = new Image[3];

        for (int i = 0; i < idleImages.length; i++) {
            idleImages[i] = new Image("character/idle_" + i + ".png");
        }
        for (int i = 0; i < walkImages.length; i++) {
            walkImages[i] = new Image("character/walk_" + i + ".png");
        }
        for (int i = 0; i < jumpImages.length; i++) {
            jumpImages[i] = new Image("character/jump_" + i + ".png");
        }

        // 设置初始图像
        characterView.setImage(idleImages[0]);

        // 创建动画时间线
        animationTimeline = new Timeline(
                new KeyFrame(Duration.millis(100), e -> updateAnimation())
        );
        animationTimeline.setCycleCount(Animation.INDEFINITE);
        animationTimeline.play();
    }

    private void updateAnimation() {
        Image[] currentAnimation;

        if (!isOnGround) {
            currentAnimation = jumpImages;
        } else if (Math.abs(velocityX) > 0.1) {
            currentAnimation = walkImages;
        } else {
            currentAnimation = idleImages;
        }

        // 更新帧
        currentFrame = (currentFrame + 1) % currentAnimation.length;
        characterView.setImage(currentAnimation[currentFrame]);

        // 根据朝向翻转图像
        if ((facingRight && characterView.getScaleX() < 0) ||
                (!facingRight && characterView.getScaleX() > 0)) {
            characterView.setScaleX(characterView.getScaleX() * -1);
        }
    }

    // 移动控制方法
    public void moveLeft() {
        velocityX = -moveSpeed;
        facingRight = false;
    }

    public void moveRight() {
        velocityX = moveSpeed;
        facingRight = true;
    }

    public void stopMoving() {
        velocityX = 0;
    }

    public void jump() {
        if (isOnGround) {
            velocityY = -bounceForce;
            isOnGround = false;
        }
    }

    // 更新角色状态
    public void update() {
        // 应用重力
        if (!isOnGround) {
            velocityY += GRAVITY;
            if (velocityY > MAX_FALL_SPEED) {
                velocityY = MAX_FALL_SPEED;
            }
        }

        // 更新位置
        double newX = characterView.getTranslateX() + velocityX;
        double newY = characterView.getTranslateY() + velocityY;

        characterView.setTranslateX(newX);
        characterView.setTranslateY(newY);

        // 这里应该添加碰撞检测逻辑
        // 例如检测是否落地，与平台碰撞等
    }

    // 设置角色位置
    public void setPosition(double x, double y) {
        characterView.setTranslateX(x);
        characterView.setTranslateY(y);
    }

    // 获取角色视图
    public ImageView getView() {
        return characterView;
    }

    // 设置角色形象
    public void setCharacterAppearance(Image[] idle, Image[] walk, Image[] jump) {
        this.idleImages = idle;
        this.walkImages = walk;
        this.jumpImages = jump;
    }

    // 属性访问器
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        characterView.setFitWidth(width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        characterView.setFitHeight(height);
    }

    public double getBounceForce() {
        return bounceForce;
    }

    public void setBounceForce(double bounceForce) {
        this.bounceForce = bounceForce;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public boolean isOnGround() {
        return isOnGround;
    }

    public void setOnGround(boolean onGround) {
        isOnGround = onGround;
        if (onGround) {
            velocityY = 0;
        }
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    // 碰撞检测辅助方法
    public Rectangle getBounds() {
        return new Rectangle(
                characterView.getTranslateX(),
                characterView.getTranslateY(),
                width,
                height
        );
    }
}