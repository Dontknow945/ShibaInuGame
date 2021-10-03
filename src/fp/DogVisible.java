package fp;

import javafx.scene.image.ImageView;

public class DogVisible {
	public DogVisible(){
		
	}
	public void changeVisible(int dc,ImageView orig,ImageView gray,ImageView bf,ImageView wate,ImageView whit){
		switch(dc){
			case 1:
				orig.setVisible(true);
				break;
			case 2:
				gray.setVisible(true);
				break;
			case 3:
				bf.setVisible(true);
				break;
			case 4:
				wate.setVisible(true);
				break;
			case 5:
				whit.setVisible(true);
				break;
			default:
				System.out.println ("dc: " + dc);
				break;
		}
	}
}
