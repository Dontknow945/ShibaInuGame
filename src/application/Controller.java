package application;

import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller {
	@FXML	//mp
	private ImageView back, water, tree, bf, coin, gray, orig, unknown1, unknown2, pic, que, shop, whit, 
			wate, conver, money1, money2, money3, money4, money5, mt1, mt2, mt3, mt4, mt5, place, mtm11, 
			mtm12, mtm21, mtm22, mtm31, mtm32, mtm41, mtm42, mtm51, mtm52, fr1, fr2, fr3, fr4, bug1, bug2;
	
	@FXML	//inp
	private ImageView q3, inf; 
	
	@FXML	//sp
	private ImageView s3, shopbg, thing1, thing2, thing3, thing4, thing5, price1, price2, price3, price4, 
			price5, detail1, detail2, detail3, detail4, detail5, smoney1, smoney2, smoney3, smoney4, smoney5, 
			scoin, t1m1, t1m2, t2m1, t2m2, t3m1, t3m2, t4m1, t4m2, t5m1, t5m2;
	
	@FXML	//pp
	private ImageView p3, pbg, picture1, picture2, picture3, picture4, picture5, picture6, picture7, picture8,
			pd1, pd2, pd3, pd4, pd5, pd6, pd7, orid, btd, gdd, wdd, wd, unknown1d, unknown2d;
	
	@FXML
	private Pane mp, inp, sp, pp;

	private AnimationTimer rectangleAnimation;
	private MediaPlayer mediaplayer;
	private GameManager gameManager;
	private money moneyy;
	private ThingNum thing;
	private DogVisible dogvis;
	private Tree treee;

	// movement
	private int op = 0;

	// money
	private int tmon = 100, omon = 0, mon1 = 0, mon2 = 0, mon3 = 1, mon4 = 0, mon5 = 0;

	// things' number
	private int t1c = 0, ot1c = 0, t1c1 = 0, t1c2 = 0;
	private int t2c = 0, ot2c = 0, t2c1 = 0, t2c2 = 0;
	private int t3c = 0, ot3c = 0, t3c1 = 0, t3c2 = 0;
	private int t4c = 0, ot4c = 0, t4c1 = 0, t4c2 = 0;
	private int t5c = 0, ot5c = 0, t5c1 = 0, t5c2 = 0;

	// tree
	private int ttime = 0;
	private boolean seed = false;

	// dogs count
	private int dc = 0;
	private int thing4c = 0;
	private int thing5c = 0;

	@FXML
	private void initialize() {
		gameManager = new GameManager(whit, gray, wate, orig, bf);	// initialize the GameManager
		mediaplayer = new MediaPlayer(new Media(new File("src/resources/sound/dogsound.mp3").toURI().toString()));
		moneyy = new money();
		thing = new ThingNum();
		treee = new Tree();
		dogvis = new DogVisible();

		rectangleAnimation = new AnimationTimer() {
			@Override
			public void handle(long timestamp) {
				gameManager.draw(timestamp);

				op++;

				if (gray.getTranslateX() > 749) {
					gameManager.resetpos(749, 1);
					gameManager.moveDogX(1);
				} else if (gray.getTranslateX() < -131) {
					gameManager.resetpos(-131, 1);
					gameManager.moveDogX(1);
				}

				if (orig.getTranslateX() > 97) {
					gameManager.resetpos(97, 2);
					gameManager.moveDogX(2);
				} else if (orig.getTranslateX() < -770) {
					gameManager.resetpos(-770, 2);
					gameManager.moveDogX(2);
				}

				if (bf.getTranslateX() > 270) {
					gameManager.resetpos(270, 3);
					gameManager.moveDogX(3);
				} else if (bf.getTranslateX() < -610) {
					gameManager.resetpos(-610, 3);
					gameManager.moveDogX(3);
				}

				// money
				if (omon != tmon) {
					mon5 = tmon / 10000;
					mon4 = (tmon - mon5 * 10000) / 1000;
					mon3 = (tmon - mon4 * 1000 - mon5 * 10000) / 100;
					mon2 = (tmon - mon3 * 100 - mon4 * 1000 - mon5 * 10000) / 10;
					mon1 = tmon - mon2 * 10 - mon3 * 100 - mon4 * 1000 - mon5 * 10000;

					moneyy.changeMoney(mon5, mon4, mon3, mon2, mon1, money5, money4, money3, money2, 
							money1, smoney5, smoney4, smoney3, smoney2, smoney1);
				}

				// things
				if (ot1c != t1c || ot2c != t2c || ot3c != t3c || ot4c != t4c || ot5c != t5c) {
					t1c1 = t1c / 10;
					t1c2 = t1c - t1c1 * 10;
					t2c1 = t2c / 10;
					t2c2 = t2c - t2c1 * 10;
					t3c1 = t3c / 10;
					t3c2 = t3c - t3c1 * 10;
					t4c1 = t4c / 10;
					t4c2 = t4c - t4c1 * 10;
					t5c1 = t5c / 10;
					t5c2 = t5c - t5c1 * 10;

					thing.changeThingCount(t1c1, t1c2, t2c1, t2c2, t3c1, t3c2, t4c1, t4c2, t5c1, t5c2, mtm11,
							mtm12, mtm21, mtm22, mtm31, mtm32, mtm41, mtm42, mtm51, mtm52);
				}

				// tree
				if (seed == true) {
					if (op % 10 == 0) {
						ttime += 1;
					}

					if (ttime == 10 || ttime == 25 || ttime == 40 || ttime == 50) {
						treee.treeChanging(ttime, tree, fr1, fr2, fr3, fr4, omon, tmon, seed, bug1, bug2);
					}

					if (ttime == 50) {
						seed = false;
						ttime = 0;
					}
				}
			}
		};
		rectangleAnimation.start();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setScene(Scene scene) {
		// dog
		pic.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pic.setImage(ImageUtility.pic2);
			}
		});
		pic.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				pic.setImage(ImageUtility.pic);
			}
		});

		shop.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shop.setImage(ImageUtility.shop2);
			}
		});
		shop.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				shop.setImage(ImageUtility.shop);
			}
		});

		que.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				que.setImage(ImageUtility.que2);
			}
		});
		que.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				que.setImage(ImageUtility.que);
			}
		});

		q3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				q3.setImage(ImageUtility.close2);
			}
		});
		q3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				q3.setImage(ImageUtility.close);
			}
		});

		s3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				s3.setImage(ImageUtility.close2);
			}
		});
		s3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				s3.setImage(ImageUtility.close);
			}
		});

		p3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				p3.setImage(ImageUtility.close2);
			}
		});
		p3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				p3.setImage(ImageUtility.close);
			}
		});

		bf.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 3);
			}
		});
		bf.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(60, 3);
			}
		});

		gray.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 1);
			}
		});
		gray.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(40, 1);
			}
		});

		orig.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(0, 2);
			}
		});
		orig.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				gameManager.changeSpeed(40, 2);
			}
		});

		thing1.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(true);
				thing1.setImage(ImageUtility.t11);
			}
		});
		thing1.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail1.setVisible(false);
				thing1.setImage(ImageUtility.t1);
			}
		});

		thing2.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(true);
				thing2.setImage(ImageUtility.t12);
			}
		});
		thing2.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail2.setVisible(false);
				thing2.setImage(ImageUtility.t2);
			}
		});

		thing3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(true);
				thing3.setImage(ImageUtility.t13);
			}
		});
		thing3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail3.setVisible(false);
				thing3.setImage(ImageUtility.t3);
			}
		});

		thing4.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail4.setVisible(true);
				// thing4.setImage(ImageUtility.t14);
			}
		});
		thing4.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail4.setVisible(false);
				// thing4.setImage(ImageUtility.t4);
			}
		});

		thing5.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail5.setVisible(true);
				// thing5.setImage(ImageUtility.t15);
			}
		});
		thing5.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				detail5.setVisible(false);
				// thing5.setImage(ImageUtility.t5);
			}
		});
		mt1.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt1.setImage(ImageUtility.t11);
			}
		});
		mt1.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt1.setImage(ImageUtility.t1);
			}
		});

		mt2.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt2.setImage(ImageUtility.t12);
			}
		});
		mt2.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt2.setImage(ImageUtility.t2);
			}
		});

		mt3.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt3.setImage(ImageUtility.t13);
			}
		});
		mt3.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mt3.setImage(ImageUtility.t3);
			}
		});

		mt4.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				// mt4.setImage(ImageUtility.t14);
			}
		});
		mt4.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				// mt4.setImage(ImageUtility.t4);
			}
		});

		mt5.setOnMouseEntered(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				// mt5.setImage(ImageUtility.t15);
			}
		});
		mt5.setOnMouseExited(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				// mt5.setImage(ImageUtility.t5);
			}
		});

		// pane
		que.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(false);
				sp.setVisible(false);
				pp.setVisible(false);
			}
		});
		q3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(true);
				sp.setVisible(true);
				pp.setVisible(true);
			}
		});
		shop.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(false);
				inp.setVisible(false);
				pp.setVisible(false);
			}
		});
		s3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(true);
				inp.setVisible(true);
				pp.setVisible(true);
			}
		});
		pic.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(false);
				inp.setVisible(false);
				sp.setVisible(false);
			}
		});
		p3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				mp.setVisible(true);
				inp.setVisible(true);
				sp.setVisible(true);
			}
		});
		bf.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});
		gray.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});
		orig.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});

		unknown1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});

		unknown2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});
		
		wate.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
					mediaplayer.stop();
					mediaplayer.play();
				}
				mediaplayer.play();
			}
		});
		thing1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (tmon >= 10) {
					omon = tmon;
					tmon -= 10;
					ot1c = t1c;
					t1c++;
				} else {
					System.out.println("error!");
				}
			}
		});
		thing2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (tmon >= 20) {
					omon = tmon;
					tmon -= 20;
					ot2c = t2c;
					t2c += 5;
				} else {
					System.out.println("error!");
				}
			}
		});
		thing3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (tmon >= 30) {
					omon = tmon;
					tmon -= 30;
					ot3c = t3c;
					t3c += 5;
				} else {
					System.out.println("error!");
				}
			}
		});
		thing4.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (thing4c == 0 && tmon >= 90) {
					thing4c += 1;
					omon = tmon;
					tmon -= 90;
					ot4c = t4c;
					t4c++;
				} else {
					System.out.println("error!");
				}
			}
		});
		thing5.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (thing5c == 0 && tmon >= 90 && unknown1.isVisible() == true) {
					thing5c += 1;
					omon = tmon;
					tmon -= 90;
					ot5c = t5c;
					t5c++;
				} else {
					System.out.println("error!");
				}
			}
		});
		mt1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (seed == false && t1c >= 1) {
					ot1c = t1c;
					t1c--;
					seed = true;
				} else {
					System.out.println("error!");
				}
			}
		});
		mt2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (bug1.isVisible() == true || bug2.isVisible() == true) {
					if (t2c >= 1) {
						if (bug1.isVisible() == true) {
							bug1.setVisible(false);
						} else if (bug2.isVisible() == true) {
							bug2.setVisible(false);
						}
						ot2c = t2c;
						t2c--;
					}
				} else {
					System.out.println("error!");
				}
			}
		});
		mt3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (t3c >= 1) {
					ot3c = t3c;
					t3c--;
				} else {
					System.out.println("error!");
				}
			}
		});
		mt4.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (thing4c == 1 && t4c >= 1 && dc >= 6) {
					ot4c = t4c;
					t4c--;
					thing4c += 1;
				} else {
					System.out.println("error!");
				}
			}
		});
		mt5.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				if (thing5c == 1 && t5c >= 1 && dc >= 6) {
					ot5c = t5c;
					t5c--;
					thing5c += 1;
				} else {
					System.out.println("error!");
				}
			}
		});
		fr1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				omon = tmon;
				tmon += 10;
				fr1.setVisible(false);
				dc++;
				dogvis.changeVisible(dc, orig, gray, bf, wate, whit);
			}
		});
		fr2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				omon = tmon;
				tmon += 10;
				fr2.setVisible(false);
				dc++;
				dogvis.changeVisible(dc, orig, gray, bf, wate, whit);
			}
		});
		fr3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				omon = tmon;
				tmon += 10;
				fr3.setVisible(false);
				dc++;
				dogvis.changeVisible(dc, orig, gray, bf, wate, whit);
			}
		});
		fr4.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				omon = tmon;
				tmon += 10;
				fr4.setVisible(false);
				dc++;
				dogvis.changeVisible(dc, orig, gray, bf, wate, whit);
			}
		});
	}
}
