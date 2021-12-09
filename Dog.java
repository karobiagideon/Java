abstract class Animal{//Base class
void sound(){//Method without implementation
}
}


class Dog extends Animal{//Inheriting class animal
public void sound(){//Inherited method
System.out.print("Woof!!");//Implementation of the inherited method
}
public static void main(String[] args){
Animal animal = new Dog();
animal.sound();
}
}