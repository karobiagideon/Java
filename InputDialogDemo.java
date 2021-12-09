import javax.swing.*;  
public class InputDialogDemo {  
JFrame f;
InputDialogDemo(){   
f=new JFrame();
    String name=JOptionPane.showInputDialog(f,"Enter Name");      
}  
public static void main(String[] args) {  
    new InputDialogDemo();  
}  
} 
