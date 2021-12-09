public class CaseDemo{
public static void main(String[] args){
char c='B';

switch(c){
case 'B' :
case  'C' :
System.out.print("Good");
break;

case  'A' :
System.out.print("Excellent");
break;
 default:
 System.out.print("Invalid grade!!!");
}
}
}