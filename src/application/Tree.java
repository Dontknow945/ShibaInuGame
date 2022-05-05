package application;

import javafx.scene.image.ImageView;

public class Tree {
	public Tree(){
    	
	}
	public void treeChanging (int ttime,ImageView tree,ImageView fr1,ImageView fr2,ImageView fr3,ImageView fr4
			,int omon,int tmon,boolean seed,ImageView bug1,ImageView bug2) {
		
		switch (ttime) {
		case 10:
			tree.setImage ( ImageUtility.tree );
			break;
		case 25:
			tree.setImage ( ImageUtility.tree2 );
    		final int randbug = (int) (Math.random() * 3);
    		switch (randbug) {
    		case 1:
    			bug1.setVisible(true);
    			break;
    		case 2:
    			bug1.setVisible(true);
    			bug2.setVisible(true);
    			break;
    		default:
    			break;
    		}
			break;
		case 40:
			if(bug1.isVisible()==true || bug2.isVisible()==true){
    			tree.setImage ( ImageUtility.tree4 );
    		}else{
    			fr1.setVisible(true);
	    		fr2.setVisible(true);
	    		fr3.setVisible(true);
	    		fr4.setVisible(true);
    		}
			break;
		case 50:
			bug1.setVisible(false);
			bug2.setVisible(false);
    		tree.setImage ( ImageUtility.tree3 );
    		if(fr1.isVisible()==true){
    			fr1.setVisible(false);
    			omon=tmon;
    			tmon-=5;
    		}
    		if(fr2.isVisible()==true){
    			fr2.setVisible(false);
    			omon=tmon;
    			tmon-=5;
    		}
    		if(fr3.isVisible()==true){
    			fr3.setVisible(false);
    			omon=tmon;
    			tmon-=5;
    		}
    		if(fr4.isVisible()==true){
    			fr4.setVisible(false);
    			omon=tmon;
    			tmon-=5;
    		}
			break;
		default:
			break;
		}
	}
}
