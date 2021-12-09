class Demo {
 public static void main(String args[]) {
  byte x; //Variable declaration
  int a = 270; //Variable initialization
  double b = 128.128;
  System.out.println("int converted to byte"); //Outputting
  x = (byte) a; //Data type conversions convert a to byte;
  System.out.println("a and x " + a + " " + x);
  System.out.println("double converted to int");
  a = (int) b;
  System.out.println("b and a " + b + " " + a);
  System.out.println("\ndouble converted to byte");
  x = (byte)b;
  System.out.println("b and x " + b + " " + x);
 }
}
