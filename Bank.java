public class Bank
{
private static String note = "Bank";
public static class SBISavings
{
public void displayOutput()
{
System.out.println(" SBISaving is: " + note);
}
}
public static void main(String[] args)
{
//creating instance of static class Bank.
SBISavings bs = new Bank.SBISavings();
//calling the method
bs.displayOutput();
}
}
