package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game jeu,Case beforeCase,boolean lTR){
		this.game=jeu;
		this.leftPosition=beforeCase;
		this.leftToRight=lTR;
		this.length=(int)(Math.random()*3);
		this.addToGraphics();
	}
	
	//TODO : ajout de methodes
	public Case getLeftPosition(){
		return this.leftPosition;
	}
	public int getLength(){
		return this.length;
	}
	public void setLength(int newLength){this.length=newLength;}

	public void move(){
		if (leftToRight){
			leftPosition=new Case(leftPosition.absc+1,leftPosition.ord);
			if (leftPosition.absc+length>game.width+1){
				length=length-1;
			}

		}
		else{
			leftPosition=new Case(leftPosition.absc-1,leftPosition.ord);
			if (leftPosition.absc<-1){
				length=length-1;
				leftPosition=new Case(0,leftPosition.ord);
			}

		}
		this.addToGraphics();
	}

	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
