package application;

import java.util.Random;

import application.controller.Controller;
import javafx.scene.image.ImageView;

public class Tree {
	private int lastUpdateTime;
	private State state;
	private boolean planted;
	private ImageView imageView;
	
	public Tree(ImageView imageView) {
		this.lastUpdateTime = 0;
		this.planted = false;
		this.imageView = imageView;
		state = new SeedState();
	}
	
	public void grow() {
		state.grow(this);
	}
	
	public void setTime(int time) {
		this.lastUpdateTime = time;
	}
	
	public int getTime() {
		return this.lastUpdateTime;
	}
	
	public boolean getPlanted() {
		return this.planted;
	}
	
	public void setPlanted(boolean planted) {
		this.planted = planted;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public ImageView getImageView() {
		return this.imageView;
	}
}

class SeedState implements State {
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

class SeedlingState implements State {
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

class TreeState implements State {
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

class FinalState implements State {
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
