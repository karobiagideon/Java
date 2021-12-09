import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboDemo {
	JFrame f;
	JComboBox<String> cb;
	ComboDemo(){
	String[] items= {"1","2","3","4","5"};
	//declaring the objects
	f=new JFrame();
	cb=new JComboBox<String>(items);
	
	cb.setBounds(30, 40, 50, 20);
	cb.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent i) {
			// TODO Auto-generated method stub
			if(i.getStateChange()==ItemEvent.SELECTED) {
			System.out.println(i.getItem()+" selected");
			}
		}
	});
    f.add(cb);
    f.setSize(200,300);
    f.setLayout(null);
    f.setVisible(true);
	}
	public static void main(String[] args) {
		new ComboDemo();
	}
}
