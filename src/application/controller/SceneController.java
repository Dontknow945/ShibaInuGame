package application.controller;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneController {
	private static SceneController instance;
	private HashMap<String, Pane> sceneMap = new HashMap<>();
    private Scene main;

    private SceneController(Scene main) {
        this.main = main;
    }
    
    public static SceneController getInstance(Scene main){
        // 第一次被呼叫的時候再建立物件
        if(instance == null){
            instance = new SceneController(main);
        } 
        return instance;
    }

    public void addScene(String name, Pane pane) {
    	sceneMap.put(name, pane);
    }

    public void removeScene(String name){
    	sceneMap.remove(name);
    }

    public void activate(String name) {
        main.setRoot(sceneMap.get(name));
    }
}
