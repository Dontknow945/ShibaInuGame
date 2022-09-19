package application.controller;

import java.io.File;
import java.util.Random;

import application.GameManager;
import application.ImageUtility;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller {
	
	
	@FXML
	private ImageView 	tree, butterfly, gray, lightBrown, white, waterMelon, picture, info, shop, 
						mainMoney1, mainMoney2, mainMoney3, mainMoney4, mainMoney5, 
						mainThing1, mainThing2, mainThing3, mainThing4, mainThing5, 
						mt1_money1, mt2_money1, mt3_money1, mt4_money1, mt5_money1, 
						mt1_money2, mt2_money2, mt3_money2, mt4_money2, mt5_money2, 
						fruit1, fruit2, fruit3, fruit4, bug1, bug2;

	private AnimationTimer rectangleAnimation;
	private MediaPlayer mediaplayer;
	private GameManager gameManager;
	private SceneController sceneController;
	private Random rand = new Random();
	
	private static Image numberImage[] = {ImageUtility.num0, ImageUtility.num1, ImageUtility.num2, ImageUtility.num3, ImageUtility.num4, ImageUtility.num5, ImageUtility.num6, ImageUtility.num7, ImageUtility.num8, ImageUtility.num9};
	private ImageView[] fruits = new ImageView[4];
	private ImageView[] moneys = new ImageView[5];
	private ImageView[][] things = new ImageView[5][2];
	
	private static int currentMoney = 100;
	private static int[] countThings = {0, 0, 0, 0, 0};
	private int treeSec = 0;
	private long treeTime = 0;
	private boolean seed = false;
	private boolean treeTimeChanged = false;

	@FXML
	private void initialize() {
		gameManager = new GameManager(white, gray, waterMelon, lightBrown, butterfly);
		mediaplayer = new MediaPlayer(new Media(new File("src/resources/sound/dogsound.mp3").toURI().toString()));
		
		fruits[0] = fruit1;
		fruits[1] = fruit2;
		fruits[2] = fruit3;
		fruits[3] = fruit4;
		
		moneys[0] = mainMoney1;
		moneys[1] = mainMoney2;
		moneys[2] = mainMoney3;
		moneys[3] = mainMoney4;
		moneys[4] = mainMoney5;
		
		things[0][0] = mt1_money1; things[0][1] = mt1_money2;
		things[1][0] = mt2_money1; things[1][1] = mt2_money2;
		things[2][0] = mt3_money1; things[2][1] = mt3_money2;
		things[3][0] = mt4_money1; things[3][1] = mt4_money2;
		things[4][0] = mt5_money1; things[4][1] = mt5_money2;

		rectangleAnimation = new AnimationTimer() {
			@Override
			public void handle(long timestamp) {
				gameManager.draw(timestamp);

				// tree
				if (treeTimeChanged) {
					treeTime = timestamp;
					treeTimeChanged = false;
				}
				
				if (seed) {
					int treeLife = (int) ((timestamp - treeTime) / 1000000000);
					
					if (treeSec != treeLife) {
						treeSec = treeLife;
						
						switch (treeSec) {
						case 2:
							tree.setImage ( ImageUtility.tree );
							break;
						case 4:
							tree.setImage ( ImageUtility.tree2 );
				    		int randbug = rand.nextInt(3);
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
							break;
						case 6:
							if(bug1.isVisible() || bug2.isVisible()){
				    			tree.setImage ( ImageUtility.tree4 );
				    			changeMoney(currentMoney-=20);
				    		}else{
				    			for (int i=0; i<fruits.length; i++) {
				    				fruits[i].setVisible(true);
				    			}
				    		}
							break;
						case 8:
							bug1.setVisible(false);
							bug2.setVisible(false);
				    		tree.setImage ( ImageUtility.tree3 );
				    		for (int i=0; i<fruits.length; i++) {
				    			if(fruits[i].isVisible()) {
				    				fruits[i].setVisible(false);
				    				currentMoney-=5;
				    			}
				    		}
				    		changeMoney(currentMoney);
				    		seed = false;
							break;
						default:
							break;
						}
					}
				}
			}
		};
		rectangleAnimation.start();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setScene(Scene scene) {
		sceneController = SceneController.getInstance(scene);
		
		/* mouse enter */
		picture.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				picture.setImage(ImageUtility.picBtn2);
			}
		});
		
		shop.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shop.setImage(ImageUtility.shopBtn2);
			}
		});
		
		info.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				info.setImage(ImageUtility.questionBtn2);
			}
		});
		
		butterfly.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 3);
			}
		});
		
		gray.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 1);
			}
		});
		
		lightBrown.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 2);
			}
		});
		
		mainThing1.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing1.setImage(ImageUtility.thing1b);
			}
		});
		
		mainThing2.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing2.setImage(ImageUtility.thing2b);
			}
		});
		
		mainThing3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing3.setImage(ImageUtility.thing3b);
			}
		});
		
		
		/* mouse exit */
		picture.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				picture.setImage(ImageUtility.picBtn);
			}
		});
		
		shop.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shop.setImage(ImageUtility.shopBtn);
			}
		});
		
		info.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				info.setImage(ImageUtility.questionBtn);
			}
		});
		
		butterfly.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(60, 3);
			}
		});
		
		gray.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(40, 1);
			}
		});
		
		lightBrown.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(40, 2);
			}
		});
		
		mainThing1.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing1.setImage(ImageUtility.thing1a);
			}
		});
		
		mainThing2.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing2.setImage(ImageUtility.thing2a);
			}
		});
		
		mainThing3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mainThing3.setImage(ImageUtility.thing3a);
			}
		});

		
		/* mouse click */
		info.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				sceneController.activate("info");
			}
		});
		
		shop.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				sceneController.activate("shop");
			}
		});
		
		picture.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				sceneController.activate("picture");
			}
		});
		
		butterfly.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				playMedia();
			}
		});
		
		gray.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				playMedia();
			}
		});
		
		lightBrown.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				playMedia();
			}
		});
		
		waterMelon.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				playMedia();
			}
		});
		
		mainThing1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (seed == false && countThings[0] >= 1) {
					--countThings[0];
					changeThingCount(0);
					seed = true;
					treeTimeChanged = true;
				} else {
					System.out.println("mt1 error!");
				}
			}
		});
		
		mainThing2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (bug1.isVisible() == true || bug2.isVisible() == true) {
					if (countThings[1] >= 1) {
						if (bug1.isVisible() == true) {
							bug1.setVisible(false);
						} else if (bug2.isVisible() == true) {
							bug2.setVisible(false);
						}
						--countThings[1];
						changeThingCount(1);
					}
				} else {
					System.out.println("mt2 error!");
				}
			}
		});
		
		mainThing3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (countThings[2] >= 1) {
					--countThings[2];
					changeThingCount(2);
				} else {
					System.out.println("mt3 error!");
				}
			}
		});
		
		fruit1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				changeMoney(currentMoney += 10);
				fruit1.setVisible(false);
				gameManager.setDogVisible();
			}
		});
		
		fruit2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				changeMoney(currentMoney += 10);
				fruit2.setVisible(false);
				gameManager.setDogVisible();
			}
		});
		
		fruit3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				changeMoney(currentMoney += 10);
				fruit3.setVisible(false);
				gameManager.setDogVisible();
			}
		});
		
		fruit4.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				changeMoney(currentMoney += 10);
				fruit4.setVisible(false);
				gameManager.setDogVisible();
			}
		});
	}
	
	public Image[] getNumImage() {
		return numberImage;
	}
	
	public int getCurMoney() {
		return currentMoney;
	}
	
	public int setCurMoney(int money) {
		currentMoney = money;
		return currentMoney;
	}
	
	public int[] getCountThings() {
		return countThings;
	}
	
	public void setCountThings(int thing, int count) {
		countThings[thing] = count;
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
	
	public void changeThingCount(int thing) {
		int count = countThings[thing];
		things[thing][0].setImage(numberImage[count / 10]);
		things[thing][1].setImage(numberImage[count - (count / 10) * 10]);
	}
	
	public void playMedia() {
		if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
			mediaplayer.stop();
			mediaplayer.play();
		} else {
			mediaplayer.play();
		}
	}
}
