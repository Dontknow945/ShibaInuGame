package application.dog;

import application.GameObject;
import application.ImageUtility;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GrayDog extends GameObject {
	private Image grayPics[] = {ImageUtility.graydog, ImageUtility.grayRight, ImageUtility.grayLeft};
	
    public GrayDog(ImageView view){
        super(40,view,1,749,-131);
    }
    @Override
    public void setTranslate(){
        super.setTranslate ();
    }
    public void setImage(){
    	imagev.setImage(grayPics[pose]);
    }
}
