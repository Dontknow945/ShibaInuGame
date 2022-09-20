package application.dog;

import application.GameObject;
import application.ImageUtility;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LightBrownDog extends GameObject {
	private Image lightBrownPics[] = {ImageUtility.lightBrown, ImageUtility.lightBrownRight, ImageUtility.lightBrownLeft};
	
	public LightBrownDog(ImageView view){
        super(40,view,1, 97, -770);
    }
	
    @Override
    public void setTranslate(){
        super.setTranslate ();
    }
    
    public void setImage(){
		imagev.setImage(lightBrownPics[pose]);
    }
}
