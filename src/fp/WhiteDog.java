package fp;

import javafx.scene.image.ImageView;

public class WhiteDog extends GameObject {
    public WhiteDog(ImageView view){
        super(0,0,0,35,144,93,ImageUtility.whitedog,view,0,0);
    }
    @Override
    public void draw(){
        super.draw (); // call the gameObject draw first
    }
    public void setImage(int z){
    	switch(z){
		case 1:
			imagev.setImage(ImageUtility.whitedog2);
			break;
		case -1:
			imagev.setImage(ImageUtility.whitedog);
			break;
		default:
			break;
    	}
    }
}
