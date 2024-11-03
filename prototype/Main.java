public class Main {
    public static void main(String[] args) {
        // prototypes mario et gomnba
        Soldier marioPrototype = new Mario(20, 20);
        Soldier goombaPrototype = new Goomba(20, 20);

        // Create the Super Mario scene
        SuperMario superMarioScene = new SuperMario(marioPrototype, goombaPrototype);

        // Icréer "soliders"
        superMarioScene.initializeSoldiersFromCamps(4); //4 dans chaque camps, peut changer

        superMarioScene.render();
    }
}
