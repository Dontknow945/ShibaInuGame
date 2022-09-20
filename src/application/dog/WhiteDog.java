package application.dog;

import application.GameObject;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class WhiteDog extends GameObject {
    public WhiteDog(ImageView view){
        super(0,view,0, 0, 0);
    }
    
    public void setImage(){
    	imagev.setImage(ImageUtility.white);
    }
}
