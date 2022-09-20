module TestJavaFx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.graphics, javafx.fxml;
	opens application.dog to javafx.graphics, javafx.fxml;
	opens application.treeStates to javafx.graphics, javafx.fxml;
}
