package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;


public class Coin {
	private Case position;
	private Game game;
    private final Color colorCoin;

	public Coin(Game jeu, int absc, int ord){
		this.game=jeu;
        this.position= new Case(absc, ord);
        this.colorCoin = Color.YELLOW;
        this.addToGraphics();
       
	}

	public Case getPosition(){
		return this.position;
	}

    public void positionCoin(){
		this.addToGraphics();
	}

	private void addToGraphics() {
			game.getGraphic()
					.add(new Element(position.absc, position.ord, Color.yellow));
            System.out.println("onestla" + position.absc + " " + position.ord);

		}


}

