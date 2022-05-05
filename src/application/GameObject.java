package application;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/*
* This class is the basic object in Game.
* It has the basic property for game object,
* such like position, width, height, image.
* It also has some basic method : draw, move.
*/
public abstract class GameObject {
	protected double x;
    protected double y;
    protected int speed;
    protected int posSpeed;
    protected double width;
    protected double height;
    protected Image image;
    protected ImageView imagev;
    protected int xDirection;
    protected int yDirection;
    boolean a = false;

    public GameObject(double x,double y,int speed,int posspeed,double width,double height,Image image, ImageView imagev, int xdirect,int ydirect)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.posSpeed = posspeed;
        this.width = width;
        this.height = height;
        this.image = image;
        this.imagev = imagev;
        this.xDirection = xdirect;
        this.yDirection = ydirect;
    }

    public void draw(){
    	imagev.setTranslateX(x);
        imagev.setTranslateY(y);
    }
    public void move(double deltaX,double deltaY){
    	x+=deltaX;
    	y+=deltaY;
    }
    public void resetPos(int xpos){
    	x=xpos;
    	y=0;
    }
}
