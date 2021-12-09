package displaydata;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoginDetails extends JFrame{
	
	private static final long serialVersionUID = 3256801835904883469L;
	JTable tb;
	protected static DefaultTableModel tbmodel;
	JScrollPane sp;
	JButton btn_delete;
	LoginDetails(){
		super("Details");
		btn_delete = new JButton("Delete item?");
		tbmodel= new DefaultTableModel();
		
		//adding columns to the defaulttableModel
		tbmodel.addColumn("ID");
		tbmodel.addColumn("USERNAME");
		tbmodel.addColumn("PASSWORD");
		
		//getting the defaulttableModel rows from thew database
		//Connected con = new Connected();
		int isdata=Connected.getdata();
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
   
        tb.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(tb.getSelectedRow()!=-1) {
				int id =Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 0).toString());
					int delete = Connected.delete(id);
					
					if(delete > 0) {
						JOptionPane.showMessageDialog(LoginDetails.this, "Item deleted");
						tbmodel.removeRow(tb.getSelectedRow());
					}else {
						JOptionPane.showMessageDialog(LoginDetails.this, "Item delete failed");
					}
				}
			} });
        
		sp = new JScrollPane(tb);
		
		
		
		add(sp);
		add(btn_delete,BorderLayout.NORTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
		setBackground(Color.CYAN);
		setSize(screenSize.width,screenSize.height);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginDetails();
	}
}
