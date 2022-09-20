package application.dog;

import application.Dog;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class ButterflyDog extends Dog {
	
	public ButterflyDog(ImageView view){
        super(60,view,-1,270,-610);
        
        this.images[0] = ImageUtility.butterflyLeft;
        this.images[1] = ImageUtility.butterflyRight;
        this.images[2] = ImageUtility.butterflyLeft;
    }
}
