import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class BoxLayoutDemo extends Frame{//create jframe by inheritance
	BoxLayoutDemo(){
		//creating buttons
		Button but1 = new Button("Button 1");
		Button but2 = new Button("Button 2");
		Button but3 = new Button("Button 3");
		Button but4 = new Button("Button 4");
		Button but5 = new Button("Button 5");
		
		//adding the buttons to the jframe
		add(but1);
		add(but2);
		add(but3);
		add(but4);
		add(but5);
		
		//set the layout on the jframe along the x-axis
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		
		//set the size of the jframe
		setSize(300,400);
		
		//make the jframe visible
		setVisible(true);
	}
	public static void main(String[] args) {
		//create an instance of the class
		new BoxLayoutDemo();
	}
}
