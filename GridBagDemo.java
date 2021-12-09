import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

class GridBagDemo extends JFrame{
	GridBagLayout gbl;
	GridBagConstraints c;
	JLabel lblID, lblFName, lblLName, lblDpt, lblTel;
	JTextField txtID, txtFName, txtLName, txtDpt, txtTel;
	JButton btnSave, btnSearch, btnDelete;

	GridBagDemo(){
		super("GridBagLayout in action");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c = new GridBagConstraints();
		gbl = new GridBagLayout();
		setLayout(gbl);

		lblID = new JLabel("Employee ID");
		c.anchor = GridBagConstraints.WEST;//If the component is smaller than the available space
		c.fill = GridBagConstraints.BOTH;//incase the component is larger than the space available
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 10, 5);//left, right, top, bottom
		add(lblID, c);

		txtID = new JTextField(10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(txtID, c);

		lblFName = new JLabel("First Name");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(lblFName, c);
		
		txtFName = new JTextField(10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(txtFName, c);

		lblLName = new JLabel("Last Name");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(lblLName, c);

		txtLName = new JTextField(10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(txtLName, c);

		lblDpt = new JLabel("Department");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(lblDpt, c);

		txtDpt = new JTextField(10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(txtDpt, c);

		lblTel = new JLabel("Telephone");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(lblTel, c);

		txtTel = new JTextField(10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(txtTel, c);

		btnSave = new JButton("Save");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(btnSave, c);

		btnSearch = new JButton("Search");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(btnSearch, c);

		btnDelete = new JButton("Delete");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;//NONE, HORIZONTAL, VERTICAL, BOTH
		c.gridx = 2;
		c.gridy = 5;
		c.insets = new Insets(5, 5, 5, 5);//left, right, top, bottom
		add(btnDelete, c);


		setVisible(true);
	}
	
	public static void main(String [] args){
	new GridBagDemo();
	}
}