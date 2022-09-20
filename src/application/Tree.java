package application;

import application.treeStates.SeedState;
import application.treeStates.State;
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
