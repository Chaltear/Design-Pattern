public abstract class Soldier implements Cloneable {
    private String image;
    private int px, py;

    public Soldier(String s, int x, int y) {
        this.image = s;
        this.px = x;
        this.py = y;
    }

    public void paintOver(MyImage i) {
        i.paintOver(image, px, py);
    }

    public void setx(int x) { px = x; }
    public void sety(int y) { py = y; }

    public int getX() {
        return px;
    }

    public int getY() {
        return py;
    }


    // Méthode clone pour cloner des objets Soldier
    @Override
    public Soldier clone() {
        try {
            return (Soldier) super.clone();
        } catch (CloneNotSupportedException e) {
            //au cas ou
            throw new AssertionError();
        }
    }
}
