package application.dog;

import application.Dog;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class LightBrownDog extends Dog {

	public LightBrownDog(ImageView view){
        super(40,view,1, 97, -770);
        
        this.images[0] = ImageUtility.lightBrown;
        this.images[1] = ImageUtility.lightBrownRight;
        this.images[2] = ImageUtility.lightBrownLeft;
    }
}
