import java.util.Scanner;

class ScannerDemo{
public static void main(String[] args){
int a,b,sum;

Scanner scan=new Scanner(System.in);
System.out.print("Enter First Number::");
a=scan.nextInt();
System.out.print("Enter Second Number::");
b=scan.nextInt();
sum=a+b;
System.out.println("The sum is" +sum);
}
}