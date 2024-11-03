import java.awt.*;
import java.util.ArrayList;

public abstract class Scene {
    private String decor;
    private int maxX, maxY, minX, minY;
    private ArrayList<Soldier> characters;
    private Soldier prototypeCamp1;
    private Soldier prototypeCamp2;

    public Scene(String d, int maxx, int maxy, int minx, int miny, Soldier prototypeCamp1, Soldier prototypeCamp2) {
        decor = d;
        maxX = maxx;
        maxY = maxy;
        minX = minx;
        minY = miny;
        characters = new ArrayList<>();
        this.prototypeCamp1 = prototypeCamp1;
        this.prototypeCamp2 = prototypeCamp2;
    }

    public int getMaxX() { return maxX; }
    public int getMaxY() { return maxY; }
    public int getMinX() { return minX; }
    public int getMinY() { return minY; }

    public void addSoldier(Soldier s) {
        characters.add(s);
    }

    public void initializeSoldiersFromCamps(int numberPerCamp) {
        ArrayList<Point> usedPositions = new ArrayList<>();
        for (int i = 0; i < numberPerCamp; i++) {
            int px, py;
            do {
                px = (int) (Math.random() * (getMaxX() - getMinX()) + getMinX());
                py = (int) (Math.random() * (getMaxY() - getMinY()) + getMinY());
            } while (isPositionCloseToOthers(usedPositions, px, py));
            usedPositions.add(new Point(px, py));
            addSoldier(SoldierFactory.getSoldier(prototypeCamp1, px, py));

            do {
                px = (int) (Math.random() * (getMaxX() - getMinX()) + getMinX());
                py = (int) (Math.random() * (getMaxY() - getMinY()) + getMinY());
            } while (isPositionCloseToOthers(usedPositions, px, py));
            usedPositions.add(new Point(px, py));
            addSoldier(SoldierFactory.getSoldier(prototypeCamp2, px, py));
        }
    }

    private boolean isPositionCloseToOthers(ArrayList<Point> usedPositions, int px, int py) {
        for (Point pos : usedPositions) {
            if (Math.sqrt(Math.pow(pos.x - px, 2) + Math.pow(pos.y - py, 2)) < 5) {
                return true; // Position is too close to another
            }
        }
        return false;
    }


    public void render() {
        MyImage m = new MyImage(decor);
        for (Soldier s : characters) {
            s.paintOver(m);
        }
        m.display();
    }
}
