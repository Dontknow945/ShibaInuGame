package application.controller;

import application.ImageUtility;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class InfoController {
	@FXML
	private ImageView infoClose;
	
	@FXML
	private void initialize() {
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setScene(Scene scene) {
		infoClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				infoClose.setImage(ImageUtility.closeBtn2);
			}
		});
		
		infoClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				infoClose.setImage(ImageUtility.closeBtn);
			}
		});
		
		infoClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				SceneController.getInstance(scene).activate("start");
			}
		});
	}
}
