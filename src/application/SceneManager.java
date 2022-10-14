package application;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneManager {
	private static SceneManager instance;
	private HashMap<String, Pane> sceneMap = new HashMap<>();
    private Scene main;

    private SceneManager(Scene main) {
        this.main = main;
    }
    
    public static SceneManager getInstance(Scene main){
        // 第一次被呼叫的時候再建立物件
        if(instance == null){
            instance = new SceneManager(main);
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
