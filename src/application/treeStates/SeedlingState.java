package application.treeStates;

import java.util.Random;

import application.ImageUtility;
import application.Main;
import application.Tree;
import javafx.scene.image.ImageView;

public class SeedlingState implements State {
	@Override
	public void grow(Tree tree) {
		int time = Main.getController().getGameTime();
		
		if(time - tree.getTime() == 2) {
			tree.setTime(time);
			tree.getImageView().setImage(ImageUtility.tree2);
			
			ImageView bug1 = Main.getController().getBugView(1);
			ImageView bug2 = Main.getController().getBugView(2);
			
			int randbug = new Random().nextInt(3);
    		switch (randbug) {
    		case 0:
    			bug1.setVisible(true);
    			break;
    		case 1:
    			bug2.setVisible(true);
    			break;
    		case 2:
    			bug1.setVisible(true);
    			bug2.setVisible(true);
    			break;
    		default:
    			break;
    		}
    		
			tree.setState(new TreeState());
		}
	}
}
