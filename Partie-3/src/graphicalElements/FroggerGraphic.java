package graphicalElements;

//import javax.lang.model.util.ElementScanner14;
import javax.swing.*;


import gameCommons.IFrog;
//import util.Chrono;
import util.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;




public class FroggerGraphic extends JPanel implements IFroggerGraphics, KeyListener {
	private ArrayList<Element> elementsToDisplay;
	private int pixelByCase = 16;
	private int height;
	private IFrog frog;
	private JFrame frame;
	//private gameCommons.Game game;
	public util.Chrono chrono;

	private boolean firstMove;



	public FroggerGraphic(int width, int height) {
		this.height = height;
		this.chrono = new util.Chrono();
		this.firstMove = true;
		//this.game = game;
		elementsToDisplay = new ArrayList<Element>();  

		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width * pixelByCase, height * pixelByCase));

		JFrame frame = new JFrame("Frogger");
		this.frame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Element e : elementsToDisplay) {

			g.setColor(e.color);

			g.fillRect(pixelByCase * e.absc, pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase - 1);
			if (e.color == Color.YELLOW)
			{
				System.out.println("YELLOWWWWWW");
				g.drawRect(pixelByCase * e.absc, pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase - 1);
				
			}
		}

		if (firstMove == true) {
			firstMove = false;
			chrono.start();
		}


		String chronoATM = "" + this.chrono.getDureeTxtATM();
		g.setColor(Color.red);
		Font myFont = new Font ("Coco-Sharp-Heavy-trial", 1, 25);
			
		g.setFont (myFont);
		g.drawString(chronoATM, 10, height +3);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			frog.move(Direction.up);
			break;
		case KeyEvent.VK_DOWN:
			frog.move(Direction.down);
			break;
		case KeyEvent.VK_LEFT:
			frog.move(Direction.left);
			break;
		case KeyEvent.VK_RIGHT:
			frog.move(Direction.right);
		}
	}

	public void clear() {
		this.elementsToDisplay.clear();
	}

	public void add(Element e) {
		this.elementsToDisplay.add(e);

		//TempATM ygfuv = new TempATM("  ", Color.red);
		//this.elementsToDisplay.add(ygfuv);
	}

	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	public void endGameScreen(String score ,String temps, int scoreInt) {
		frame.remove(this);
		chrono.stop();
		System.out.println("final : " + chrono.getDureeTxt());
		temps += chrono.getDureeTxt();
		ImageIcon icone = new ImageIcon();
		if (scoreInt < 5)
			icone = new ImageIcon("C:/Users/damie/Desktop/Partie-3/src/graphicalElements/lose.jpg");
		else
			icone = new ImageIcon("C:/Users/damie/Desktop/Partie-3/src/graphicalElements/win.jpg");
     	
    	JLabel jlabelImg = new JLabel(icone);
		jlabelImg.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelImg.setSize(this.getSize());

		
		JLabel labelScore = new JLabel(score , 0);
		//System.out.println(temps);
		labelScore.setFont(new Font("Verdana", 1, 20));
		labelScore.setForeground(Color.red); 
		labelScore.setVerticalAlignment(SwingConstants.CENTER);
		labelScore.setSize(this.getSize());
		
		JLabel labelTemps = new JLabel(temps, SwingConstants.LEFT);
		labelTemps.setFont(new Font("Verdana", 1, 20));
		labelTemps.setForeground(Color.red);
		labelTemps.setVerticalAlignment(SwingConstants.BOTTOM);
		labelTemps.setSize(this.getSize());

		
		frame.getContentPane().add(labelScore);
		frame.getContentPane().add(labelTemps);
		frame.getContentPane().add(jlabelImg);
		
		frame.repaint();

	}

}
