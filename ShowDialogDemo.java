import javax.swing.JOptionPane;  
import javax.swing.JFrame;
public class ShowDialogDemo { 
	JFrame f;
ShowDialogDemo(){     
    //String name=JOptionPane.showInputDialog("Enter Name");
    int name=JOptionPane.showConfirmDialog(f,"do you want to delete","swing test",JOptionPane.YES_NO_OPTION);
    if(name==JOptionPane.YES_OPTION) {
    	 System.out.print("You clicked yes");	
    }else if(name==JOptionPane.NO_OPTION) {
    	 System.out.print("You clicked No");
    }else {
    	 System.out.print("You cancelled");
    }
   
}  
public static void main(String[] args) {  
    new ShowDialogDemo();  
}  
} 

