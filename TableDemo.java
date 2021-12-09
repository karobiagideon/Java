import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableDemo extends JFrame{//create a jframe by inheritance
 //create a constructor same as class name
	TableDemo (){
		//declare the 2d-array of the table rows
		String[][] data= {{"Jane","22","kisumu"},
				           {"sam","28","nairobi"},
		                    {"kamau","12","thika"}};
		//declare the columns of the jtable
		String[] columns= {"Name","Age","County"};
		
		//create the table and pass the columns and rows
		JTable tb = new JTable(data,columns);
		
		//declare the scrollpane to fit in the jtabe
		JScrollPane sc = new JScrollPane(tb);
		//set the bounds of the scrollpane
		            sc.setBounds(10, 10, 200, 300);
		            
		//adding the scrollpane to the jframe
		            add(sc);
		            setSize(300,400);
		           //set the frame to visible
		            setVisible(true);
	}
	public static void main(String[] args) {
		//create an instance of the class
		new TableDemo();
	}
}
