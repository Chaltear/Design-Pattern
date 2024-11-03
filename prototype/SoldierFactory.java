public class SoldierFactory {
    public static Soldier getSoldier(Soldier s, int x, int y) {

        Soldier clonedSoldier = s.clone();


        clonedSoldier.setx(x);
        clonedSoldier.sety(y);


        return clonedSoldier;
    }
}