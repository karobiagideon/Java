import javax.swing.*;  
public class ListExample  
{  
     ListExample(){  
        JFrame f= new JFrame();  
        DefaultListModel<String> ls = new DefaultListModel<>();  
          ls.addElement("Item1");  
          ls.addElement("Item2");  
          ls.addElement("Item3");  
          ls.addElement("Item4");  
          JList<String> list = new JList<>(ls);  
          list.setBounds(100,100, 75,75);  
          f.add(list);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
     }  
public static void main(String args[])  
    {  
   new ListExample();  
    }} 
