package application.treeStates;

import application.ImageUtility;
import application.Main;
import application.Tree;

public class SeedState implements State {
	@Override
	public void grow(Tree tree) {
		int time = Main.getController().getGameTime();
		if(time - tree.getTime() == 2) {
			tree.setTime(time);
			tree.getImageView().setImage(ImageUtility.tree);
			tree.setState(new SeedlingState());
		}
	}
}
