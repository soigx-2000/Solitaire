package resources;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;


public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	CatFishing game;
   	public GUI(CatFishing game){
	   	this.game= game;
        //Create and set up the window.
       setTitle("Solitaire");
       setSize(900,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this supplies the background
       try {
		System.out.println(getClass().toString());
		Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
		setContentPane(new ImagePanel(blackImg));

       }catch(IOException e) {
    	   e.printStackTrace();
       }
    	
		JPanel player2= new JPanel();
		player2.setLocation(450, 20);
		player2.setSize(150, 200);
		player2.setLayout(new BoxLayout(player2, BoxLayout.PAGE_AXIS));
		player2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.yellow));
		JPanel river =  new JPanel();
		river.setLocation(205, 30);
		river.setSize(200, 300);
		river.setLayout(new BoxLayout(river, BoxLayout.PAGE_AXIS));
		river.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
       /*******
        * This is just a test to make sure images are being read correctly on your machine. Please replace
        * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
        * game once it's fully created.
        */
		Stack<Card> stack1 = new Stack<Card>();
	   stack1.add(new Card(2, Card.Suit.Diamonds));
	   stack1.add(new Card(3, Card.Suit.Clubs));
	   stack1.add(new Card(4, Card.Suit.Hearts));
	   stack1.add(new Card(5, Card.Suit.Spades));
	   stack1.add(new Card(6, Card.Suit.Diamonds));
	   this.add(drawPile(stack1));
	   player2.setOpaque(false);
	   river.setOpaque(false);
	   this.add(player2);
	   this.add(river);

        this.setVisible(true);
    }


	//here’s the function definition 

   public JLayeredPane drawPile(Stack<Card> stackIn) {
		JLayeredPane player = new JLayeredPane();
		player.setSize(150,200);
		player.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
    Object[] cards;
	Point origin = new Point(0,0);
    cards = stackIn.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You’ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position
	//read the cards and  add them to the pane in a layer
	player.setOpaque(false);
	for (int i = 0; i<cards.length; i++){
		Card card = (Card)cards[i];
		card.setLocation(origin);
		player.add(card, Integer.valueOf(i));
		System.out.println(card.getPreferredSize().height);
		origin.y += (200-card.getPreferredSize().height)/(cards.length-1);
	}
	return player;
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
