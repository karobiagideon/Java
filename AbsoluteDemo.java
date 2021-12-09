import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbsoluteDemo extends JFrame{
	AbsoluteDemo(){
	//Declare UI
	JTextField f1=new JTextField();
	JTextField f2=new JTextField();
	JLabel lb1 =new JLabel();
	JLabel lb2 =new JLabel();
	JButton b =new JButton();
	
	//Setting components Bounds
	lb1.setBounds(20, 30, 100, 50);
	f1.setBounds(130, 25,200, 30);
	lb2.setBounds(20, 65, 100, 50);
	f2.setBounds(130, 70, 200, 30);
	b.setBounds(20, 130, 310, 20);
	
	//setting components text
	lb1.setText("Username");
	lb2.setText("Password");
	b.setText("Login");
	
	//creating the panel
	JPanel p=new JPanel();   
	       
	
	       p.setLayout(null);
	       p.add(lb1);
	       p.add(f1);
	       p.add(lb2);
	       p.add(f2);
	       p.add(b);
	       
	       add(p);
	       setSize(500,400);
	       setVisible(true);
	       
	 
	        
	
	}
public static void main(String[] args) {
	new AbsoluteDemo();
}
}
