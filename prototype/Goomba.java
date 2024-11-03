
public class Goomba extends Soldier
{
    public Goomba(int x, int y)
    {
        super("goomba.png", x, y);
    }

    @Override
    public Goomba clone() {
        return new Goomba(getX(), getY());
    }
}
