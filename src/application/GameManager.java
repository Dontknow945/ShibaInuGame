package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.image.ImageView;

/*
* This class manage the object in game.
*/

public class GameManager {
	private Random rand = new Random();
	private List<GameObject> dogList = new ArrayList<>();
	private List<GameObject> dogVisible;
	private WhiteDog white;
	private GrayDog gray;
	private WatermelonDog watermelon;
	private LightBrownDog lightbrown;
	private ButterflyDog butterfly;
	private long lastUpdateTime = 0;
	private int gameTime = 0, timeCount = 0;
    
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
    	
    	int curTime = (int) (timestamp / 1000000000);
    	if (gameTime != curTime) {
    		gameTime = curTime;
    		timeCount++;
    	}
    	
        for(GameObject dog:dogList){
        	checkBound(dog);
        	doDogActions(elapsedSeconds, dog);
        }
        
        lastUpdateTime = timestamp;
    }
    
    private void checkBound(GameObject dog) {
		if (dog.imagev.getTranslateX() > dog.maxX) {
			dog.x = dog.maxX;
			dog.xDirection *= -1;
		} else if (dog.imagev.getTranslateX() < dog.minX) {
			dog.x = dog.minX;
			dog.xDirection *= -1;
		}
	}
    
    private void doDogActions(double elapsedSeconds, GameObject dog) {
    	if (timeCount - dog.lastTime == dog.changeDirTime) {
    		dog.xDirection *= -1;
    		dog.setTime(timeCount);
        }
    	
    	dog.pose = dog.speed == 0 ? 0 : dog.xDirection == 1 ? 1 : 2;
    	dog.setImage();
    	dog.x += elapsedSeconds * dog.speed * dog.xDirection;
    	dog.setTranslate();
    }
    
    public void setDogVisible(){
		if (dogVisible.size() != 0) {
			int randDog = rand.nextInt(dogVisible.size());
			dogVisible.get(randDog).imagev.setVisible(true);
			dogVisible.remove(randDog);
		}
	}
    
    public void changeSpeed(int speed, int dog){
    	dogList.get(dog).speed = speed;
    }
}
