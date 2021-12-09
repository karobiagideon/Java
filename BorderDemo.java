import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class BorderDemo extends JFrame{
	BorderDemo(){
	JButton btn1=new JButton("Home");
	JButton btn2=new JButton("About us");
	JButton btn3=new JButton("Contact us");
	JButton btn4=new JButton("Supplies");
	JButton btn5=new JButton("Sales");
	
	//JPanel p=new JPanel();
	       add(btn1,BorderLayout.NORTH);
	       add(btn2,BorderLayout.EAST);
	       add(btn3,BorderLayout.WEST);
	       add(btn4,BorderLayout.SOUTH);
	       add(btn5,BorderLayout.CENTER);
	       setSize(400,500);
	       setVisible(true);
	}
	public static void main(String[] args) {
		new BorderDemo();
	}
}
