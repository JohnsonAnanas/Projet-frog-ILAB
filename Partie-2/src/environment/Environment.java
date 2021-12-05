package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
		
	//TODO
    private Game game;
    private ArrayList<Lane> routes;


    public  Environment(Game jeu){
        this.game=jeu;
        ArrayList<Lane> tmp=new ArrayList<Lane>();
        for(int i=0; i<this.game.height; i++){
            tmp.add(new Lane(jeu, i, i%2!=0,this.game.defaultDensity));
        }
        this.routes=tmp;
    }

    public boolean isSafe(Case c) {
        Lane tmp=routes.get(c.ord);
        return tmp.isSafe(c);
    }

    public boolean isWinningPosition(Case c){
        if (c.ord>=game.height-1){
            return true;
        }
        return false;
    }

    public void update(){
        for (int i=1; i< routes.size()-1;i++){
            Lane tmp=routes.get(i);
            tmp.update();

        }

    }

}
