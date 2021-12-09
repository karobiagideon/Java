package grouproom;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EnterDetails extends JFrame{
	Dimension d;
	JPanel pan_details;
	
	public EnterDetails(){
	pan_details= new PanDetails();
	d=Toolkit.getDefaultToolkit().getScreenSize();	
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e) {
		int pane=JOptionPane.showConfirmDialog(EnterDetails.this,"Do you want to exit","Exit?",JOptionPane.YES_NO_OPTION);
		if(pane==JOptionPane.YES_OPTION) {
			EnterDetails.this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}else {
			EnterDetails.this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
		}
	});
	add(pan_details);
	setSize(d.width,d.height);
	setVisible(true);
	}
	public static void main(String[] args) {
		new EnterDetails();
	}
}
