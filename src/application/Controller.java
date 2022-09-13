package application;

import java.io.File;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller {
	
	
	@FXML				//main pane
	private ImageView 	tree, butterfly, gray, lightBrown, white, waterMelon, picture, info, shop, 
						mainMoney1, mainMoney2, mainMoney3, mainMoney4, mainMoney5, 
						mainThing1, mainThing2, mainThing3, mainThing4, mainThing5, 
						mt1_money1, mt2_money1, mt3_money1, mt4_money1, mt5_money1, 
						mt1_money2, mt2_money2, mt3_money2, mt4_money2, mt5_money2, 
						fruit1, fruit2, fruit3, fruit4, bug1, bug2,
	
						//info pane
						infoClose,
	
						//shop pane
						shopClose, thing1, thing2, thing3, thing4, thing5, detail1, detail2, detail3, detail4, detail5, 
						smoney1, smoney2, smoney3, smoney4, smoney5,
	
						//picture pane
						pictureClose;
	
	@FXML
	private Pane mainPane, infoPane, shopPane, picturePane;

	private AnimationTimer rectangleAnimation;
	private MediaPlayer mediaplayer;
	private GameManager gameManager;
	private Random rand = new Random();
	
	private Image numberImage[] = {ImageUtility.num0, ImageUtility.num1, ImageUtility.num2, ImageUtility.num3, ImageUtility.num4, ImageUtility.num5, ImageUtility.num6, ImageUtility.num7, ImageUtility.num8, ImageUtility.num9};
	private Pane[] panes = new Pane[4];
	private ImageView[] fruits = new ImageView[4];
	private ImageView[][] moneys = new ImageView[5][2];
	private ImageView[][] things = new ImageView[5][2];
	
	private int currentMoney = 100;
	private int countThing1 = 0, countThing2 = 0, countThing3 = 0;
	private int treeSec = 0;
	private long treeTime = 0;
	private boolean seed = false;
	private boolean treeTimeChanged = false;

	@FXML
	private void initialize() {
		gameManager = new GameManager(white, gray, waterMelon, lightBrown, butterfly);
		mediaplayer = new MediaPlayer(new Media(new File("src/resources/sound/dogsound.mp3").toURI().toString()));
		
		panes[0] = mainPane;
		panes[1] = infoPane;
		panes[2] = shopPane;
		panes[3] = picturePane;
		
		fruits[0] = fruit1;
		fruits[1] = fruit2;
		fruits[2] = fruit3;
		fruits[3] = fruit4;
		
		moneys[0][0] = mainMoney1;	moneys[0][1] = smoney1;
		moneys[1][0] = mainMoney2;	moneys[1][1] = smoney2;
		moneys[2][0] = mainMoney3;	moneys[2][1] = smoney3;
		moneys[3][0] = mainMoney4;	moneys[3][1] = smoney4;
		moneys[4][0] = mainMoney5;	moneys[4][1] = smoney5;
		
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
		
		infoClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				infoClose.setImage(ImageUtility.closeBtn2);
			}
		});
		
		shopClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shopClose.setImage(ImageUtility.closeBtn2);
			}
		});
		
		pictureClose.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pictureClose.setImage(ImageUtility.closeBtn2);
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
		
		thing1.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(true);
				thing1.setImage(ImageUtility.thing1b);
			}
		});
		
		thing2.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(true);
				thing2.setImage(ImageUtility.thing2b);
			}
		});
		
		thing3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(true);
				thing3.setImage(ImageUtility.thing3b);
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
		
		infoClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				infoClose.setImage(ImageUtility.closeBtn);
			}
		});
		
		shopClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shopClose.setImage(ImageUtility.closeBtn);
			}
		});
		
		pictureClose.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pictureClose.setImage(ImageUtility.closeBtn);
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
		
		thing1.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(false);
				thing1.setImage(ImageUtility.thing1a);
			}
		});
		
		thing2.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(false);
				thing2.setImage(ImageUtility.thing2a);
			}
		});
		
		thing3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(false);
				thing3.setImage(ImageUtility.thing3a);
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
				setPaneVisible(1, false);
			}
		});
		
		infoClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				setPaneVisible(1, true);
			}
		});
		
		shop.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				setPaneVisible(2, false);
			}
		});
		
		shopClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				setPaneVisible(2, true);
			}
		});
		
		picture.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				setPaneVisible(3, false);
			}
		});
		
		pictureClose.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				setPaneVisible(3, true);
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

		thing1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (currentMoney >= 10) {
					changeMoney(currentMoney -= 10);
					changeThingCount(0, ++countThing1);
				} else {
					System.out.println("thing1 error!");
				}
			}
		});
		
		thing2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (currentMoney >= 20) {
					changeMoney(currentMoney -= 20);
					changeThingCount(1, countThing2 += 5);
				} else {
					System.out.println("thing2 error!");
				}
			}
		});
		
		thing3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (currentMoney >= 30) {
					changeMoney(currentMoney -= 30);
					changeThingCount(2, countThing3 += 5);
				} else {
					System.out.println("thing3 error!");
				}
			}
		});
		
		mainThing1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (seed == false && countThing1 >= 1) {
					changeThingCount(0, --countThing1);
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
					if (countThing2 >= 1) {
						if (bug1.isVisible() == true) {
							bug1.setVisible(false);
						} else if (bug2.isVisible() == true) {
							bug2.setVisible(false);
						}
						changeThingCount(1, --countThing2);
					}
				} else {
					System.out.println("mt2 error!");
				}
			}
		});
		
		mainThing3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (countThing3 >= 1) {
					changeThingCount(2, --countThing3);
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
	
	public void changeMoney(int currentMoney) {
		int[] moneyDigits = new int[5];
		moneyDigits[0] = currentMoney / 10000;
		moneyDigits[1] = (currentMoney - moneyDigits[0] * 10000) / 1000;
		moneyDigits[2] = (currentMoney - moneyDigits[1] * 1000 - moneyDigits[0] * 10000) / 100;
		moneyDigits[3] = (currentMoney - moneyDigits[2] * 100 - moneyDigits[1] * 1000 - moneyDigits[0] * 10000) / 10;
		moneyDigits[4] = currentMoney - moneyDigits[3] * 10 - moneyDigits[2] * 100 - moneyDigits[1] * 1000 - moneyDigits[0] * 10000;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<2; j++) {
				moneys[i][j].setImage(numberImage[moneyDigits[i]]);
			}
		}
	}
	
	public void changeThingCount(int thing, int count) {
		things[thing][0].setImage(numberImage[count / 10]);
		things[thing][1].setImage(numberImage[count - (count / 10) * 10]);
	}
	
	/**
	 * 控制 pane 的顯示，pane 的代碼如下。
	 * <ol start=0>
	 * <li>main pane</li>
	 * <li>info pane</li>
	 * <li>shop pane</li>
	 * <li>picture pane</li>
	 * </ol>
	 * 
	 * @param pane	[0 ~ 4]
	 * @param open	[true 顯示] [false 隱藏]
	 */
	public void setPaneVisible(int pane, boolean open) {
		for (int i=0; i<panes.length; i++) {
			if (i != pane) {
				panes[i].setVisible(open);
			}
		}
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
