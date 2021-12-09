package gffg;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JButton;
public class Demo extends JFrame{
	JButton btn;
	JTextField t_user;
	JPasswordField t_pass;
	JLabel l_user,l_pass;
	JFrame f;
	GridBagLayout gbl;
	GridBagConstraints c;
	Demo(){
		gbl = new GridBagLayout();
		c= new GridBagConstraints();
		setLayout(gbl);
		
		l_user = new JLabel("Username");
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		c.insets= new Insets(5,5,5,5);
		add(l_user,c);
		
		t_user = new JTextField(10);
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=0;
		c.insets= new Insets(5,5,5,5);
		add(t_user,c);
		
		l_pass = new JLabel("Password");
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=1;
		c.insets= new Insets(5,5,5,5);
		add(l_pass,c);
		
		t_pass = new JPasswordField(10);
		t_pass.setFont(Font.getFont("Arial"));
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=1;
		c.insets= new Insets(5,5,5,5);
		add(t_pass,c);
		
		btn = new JButton("Send");
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=2;
		c.insets= new Insets(5,5,5,5);
		add(btn,c);
		
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String getuser=t_user.getText();
				String getpass=t_pass.getText();
				Connect con = new Connect();
				boolean isconnect;
				
					isconnect = con.doconnect(getuser, getpass);
					if(isconnect==true){
						JOptionPane.showMessageDialog(Demo.this, "Login successful......");
					}else{
						JOptionPane.showMessageDialog(Demo.this, "Login failed......");
					}
				}
		});
		//setDefaultCloseOperation(Frame.e)
		setLocationRelativeTo(null);
		setBackground(Color.BLUE);
		setSize(500,400);
		setVisible(true);
	}
public static void main(String[] a){
	new Demo();
}
}
