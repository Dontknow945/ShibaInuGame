package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/start.fxml"));
			Controller controller = new Controller ();
	        fxmlLoader.setController(controller);
	        Parent root = fxmlLoader.load();
	        primaryStage.setTitle("柴柴君");
	        Scene scene = new Scene ( root, 980, 633 );
	        controller.setScene ( scene );
	       	primaryStage.setScene( scene );
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
