import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridDemo extends JFrame{
	//constructor
	GridDemo(){
		//creating components
		JButton btn1 = new JButton("btn1");
		JButton btn2 = new JButton("btn2");
		JButton btn3 = new JButton("btn3");
		JButton btn4 = new JButton("btn4");
		JButton btn5 = new JButton("btn5");
		JButton btn6 = new JButton("btn6");
		JButton btn7 = new JButton("btn7");
		JButton btn8 = new JButton("btn8");
		
		//adding components
		add(btn1);add(btn2);add(btn3);add(btn4);add(btn5);add(btn6);add(btn7);add(btn8);
		
		//setting a gridlayout of four rows and 2 columns
		setLayout(new GridLayout(4,2));
		
		//set the size of the JFrame of width of 300 and height of 400
		setSize(300,400);
		
		//set the jframe to be visible
		setVisible(true);
	}
	//main
	public static void main(String[] args) {
		//create an instance of a constructor
		new GridDemo();
	}
}
