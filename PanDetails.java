package grouproom;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanDetails extends JPanel implements ActionListener{
	JComboBox<String> cmb_course,cmb_grp,cmb_day,cmb_vnue,cmb_time;
	JLabel lbl_header,lbl_course,lbl_grp,lbl_day,lbl_vnue,lbl_time;
	JButton btn_send;
	GridBagLayout gbl;
	String[] course,grp,day,vnue,time;
	GridBagConstraints c;
	
	ConnectionPool cp;
	
	public PanDetails() {
		String[] course= {"SE","FO","CCH","AEE","MP","GD","ICDL"};
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
		String[] group= {"2001 & 1909 Networks","1909","2001 & 1909 Enterprise","2009 & 2001","2101&02","2106&07B","2106&07"};
		String[] venue= {"Lab1","Lab 2","Saloon room","Hall 1","Robotics","Room 2","Room 3","Room 4","Room 5","Studio","Electric AI Hall","Kitchen"};
		String[] time = {"8:00am - 10:30am","11:00am - 1:00pm","2:00pm - 4:00pm"};
		
		gbl = new GridBagLayout();
		c= new GridBagConstraints();
		setLayout(gbl);
	lbl_header=new JLabel("Enter Details");	
	lbl_header.setFont(new Font("arial",Font.BOLD,80));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=0;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(lbl_header,c);
	
	lbl_course=new JLabel("Select course");	
	lbl_course.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=1;
	c.gridx=0;
	c.insets=new Insets(5,5,5,5);
	add(lbl_course,c);
	
	cmb_course=new JComboBox<String>(course);	
	cmb_course.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=1;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(cmb_course,c);
	
	lbl_grp=new JLabel("Select Group");	
	lbl_grp.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=2;
	c.gridx=0;
	c.insets=new Insets(5,5,5,5);
	add(lbl_grp,c);
	
	cmb_grp=new JComboBox<String>(group);	
	cmb_grp.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=2;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(cmb_grp,c);
	
	lbl_day=new JLabel("Select day");	
	lbl_day.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=3;
	c.gridx=0;
	c.insets=new Insets(5,5,5,5);
	add(lbl_day,c);
	
	cmb_day=new JComboBox<String>(days);	
	cmb_day.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=3;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(cmb_day,c);
	
	lbl_vnue=new JLabel("Select Venue");	
	lbl_vnue.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=4;
	c.gridx=0;
	c.insets=new Insets(5,5,5,5);
	add(lbl_vnue,c);
	
	cmb_vnue=new JComboBox<String>(venue);	
	cmb_vnue.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=4;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(cmb_vnue,c);
	
	lbl_time=new JLabel("Select time");	
	lbl_time.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=5;
	c.gridx=0;
	c.insets=new Insets(5,5,5,5);
	add(lbl_time,c);
	
	cmb_time=new JComboBox<String>(time);	
	cmb_time.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=5;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	add(cmb_time,c);
	
	btn_send=new JButton("Click to send");	
	btn_send.setFont(new Font("arial",Font.BOLD,20));
	c.anchor=GridBagConstraints.CENTER;
	c.fill=GridBagConstraints.BOTH;
	c.gridy=6;
	c.gridx=1;
	c.insets=new Insets(5,5,5,5);
	btn_send.addActionListener(this);
	add(btn_send,c);
	setBackground(Color.CYAN);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_send)
		{
		
		try {

			cp = new ConnectionPool("root", "");
			Connection conn = cp.connector();
			String sql = "insert into class(course,day,time,venue,grou) values (?,?,?,?,?)";
			String selected_day,selected_course,selected_time,selected_venue,selected_group;
			selected_course = cmb_course.getSelectedItem().toString();
			selected_day = cmb_day.getSelectedItem().toString();
			selected_time = cmb_time.getSelectedItem().toString();
			selected_venue = cmb_vnue.getSelectedItem().toString();
			selected_group = cmb_grp.getSelectedItem().toString();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, selected_course);
			pst.setString(2, selected_day);
			pst.setString(3, selected_time);
			pst.setString(4, selected_venue);
			pst.setString(5, selected_group);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Data inserted sucessfully");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
		}
	
		
	}
	
		
	
	
	
}
