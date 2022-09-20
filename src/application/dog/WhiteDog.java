package application.dog;

import application.Dog;
import application.ImageUtility;
import javafx.scene.image.ImageView;

public class WhiteDog extends Dog {
	
    public WhiteDog(ImageView view){
        super(0,view,0, 0, 0);
        
        this.images[0] = ImageUtility.white;
        this.images[1] = ImageUtility.white;
        this.images[2] = ImageUtility.white;
    }
}
