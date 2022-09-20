package application.treeStates;

import application.ImageUtility;
import application.Main;
import application.Tree;
import application.controller.Controller;
import javafx.scene.image.ImageView;

public class TreeState implements State {
	Controller controller = Main.getController();
	
	@Override
	public void grow(Tree tree) {
		int time = controller.getGameTime();
		
		if(time - tree.getTime() == 2) {
			tree.setTime(time);
			
			ImageView bug1 = controller.getBugView(1);
			ImageView bug2 = controller.getBugView(2);
			
			if(bug1.isVisible() || bug2.isVisible()){
				bug1.setVisible(false);
				bug2.setVisible(false);
    			tree.getImageView().setImage(ImageUtility.tree4);
    			controller.changeMoney(controller.setCurMoney(controller.getCurMoney() - 20));
    		}else{
    			ImageView[] fruits = controller.getFruits();
    			for (int i=0; i<fruits.length; i++) {
    				fruits[i].setVisible(true);
    			}
    		}
			
			tree.setState(new FinalState());
		}
	}
}
