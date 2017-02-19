
/**
 * Write a description of class Square1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square1 extends Rectangle1
{
    public Square1() {
        super(1,1);
    }
    public Square1(int sL) {
        super(sL, sL);
    }
    @Override
    public void setSL(int sL) {
        super.setSL(sL);
        super.setSW(sL);
    }
    @Override
    public void setSW(int sW) {
        super.setSL(sW);
        super.setSW(sW);
    }
}
