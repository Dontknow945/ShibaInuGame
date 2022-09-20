package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Dog {
	protected double x;
    protected int maxX, minX;
    protected int speed;
    protected int lastTime;
    protected int changeDirTime;
    protected int xDirection;
    protected int pose;
    protected ImageView imagev;
    protected Image[] images;
    private Random rand = new Random();

    public Dog(int speed, ImageView imagev, int xdirect, int maxX, int minX)
    {
        this.x = 0;
        this.maxX = maxX;
        this.minX = minX;
        this.speed = speed;
        this.xDirection = xdirect;
        this.pose = 0;
        this.imagev = imagev;
        this.images = new Image[3];
    }

    public void setTranslate(){
    	imagev.setTranslateX(x);
    }
    
    public void setTime(int time) {
    	lastTime = time;
    	changeDirTime = rand.nextInt(10) + 5;
    }
    
    public void stop() {
    	imagev.setImage(images[0]);
    }
    
    public void turnRight() {
    	imagev.setImage(images[1]);
    }
    
    public void turnLeft() {
    	imagev.setImage(images[2]);
    }
}
