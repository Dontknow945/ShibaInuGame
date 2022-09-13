package application;

import java.util.Random;

import javafx.scene.image.ImageView;

public abstract class GameObject {
	protected double x;
    protected int maxX, minX;
    protected int speed;
    protected int lastTime;
    protected int changeDirTime;
    protected int xDirection;
    protected int pose;
    protected ImageView imagev;
    private Random rand = new Random();

    public GameObject(int speed, ImageView imagev, int xdirect, int maxX, int minX)
    {
        this.x = 0;
        this.maxX = maxX;
        this.minX = minX;
        this.speed = speed;
        this.lastTime = 0;
        this.changeDirTime = rand.nextInt(10) + 5;
        this.xDirection = xdirect;
        this.pose = 0;
        this.imagev = imagev;
        
    }

    public void setTranslate(){
    	imagev.setTranslateX(x);
    }
    
    public void setTime(int time) {
    	lastTime = time;
    	changeDirTime = rand.nextInt(10) + 5;
    }
    
    public abstract void setImage();
}
