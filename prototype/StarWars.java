public class StarWars extends Scene {
    public StarWars(Soldier prototypeCamp1, Soldier prototypeCamp2) {
        // Appel au constructeur de la superclasse Scene avec les paramètres requis

        super("starwars.jpg", 792, 241, 0, 0, prototypeCamp1, prototypeCamp2);
    }
}