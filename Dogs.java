final class Animal{
void sound(){
} 
}

class Dogs extends Animal{ ///Wrong!!!!!!
public static void main(String[] args){
Animal anm = new Animal();
anm.sound();
}
}