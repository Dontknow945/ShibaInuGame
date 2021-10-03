package fp;

import javafx.scene.image.ImageView;

public class GrayDog extends GameObject {
    public GrayDog(ImageView view){
        super(0,0,40,17,100,100,ImageUtility.graydog,view,1,0);
    }
    @Override
    public void draw(){
        super.draw (); // call the gameObject draw first
    }
    public void setImage(int z){
    	switch(z){
    	case 0:
			imagev.setImage(ImageUtility.graydog2);
			break;
		case 1:
			imagev.setImage(ImageUtility.gd3);
			break;
		case 2:
			imagev.setImage(ImageUtility.gd1);
			break;
		case 3:
			imagev.setImage(ImageUtility.gd4);
			break;
		case 4:
			imagev.setImage(ImageUtility.gd2);
			break;
		default:
			break;
    	}
    }
}
