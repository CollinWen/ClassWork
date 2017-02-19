
/**
 * Inheritance:
 *  -keyword: extends
 *  -single inheritance
 *  -get all class fields (member methods) (accessibility?)
 *  -constructor (if no constructor in your class, compiler adds a call to your super class's default contructor
 *  
 *Every class in java is a subclass of Object class even if you don't explicitly use the keyword "extends"
 * 
 * @author Collin Wen
 * @version 2/3/17
 */
public class Runner
{
    public static void main(String[] args) {
        /*
        Animal a = new Animal();
        Human h = new Human(3, "Orange"); //if the child class does not have a contructor, then it will call the superclass constructor, otherwise it will not do so
        System.out.println(h.getAge());
        Human h1 = new Human(1);
        */
        
        /*
        Square s = new Square();
        Square s2 = new Square();
        System.out.println(s); //although Square class does not have default constructor, the object class has one and Square will call it
        //System.out.println(s.toString()); //equivalent to the statement above
        
        System.out.println(s.equals(s2));//should be false because they are two different memory locations
        
        System.out.println("-------------------------");
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        */
        
        /*
        System.out.println("-------------------------");
        Square s1 = new Square(2);
        System.out.println(s1.area());
        Rectangle r1 = new Rectangle();
        System.out.println(r1.area());
        */
       /*
       Animal a = new Animal();
       System.out.println(a instanceof Animal);
       System.out.println(a instanceof Object);
       
       Human h = new Human();
       Reptile r = new Reptile();
       Amphibian am = new Amphibian();
       System.out.println(h instanceof Human);
       System.out.println(h instanceof Object);
       System.out.println(h instanceof Animal);
       
       //System.out.println(h instanceof Reptile); will result in compilation error; otherwise true;
       System.out.println(r instanceof Object);
       System.out.println(am instanceof Animal);
       
       System.out.println(a instanceof Human);
       */
      
       //System.out.println(am instanceof Human);
      // System.out.println(r instanceof Amphibian);
      
      Square sq = new Square();
      Rectangle rt = new Rectangle();
      System.out.println(sq instanceof Rectangle);
      System.out.println(rt instanceof Square);
    }
}
