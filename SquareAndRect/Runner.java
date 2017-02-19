
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String[] args) {
        Square1 s = new Square1(1);
        Rectangle1 r = new Rectangle1(1,1);
        
        System.out.println(s);
        System.out.println(r);
        
        System.out.println(s instanceof Square1); //true
        System.out.println(s instanceof Rectangle1); //true
        
        System.out.println(r instanceof Square1); //false
        System.out.println(r instanceof Rectangle1); //true
    }
}
