package application.controller;

import application.ImageUtility;
import application.SceneManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class PictureController {
	@FXML
	private ImageView pictureClose;
	
	@FXML
	private void initialize() {
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setScene(Scene scene) {
		pictureClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pictureClose.setImage(ImageUtility.closeBtn2);
			}
		});
		
		pictureClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pictureClose.setImage(ImageUtility.closeBtn);
			}
		});
		
		pictureClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				SceneManager.getInstance(scene).activate("start");
			}
		});
	}
}
