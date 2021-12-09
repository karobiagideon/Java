import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class JPopDemo{
	JPopDemo(){
		JFrame f =new JFrame();
		JPanel pan =new JPanel(new FlowLayout());
		
		final JPopupMenu popmenu = new JPopupMenu();
		JMenuItem pastemenu = new JMenuItem("Paste");
		JMenuItem copymenu = new JMenuItem("Copy");
		JMenuItem cutmenu = new JMenuItem("Cut");
		
		popmenu.add(pastemenu);
		popmenu.add(copymenu);
		popmenu.add(cutmenu);
		
		f.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {            
	            popmenu.show(f, e.getX(), e.getY());
	         }               
	      });

		//f.setLayout(new GridLayout(3,1));
		pan.add(popmenu);
		f.add(pan);
		f.setSize(300,400);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JPopDemo();
	}
}
