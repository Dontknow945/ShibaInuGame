package application.dog;

import application.GameObject;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class WatermelonDog extends GameObject {
    public WatermelonDog(ImageView view){
        super(0,view,0, 0, 0);
    }
    @Override
    public void setTranslate(){
        super.setTranslate (); // call the gameObject draw first
    }
    public void setImage(){
    	imagev.setImage(ImageUtility.waterMelon);
    }
}
