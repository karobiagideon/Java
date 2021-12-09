package displaydata;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoginDetails extends JFrame{
	
	private static final long serialVersionUID = 3256801835904883469L;
	JTable tb;
	protected static DefaultTableModel tbmodel;
	JScrollPane sp;
	JButton btn_delete,btn_update;
	JTextField tf_id,tf_user,tf_pass;
	JLabel lb_id,lb_user,lb_pass;
	JPanel update;
	
	LoginDetails(){
		super("Details");
		lb_id = new JLabel("id");
		lb_user = new JLabel("user");
		lb_pass = new JLabel("pass");
		tf_id = new JTextField(20);
		tf_user=new JTextField(20);
		tf_pass=new JTextField(20);
		btn_update = new JButton("Update");
		update = new JPanel();
		update.setLayout(new FlowLayout());
		update.add(lb_id);update.add(tf_id);update.add(lb_user);
		update.add(tf_user);update.add(lb_pass);
		update.add(tf_pass);update.add(btn_update);
		
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
        
        tb.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		if(tb.getSelectedRow()!=-1) {
					String id =tb.getValueAt(tb.getSelectedRow(), 0).toString();
					String pass=tb.getValueAt(tb.getSelectedRow(), 1).toString();
				    String user=tb.getValueAt(tb.getSelectedRow(), 2).toString();
				    
				    tf_id.setText(id);
				    tf_user.setText(pass);
				    tf_pass.setText(user);
				}
        	}});
        
        btn_update.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!tf_id.equals("")||!tf_user.equals("")||!tf_pass.equals("")) {
					String getid = tf_id.getText();
					String getuser = tf_user.getText();
					String getpass=tf_pass.getText();
					int update = Connected.doupdate(getid,getuser,getpass);
					if(update > 0) {
						JOptionPane.showMessageDialog(LoginDetails.this,"Update successfull.....");
						tbmodel.setRowCount(0);
						Connected.getdata();
					}}}});
        
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
		add(update,BorderLayout.SOUTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
		setBackground(Color.CYAN);
		setSize(screenSize.width,screenSize.height);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginDetails();
	}
}
