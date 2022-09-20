package application.controller;

import application.ImageUtility;
import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShopController {
	@FXML
	private ImageView shopClose, thing1, thing2, thing3, thing4, thing5, 
						detail1, detail2, detail3, detail4, detail5, 
						smoney1, smoney2, smoney3, smoney4, smoney5;
	
	private ImageView[] moneys = new ImageView[5];
	private Image[] numberImage;
	private Controller controller;
	
	@FXML
	private void initialize() {
		moneys[0] = smoney1;
		moneys[1] = smoney2;
		moneys[2] = smoney3;
		moneys[3] = smoney4;
		moneys[4] = smoney5;
		
		controller = Main.getController();
		numberImage = controller.getNumImage();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setScene(Scene scene) {
		shopClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shopClose.setImage(ImageUtility.closeBtn2);
			}
		});
		
		shopClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shopClose.setImage(ImageUtility.closeBtn);
			}
		});
		
		shopClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				SceneController.getInstance(scene).activate("start");
				controller.changeMoney(controller.getCurMoney());
				for(int i=0; i<controller.getThingsCount().length; i++) {
					controller.changeThingCount(i);
				}
			}
		});
		
		thing1.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(true);
				thing1.setImage(ImageUtility.thing1b);
			}
		});
		
		thing1.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(false);
				thing1.setImage(ImageUtility.thing1a);
			}
		});
		
		thing1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				int money = controller.getCurMoney();
				if (money >= 10) {
					changeMoney(controller.setCurMoney(money -= 10));
					controller.setThingsCount(0, ++controller.getThingsCount()[0]);
				} else {
					System.out.println("thing1 error!");
				}
			}
		});
		
		thing2.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(true);
				thing2.setImage(ImageUtility.thing2b);
			}
		});
		
		thing2.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(false);
				thing2.setImage(ImageUtility.thing2a);
			}
		});
		
		thing2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				int money = controller.getCurMoney();
				if (money >= 20) {
					changeMoney(controller.setCurMoney(money -= 20));
					controller.setThingsCount(1, controller.getThingsCount()[1] += 5);
				} else {
					System.out.println("thing2 error!");
				}
			}
		});
		
		thing3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(true);
				thing3.setImage(ImageUtility.thing3b);
			}
		});
		
		thing3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(false);
				thing3.setImage(ImageUtility.thing3a);
			}
		});
		
		thing3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				int money = controller.getCurMoney();
				if (money >= 30) {
					changeMoney(controller.setCurMoney(money -= 30));
					controller.setThingsCount(2, controller.getThingsCount()[2] += 5);
				} else {
					System.out.println("thing3 error!");
				}
			}
		});
	}
	
	public void changeMoney(int currentMoney) {
		int tempMoney = currentMoney;
		moneys[0].setImage(numberImage[tempMoney / 10000]);
		tempMoney %= 10000;
		moneys[1].setImage(numberImage[tempMoney / 1000]);
		tempMoney %= 1000;
		moneys[2].setImage(numberImage[tempMoney / 100]);
		tempMoney %= 100;
		moneys[3].setImage(numberImage[tempMoney / 10]);
		tempMoney %= 10;
		moneys[4].setImage(numberImage[tempMoney]);
	}
}
