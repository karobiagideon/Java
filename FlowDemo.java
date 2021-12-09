import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowDemo extends JFrame{//create a frame by inheritance
  //creating a constructor same as class name
	FlowDemo(){
		//creating components
		JButton but1 = new JButton("button 1");
		JButton but2 = new JButton("button 2");
		JButton but3 = new JButton("button 3");
		JButton but4 = new JButton("button 4");
		JButton but5 = new JButton("button 5");
		JButton but6 = new JButton("button 6");
		JButton but7 = new JButton("button 7");
		
		//adding the buttons
		add(but1);
		add(but2);
		add(but3);
		add(but4);
		add(but5);
		add(but6);
		add(but7);
		
		//set size of the JFrame
		setSize(300,400);
		
		//set the layout of the Jframe
		setLayout(new FlowLayout());
		
		//make frame visible
		setVisible(true);
	}
	//main
	public static void main(String[] args) {
		//creating an instance of the class
		new FlowDemo();
	}
}
