package application.dog;

import application.Dog;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class WatermelonDog extends Dog {
	
    public WatermelonDog(ImageView view){
        super(0,view,0, 0, 0);
        
        this.images[0] = ImageUtility.waterMelon;
        this.images[1] = ImageUtility.waterMelon;
        this.images[2] = ImageUtility.waterMelon;
    }
}
