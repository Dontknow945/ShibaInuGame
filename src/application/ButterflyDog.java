package application;

import javafx.scene.image.ImageView;

public class ButterflyDog extends GameObject {
	public ButterflyDog(ImageView view){
        super(0,0,60,17,132,135,ImageUtility.bfdog,view,-1,0);
    }
    @Override
    public void draw(){
        super.draw (); // call the gameObject draw first
    }
    public void setImage(int z){
    	switch(z){
    	case 0:
			imagev.setImage(ImageUtility.bfdog);
			break;
		case 1:
			imagev.setImage(ImageUtility.bfdog3);
			break;
		case 2:
			imagev.setImage(ImageUtility.bfdog);
			break;
		case 3:
			imagev.setImage(ImageUtility.bfdog4);
			break;
		case 4:
			imagev.setImage(ImageUtility.bfdog2);
			break;
		default:
			break;
    	}
    }
}
