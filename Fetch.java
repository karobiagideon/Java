package grouproom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fetch extends JFrame implements ItemListener,ActionListener{
	ConnectionPool cp;
	Dimension d;
	
	String []days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};	
	String[]class_time = {"8:00am - 10:30am","11:00am - 1:00pm","2:00pm - 4:00pm"};
	String []col_headers = {"Course", "Group", "Day", "Venue", "Time"};
	String [][]row_data = new String[100][5];
	
	
	JComboBox<String> cbo_days, cbo_time;
	JTable tbl;
	JScrollPane pane;
	JButton btn_fetch;
	JPanel panTop, panCenter;
	
	
	public Fetch() {
		super("Fetch Group and Room Allocation");
		
		d =Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		
		panTop = new JPanel();
		panTop.setLayout(new GridLayout(1, 3));
		
		cbo_days = new JComboBox<String>(days);
		cbo_days.addItemListener(this);
		panTop.add(cbo_days);
		
		cbo_time = new JComboBox<String>(class_time);
		cbo_time.addItemListener(this);
		panTop.add(cbo_time);
		
		btn_fetch=new JButton("Click to fetch");
		panTop.add(btn_fetch);
		btn_fetch.addActionListener(this);
		
		panCenter = new JPanel();
		tbl = new JTable(row_data, col_headers);
		pane = new JScrollPane(tbl);
		
		//panCenter.add(pane);
		
		
		add(panTop, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		
		setVisible(true);		
	}

	public static void main(String[] args) {
		new Fetch();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			//JOptionPane.showMessageDialog(null, cbo_days.getSelectedItem().toString()+"Selected");
			cp = new ConnectionPool("root", "");
			Connection conn = cp.connector();
			if(conn!=null) {
				try {
					String sql = "select * from class";
					PreparedStatement pst = conn.prepareStatement(sql);
					//pst.setString(1, cbo_days.getSelectedItem().toString());
					//pst.setString(2, cbo_time.getSelectedItem().toString());
					ResultSet rs = pst.executeQuery(); 
					int track=-1;
				
					while(rs.next())
					{
						System.out.print(rs.getString(1));
						System.out.print(rs.getString(2));
						System.out.print(rs.getString(3));
						//track++;
						//row_data[0][track] = rs.getString(1);
						//row_data[1][track] = rs.getString(2);
						//row_data[2][track] = rs.getString(3);
						//row_data[3][track] = rs.getString(4);
						//row_data[4][track] = rs.getString(5);
						
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}	
			}else {
			System.out.print("Cannot connect!!!");	
			}	
		}
	}

