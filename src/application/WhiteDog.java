package application;

import javafx.scene.image.ImageView;

public class WhiteDog extends GameObject {
    public WhiteDog(ImageView view){
        super(0,view,0, 0, 0);
    }
    @Override
    public void setTranslate(){
        super.setTranslate (); // call the gameObject draw first
    }
    public void setImage(){
    	imagev.setImage(ImageUtility.white);
    }
}
