import java.util.Scanner;

class StringDemo{
public static void main(String[] args){
String Firstname,Secondname;
Scanner scan=new Scanner(System.in);
System.out.println("Enter First name::");
Firstname=scan.nextLine();

System.out.println("Enter Second name::");
Secondname=scan.nextLine();


System.out.println("Your name is:::"+Firstname+"  " +Secondname);
}
}