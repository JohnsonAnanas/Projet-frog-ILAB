package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	// TODO : Constructeur(s)
	public Lane(Game jeu,int ord, boolean leftToRight,double density){
		this.game=jeu;
		this.ord=ord;
		this.speed=this.game.minSpeedInTimerLoops;
		this.leftToRight=leftToRight;
		this.density=density;
	}

	public void update() {

		// TODO
		mayAddCar();
		for(int i=0; i<cars.size();i++){
			Car tmp=cars.get(i);
			tmp.move();
			if (tmp.getLength()<=0){
				cars.remove(i);
			}
		}



		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TODO : ajout de methodes

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	public boolean isSafe(Case c){
		if (c.ord == this.ord) {
			if (!cars.isEmpty()) {
				for (int i = 0; i < cars.size(); i++) {
					Car tmp = cars.get(i);
					if (tmp.getLeftPosition().absc <= c.absc && c.absc <= (tmp.getLeftPosition().absc + tmp.getLength()) && !leftToRight) {
						return false;
					}
					if (tmp.getLeftPosition().absc >= c.absc && c.absc >= (tmp.getLeftPosition().absc - tmp.getLength()) && leftToRight) {
						return false;
					}
				}
			}
			return true;
		}
		return true;
	}

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
