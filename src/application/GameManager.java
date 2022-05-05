package application;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

/*
* This class manage the object in game.
*/

public class GameManager {
	private List<GameObject> objectList = new ArrayList<>(); //All the GameObject in game is store in this List.
	private WhiteDog white;
	private GrayDog gray;
	private WatermelonDog watermelon;
	private LightBrownDog lightbrown;
	private ButterflyDog butterfly;
	private long lastUpdateTime = 0;
	private int count = 0, whitepos = 1, watermelonpos = 1, 
			graypos = 1, graycase = 1, lightbrownpos = 1, lightbrowncase = 1, 
			butterflypos = 1, butterflycase = 1;
    
    public GameManager(ImageView whitev, ImageView grayv, ImageView watermelonv, ImageView lightbrownv, ImageView butterflyv)
    {
        white = new WhiteDog(whitev);
        gray = new GrayDog(grayv);
        watermelon = new WatermelonDog(watermelonv);
        lightbrown = new LightBrownDog(lightbrownv);
        butterfly = new ButterflyDog(butterflyv);
        objectList.add(white);
        objectList.add(gray);
        objectList.add(lightbrown);
        objectList.add(butterfly);
    }
    
    // Draw method, being called at Controller's animation timer.
    public void draw(long timestamp){
    	final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
    	double deltaX, deltaY;
    	count++;
    	
    	///white///
    	if (count % white.posSpeed == 0) {whitepos *= -1;}
    	white.setImage(whitepos);
    	deltaX = elapsedSeconds * white.speed * white.xDirection;
        deltaY = elapsedSeconds * white.speed * white.yDirection;
        white.move(deltaX, deltaY);
    	
        ///watermelon///
        if (count % watermelon.posSpeed == 0) {watermelonpos *= -1;}
        watermelon.setImage(watermelonpos);
    	deltaX = elapsedSeconds * watermelon.speed * watermelon.xDirection;
        deltaY = elapsedSeconds * watermelon.speed * watermelon.yDirection;
        watermelon.move(deltaX, deltaY);
        
    	///gray///
    	if (count % 700 == 0) {gray.xDirection *= -1;}
    	if (count % gray.posSpeed == 0) {graypos *= -1;}
    	if (gray.speed == 0) {
    		graycase = 0;
    	} else if (graypos == 1) {
    		if (gray.xDirection == 1){graycase = 1;}
    		else {graycase = 2;}
    	} else if (graypos == -1) {
    		if (gray.xDirection == 1){graycase = 3;}
    		else {graycase = 4;}
    	}
    	gray.setImage(graycase);
    	deltaX = elapsedSeconds * gray.speed * gray.xDirection;
        deltaY = elapsedSeconds * gray.speed * gray.yDirection;
        gray.move(deltaX, deltaY);
        
        ///lightbrown///
        if (count % 570 == 0) {lightbrown.xDirection *= -1;}
    	if (count % lightbrown.posSpeed == 0) {lightbrownpos *= -1;}
    	if (lightbrown.speed == 0) {
    		lightbrowncase = 0;
    	} else if (lightbrownpos == 1) {
    		if (lightbrown.xDirection == 1){lightbrowncase = 1;}
    		else {lightbrowncase = 2;}
    	} else if (lightbrownpos == -1) {
    		if (lightbrown.xDirection == 1){lightbrowncase = 3;}
    		else {lightbrowncase = 4;}
    	}
    	lightbrown.setImage(lightbrowncase);
    	deltaX = elapsedSeconds * lightbrown.speed * lightbrown.xDirection;
        deltaY = elapsedSeconds * lightbrown.speed * lightbrown.yDirection;
        lightbrown.move(deltaX, deltaY);
        
        ///butterfly///
        if (count % 666 == 0) {butterfly.xDirection *= -1;}
    	if (count % butterfly.posSpeed == 0) {butterflypos *= -1;}
    	if (butterfly.speed == 0) {
    		butterflycase = 0;
    	} else if (butterflypos == 1) {
    		if (butterfly.xDirection == 1){butterflycase = 1;}
    		else {butterflycase = 2;}
    	} else if (butterflypos == -1) {
    		if (butterfly.xDirection == 1){butterflycase = 3;}
    		else {butterflycase = 4;}
    	}
    	butterfly.setImage(butterflycase);
    	deltaX = elapsedSeconds * butterfly.speed * butterfly.xDirection;
        deltaY = elapsedSeconds * butterfly.speed * butterfly.yDirection;
        butterfly.move(deltaX, deltaY);
        
        ///draw///
        for(GameObject obj:objectList){
            obj.draw();
        }
        lastUpdateTime = timestamp;
    }
    
    public void moveDogX(int dog){
    	switch (dog) {
    	case 1:
    		gray.xDirection *= -1;
    		break;
    	case 2:
    		lightbrown.xDirection *= -1;
    		break;
    	case 3:
    		butterfly.xDirection *= -1;
    		break;
    	default:
    		break;
    	}
    }
    public void moveDogY(int dog){
    	switch (dog) {
    	case 1:
    		gray.yDirection *= -1;
    		break;
    	case 2:
    		lightbrown.yDirection *= -1;
    		break;
    	case 3:
    		butterfly.yDirection *= -1;
    		break;
    	default:
    		break;
    	}
    }
    public void resetpos(int xpos, int dog){
    	switch (dog) {
    	case 1:
    		gray.resetPos(xpos);
    		break;
    	case 2:
    		lightbrown.resetPos(xpos);
    		break;
    	case 3:
    		butterfly.resetPos(xpos);
    		break;
    	default:
    		break;
    	}
    }
    public void changeSpeed(int speed, int dog){
    	switch (dog) {
    	case 1:
    		gray.speed = speed;
    		break;
    	case 2:
    		lightbrown.speed = speed;
    		break;
    	case 3:
    		butterfly.speed = speed;
    		break;
    	default:
    		break;
    	}
    }
}
