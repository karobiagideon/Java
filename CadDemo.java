import java.awt.*;
import javax.swing.*;

public class CadDemo extends JFrame{//create jframe by inheritance
	//create a constructor same as class name
	CadDemo(){
		
		//create a cardlayout
		CardLayout card = new CardLayout();
		
		//create a main panel
		JPanel panmain = new JPanel();
		//set background color of the main panel
		      panmain.setBackground(Color.BLUE);
		      
		      //setting the cardlayout to the panmain
		      panmain.setLayout(card);
		//creating a button panel
		      JPanel panbutt = new JPanel(); 
		    //set background color of the button panel
		      
		      //creating three panels with different colors
		      JPanel panfirst = new JPanel();
		      JPanel pansec = new JPanel();
		      JPanel panthird = new JPanel();
		      
		      //setting their background colors
		      panfirst.setBackground(Color.GRAY);
		      pansec.setBackground(Color.BLACK);
		      panfirst.setBackground(Color.YELLOW);
		      
		      //adding the pnels to the panmain
		      panmain.add(panfirst);
		      panmain.add(pansec);
		      panmain.add(panthird);
		      
		      //setting the background color of the panbutt
		      panbutt.setBackground(Color.RED);
		      
		      //create Buttons
		      JButton butnext = new JButton("Next");
		      JButton butprev= new JButton("Previous");
		      JButton butfirst = new JButton("First");
		      JButton butlast = new JButton("Last");
		      
		    //setting the events on the buttons
		      butnext.addActionListener(e-> card.next(panmain));
		      butprev.addActionListener(e-> card.previous(panmain));
		      butlast.addActionListener(e-> card.last(panmain));
		      butfirst.addActionListener(e-> card.first(panmain));
		      
		      //adding the components to the panbutt
		      panbutt.add(butlast);
		      panbutt.add(butfirst);
		      panbutt.add(butprev);
		      panbutt.add(butnext);
		      
		      
		      //adding the panels to jframe
		      add(panmain);
		      add(panbutt,BorderLayout.SOUTH);
		      //setting the size of the jframe of width 300 and height 400
		      setSize(300,400);
		      //make the jframe visible
		      setVisible(true);
	}
	 
	 public static void main(String[] args) {
		//create an instance of the constructor in main
		 new  CadDemo(); 
	 }
}
