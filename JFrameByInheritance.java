import javax.swing.JFrame;

//creating a Jframe by Inheritance
public class JFrameByInheritance extends JFrame{
	JFrameByInheritance(){
		//set size of JFrame as(width,height)
		setSize(300,400);
		
		//set the layout to null
		setLayout(null);
		
		//set the action when the close button is clicked
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//make the jframe visible
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new JFrameByInheritance();
	}
}
