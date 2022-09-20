package application.dog;

import application.Dog;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class GrayDog extends Dog {

	public GrayDog(ImageView view){
        super(40,view,1,749,-131);
        
        this.images[0] = ImageUtility.graydog;
        this.images[1] = ImageUtility.grayRight;
        this.images[2] = ImageUtility.grayLeft;
    }
}
