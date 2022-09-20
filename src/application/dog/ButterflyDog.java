package application.dog;

import application.GameObject;
import application.ImageUtility;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButterflyDog extends GameObject {
	private Image butterflyPics[] = {ImageUtility.butterflyLeft, ImageUtility.butterflyRight, ImageUtility.butterflyLeft};
	
	public ButterflyDog(ImageView view){
        super(60,view,-1,270,-610);
    }
	
    public void setImage(){
    	imagev.setImage(butterflyPics[pose]);
    }
}
