package application;
	
import application.controller.MainController;
import application.controller.InfoController;
import application.controller.PictureController;
import application.controller.ShopController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	private static MainController controller = new MainController();
	private static ShopController shopController = new ShopController();
	private static InfoController infoController = new InfoController();
	private static PictureController pictureController = new PictureController();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/shop.fxml"));
	        fxmlLoader.setController(shopController);
	        Pane root = fxmlLoader.load();
	        Scene scene = new Scene (root, 980, 633);
	        SceneManager sceneController = SceneManager.getInstance(scene);
	        sceneController.addScene("shop", root);
	        shopController.setScene(scene);
	        
	        fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/info.fxml"));
	        fxmlLoader.setController(infoController);
	        root = fxmlLoader.load();
	        sceneController.addScene("info", root);
	        sceneController.activate("info");
	        infoController.setScene(scene);
	        
	        fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/picture.fxml"));
	        fxmlLoader.setController(pictureController);
	        root = fxmlLoader.load();
	        sceneController.addScene("picture", root);
	        sceneController.activate("picture");
	        pictureController.setScene(scene);
	        
	        fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/start.fxml"));
	        fxmlLoader.setController(controller);
	        root = fxmlLoader.load();
	        sceneController.addScene("start", root);
	        sceneController.activate("start");
	        controller.setScene(scene);
	        
	       	primaryStage.setScene(scene);
	       	primaryStage.setTitle("柴柴君");
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MainController getController() {
		return controller;
	}
	
	public static ShopController getShopController() {
		return shopController;
	}
	
	public static InfoController getInfoController() {
		return infoController;
	}
	
	public static PictureController getPictureController() {
		return pictureController;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
