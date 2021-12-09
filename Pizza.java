abstract class Food{
void typeoffood(){
}
}

class Pizza extends Food{
void typeoffood(){
System.out.print("This is my best food");
}
public static void main(String[] args){
Food food=new Pizza();
food.typeoffood();
}
}