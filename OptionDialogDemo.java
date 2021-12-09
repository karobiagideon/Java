import javax.swing.JOptionPane;

public class OptionDialogDemo {

public static void main(String[] args) {
String[] options = {"abc", "def", "ghi", "jkl"};
  
int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array","Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); System.out.println(x);
}
}




