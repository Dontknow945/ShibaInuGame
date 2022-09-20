package application.treeStates;

import application.ImageUtility;
import application.Main;
import application.Tree;
import application.controller.Controller;
import javafx.scene.image.ImageView;

public class FinalState implements State {
	Controller controller = Main.getController();
	
	@Override
	public void grow(Tree tree) {
		int time = controller.getGameTime();
		
		if(time - tree.getTime() == 2) {
			tree.getImageView().setImage (ImageUtility.tree3);
			
			ImageView[] fruits = controller.getFruits();
			int money = controller.getCurMoney();
    		for (int i=0; i<fruits.length; i++) {
    			if(fruits[i].isVisible()) {
    				fruits[i].setVisible(false);
    				money-=5;
    			}
    		}
    		
    		controller.changeMoney(controller.setCurMoney(money));
			tree.setPlanted(false);
			tree.setState(new SeedState());
		}
	}
}
