import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneDemo extends JFrame{//creating the jframe by inheritance
	//create a constructor same as the class name
	TabbedPaneDemo(){
		//creating the tabbed pane
		JTabbedPane tp = new JTabbedPane();
		          //set the bounds(x,y,width,height) of the tabbed pane
		            tp.setBounds(10, 20, 100, 200);
		            
		            //creating the panels
		            JPanel pan1 = new JPanel();
		                   pan1.setBackground(Color.GREEN);
		            JPanel pan2 = new JPanel();
		                   pan2.setBackground(Color.PINK);
		            JPanel pan3 = new JPanel();
		                   pan3.setBackground(Color.BLUE);
		                   
		 //adding the panels to the tabbed pane
		 tp.add(pan1,"pan1");
		 tp.add(pan2,"pan2");
		 tp.add(pan3,"pan3");
		 
		 //add the tabbed pane to the frame
		 add(tp);
		 
		 //set the size of the jframe of width 300 and height 400
		 setSize(300,400);
		 
		 //make the jframe visible
		 setVisible(true);
	}
//main
	public static void main(String[] args) {
		new TabbedPaneDemo();
	}
}
