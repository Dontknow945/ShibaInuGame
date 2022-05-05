package application;

import javafx.scene.image.ImageView;

public class LightBrownDog extends GameObject {
	public LightBrownDog(ImageView view){
        super(0,0,40,17,118,113,ImageUtility.ordog,view,1,0);
    }
    @Override
    public void draw(){
        super.draw (); // call the gameObject draw first
    }
    public void setImage(int z){
    	switch(z){
    	case 0:
			imagev.setImage(ImageUtility.ordog);
			break;
		case 1:
			imagev.setImage(ImageUtility.ordog3);
			break;
		case 2:
			imagev.setImage(ImageUtility.ordog1);
			break;
		case 3:
			imagev.setImage(ImageUtility.ordog4);
			break;
		case 4:
			imagev.setImage(ImageUtility.ordog2);
			break;
		default:
			break;
    	}
    }
}
