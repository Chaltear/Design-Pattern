
public class Mario extends Soldier
{
    public Mario(int x, int y)
    {
        super("mario.png", x, y);
    }


    @Override
    public Mario clone() {
        return new Mario(getX(), getY());
    }
}
