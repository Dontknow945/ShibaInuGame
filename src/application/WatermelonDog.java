package application;

import javafx.scene.image.ImageView;

public class WatermelonDog extends GameObject {
    public WatermelonDog(ImageView view){
        super(0,0,0,9,100,135,ImageUtility.wmdog,view,0,0);
    }
    @Override
    public void draw(){
        super.draw (); // call the gameObject draw first
    }
    public void setImage(int z){
    	switch(z){
		case 1:
			imagev.setImage(ImageUtility.wmdog2);
			break;
		case -1:
			imagev.setImage(ImageUtility.wmdog);
			break;
		default:
			break;
    	}
    }
}
