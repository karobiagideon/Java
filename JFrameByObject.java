import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameByObject {
	//create a constructor same as class name
	JFrameByObject(){
		//declare a button 
		JButton b = new JButton("OK");
		
		//setting the bounds of the button as (x,y,width,height);
		b.setBounds(10, 10, 100, 30);
		
		//declare object of JFrame
		JFrame f = new JFrame();
		
		//adding the button to the JFrame
		f.add(b);
		
		//set the size(width,height)
		f.setSize(300,400);
		
		//set the layout
		f.setLayout(null);
		
		//set default close operations
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the Jframe to visible
		f.setVisible(true);
	}
	//driver code
 public static void main(String[] args) {
	 //creating an instance of the constructor
	 new JFrameByObject();
 }
}
