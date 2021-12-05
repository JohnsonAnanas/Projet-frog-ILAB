package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	private Case position;
	private Direction direction;
	private Game game;

	public Frog(Game jeu){
		this.position= new Case(jeu.width/2, 0);
		this.game=jeu;
		this.direction=null;
	}

	public Case getPosition(){
		return this.position;
	}
	public Direction getDirection(){
		return this.direction;
	}

	public void move(Direction key) {
		this.direction = key;
		if (key == Direction.up && (position.ord + 1 < this.game.height)) {
			this.position = new Case(position.absc, position.ord + 1);
		}
		if (key == Direction.down && (position.ord - 1 >= 0)) {
			this.position = new Case(position.absc, position.ord - 1);
		}
		if (key == Direction.left && (position.absc - 1 >= 0)) {
			this.position = new Case(position.absc - 1, position.ord);
		}
		if (key == Direction.right && (position.absc + 1 < this.game.width)) {
			this.position = new Case(position.absc + 1, position.ord);
		}
	}



}
