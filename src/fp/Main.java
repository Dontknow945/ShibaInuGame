package fp;

import fp.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start.fxml"));
        Controller controller = new Controller ();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("®ã®ã§g");
        Scene scene = new Scene ( root, 980, 633 );
        controller.setScene ( scene );
       	primaryStage.setScene( scene );
        primaryStage.show();
	}
        
	public static void main(String[] args) {
        launch(args);
	}   
}

	