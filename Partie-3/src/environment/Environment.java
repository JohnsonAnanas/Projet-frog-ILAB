package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
		
    private Game game;
    private ArrayList<Lane> routes;


    public  Environment(Game jeu){
        this.game=jeu;
        ArrayList<Lane> tmp=new ArrayList<Lane>();
        tmp.add(new Lane(jeu, 0, true, 0));
        for(int i=1; i<this.game.height; i++){
            tmp.add(new Lane(jeu, i, i%2==0, game.defaultDensity));
            int rngCoinAbsc = (int)Math.round(Math.random() * (8));
            System.out.println(rngCoinAbsc);
            if (rngCoinAbsc <= 4 ) {
                System.out.println("hjg");
                int rngCoinOrd = (int)Math.round(Math.random() * (game.width));
                new Coin(game, rngCoinAbsc, rngCoinOrd);
            }
        }
        this.routes=tmp;
    }

    public boolean isSafe(Case c) {
        for (Lane tmp : routes){
            if (tmp.getOrd()==c.ord)
                return tmp.isSafe(c);
        }
        return true;
    }    
    public boolean onCoin(Case c) {
        for (Lane tmp : routes){
            if (tmp.getOrd()==c.ord)
                return tmp.isSafe(c);
        }
        return true;
    }
    

    public boolean isWinningPosition(Case c){
        if (c.ord>=game.height-1){
            return true;
        }
        return false;
    }

    public void update(){
        for (int i=0; i< routes.size();i++){
            Lane tmp=routes.get(i);
            tmp.update();

        }

    }

    public void addLane(){
        this.routes.add(new Lane(this.game,this.routes.size()));
        int  rngCoin = (int) Math.round(Math.random() * (5));
		System.out.println(rngCoin);
        
    }
    public void moveLane(int val){
        for (int i=0; i< routes.size()-1;i++){
            Lane tmp=routes.get(i);
            tmp.moveOrd(i-val);
        }
    }

}
