import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JMenuDemo extends JFrame{
JFrame f;
JMenuBar mb;
JMenu menu,submenu,menu2;
JMenuItem it1,it2,it3,it4,it5,it6;
JMenuDemo(){
	
	JTextArea area = new JTextArea();
	JScrollPane sc = new JScrollPane(area);
	
	mb=new JMenuBar();
	menu=new JMenu("Menu");
	menu2=new JMenu("Menu2");
	submenu=new JMenu("submenu");
	it1=new JMenuItem("item1");
	it2=new JMenuItem("item2");
	it3=new JMenuItem("item3");
	it4=new JMenuItem("item4");
	it5=new JMenuItem("item5");
	it6=new JMenuItem("item6");
	menu.add(it1);menu.add(it2);menu.add(it3);menu.add(it4);
	submenu.add(it5);submenu.add(it6);
	menu.add(submenu);
	mb.add(menu);
	mb.add(menu2);
	add(sc);
	setJMenuBar(mb);
	setSize(300,400);
	setVisible(true);
}
public static void main(String[] args) {
	new JMenuDemo();
}
}
