package displaydata;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoginDetails extends JFrame{
	JTable tb;
	public static DefaultTableModel tbmodel;
	JScrollPane sp;
	LoginDetails(){
		super("Details");
		tbmodel= new DefaultTableModel();
		
		//adding columns to the defaulttableModel
		tbmodel.addColumn("ID");
		tbmodel.addColumn("USERNAME");
		tbmodel.addColumn("PASSWORD");
		
		//getting the defaulttableModel rows from thew database
		Connected con = new Connected();
		int isdata=con.getdata();
		if(isdata < 1) {
			JLabel lb = new JLabel("No data found");
			lb.setBackground(Color.CYAN);
			add(lb,BorderLayout.SOUTH);
			//JOptionPane.showMessageDialog(LoginDetails.this,"No data");
		}
		
		tb = new JTable(tbmodel);
		tb.setPreferredScrollableViewportSize(new Dimension(300, 100));
        tb.setFillsViewportHeight(true);
        tb.setBorder(BorderFactory.createRaisedBevelBorder());
      
		sp = new JScrollPane(tb);
		
		
		
		add(sp);
		setBackground(Color.CYAN);
		setSize(400,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginDetails();
	}
	
}
