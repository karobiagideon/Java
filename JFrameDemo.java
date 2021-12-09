import javax.swing.JFrame;

class JFrameDemo{
JFrame f;
 //constructor
JFrameDemo(){
   f=new JFrame();//object of jframe
   
  f.setSize(300,400);
  f.setLayout(null);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setVisible(true);
}
public static void main(String[] args){
}
}