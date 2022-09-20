package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.dog.ButterflyDog;
import application.dog.GrayDog;
import application.dog.LightBrownDog;
import application.dog.WatermelonDog;
import application.dog.WhiteDog;
import javafx.scene.image.ImageView;

/*
* This class manage the object in game.
*/

public class GameManager {
	private Random rand = new Random();
	private List<Dog> dogList = new ArrayList<>();
	private List<Dog> dogVisible;
	private WhiteDog white;
	private GrayDog gray;
	private WatermelonDog watermelon;
	private LightBrownDog lightbrown;
	private ButterflyDog butterfly;
	private long lastUpdateTime = 0;
    
    public GameManager(ImageView whitev, ImageView grayv, ImageView watermelonv, ImageView lightbrownv, ImageView butterflyv)
    {
        white = new WhiteDog(whitev);
        gray = new GrayDog(grayv);
        watermelon = new WatermelonDog(watermelonv);
        lightbrown = new LightBrownDog(lightbrownv);
        butterfly = new ButterflyDog(butterflyv);
        dogList.add(white);
        dogList.add(gray);
        dogList.add(lightbrown);
        dogList.add(butterfly);
        dogList.add(watermelon);
        dogVisible = new ArrayList<>(dogList);
    }
    
    // Draw method, being called at Controller's animation timer.
    public void draw(long timestamp){
    	final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
    	
        for(Dog dog:dogList){
        	checkBound(dog);
        	doDogActions(elapsedSeconds, dog);
        }
        
        lastUpdateTime = timestamp;
    }
    
    private void checkBound(Dog dog) {
		if (dog.imagev.getTranslateX() > dog.maxX) {
			dog.x = dog.maxX;
			dog.xDirection *= -1;
		} else if (dog.imagev.getTranslateX() < dog.minX) {
			dog.x = dog.minX;
			dog.xDirection *= -1;
		}
	}
    
    private void doDogActions(double elapsedSeconds, Dog dog) {
    	int gameTime = Main.getController().getGameTime();
    	if (gameTime - dog.lastTime == dog.changeDirTime) {
    		dog.xDirection *= -1;
    		dog.setTime(gameTime);
        }
    	
    	turnSide(dog);
    	
    	dog.x += elapsedSeconds * dog.speed * dog.xDirection;
    	dog.setTranslate();
    }
    
    public void setDogVisible(){
		if (dogVisible.size() != 0) {
			int randDog = rand.nextInt(dogVisible.size());
			dogVisible.get(randDog).imagev.setVisible(true);
			dogVisible.get(randDog).setTime(Main.getController().getGameTime());
			dogVisible.remove(randDog);
		}
	}
    
    public void changeSpeed(int speed, int dogIndex){
    	dogList.get(dogIndex).speed = speed;
    	turnSide(dogList.get(dogIndex));
    }
    
    public void turnSide(Dog dog) {
    	if(dog.speed == 0) {
    		dog.stop();
    	} else if(dog.xDirection == 1) {
    		dog.turnRight();
    	} else if(dog.xDirection == -1) {
			dog.turnLeft();
		} else {
			System.out.println("turn error");
		}
    }
}
