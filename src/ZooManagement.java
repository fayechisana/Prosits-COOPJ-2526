import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        /* Instruction 1
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " comporte " + nbrCages + " cages.");
         */
        //Instruction 2
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = sc.nextLine();

        int nbrCages;
        do {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            nbrCages = sc.nextInt();
        } while (nbrCages <= 0);

        System.out.println(zooName + " comporte " + nbrCages + " cages.");
        //Prosit 2
        Animal lion = new Animal();
        lion.family = "Félidé";
        lion.name = "Lion";
        lion.age = 5;
        lion.isMammal = true;

        Zoo myZoo = new Zoo();
        myZoo.name = "Parc Animalier";
        myZoo.city = "Tunis";
       // myZoo.nbrCages = 20;

       // System.out.println("Zoo : " + myZoo.name + " à " + myZoo.city);
        System.out.println("Animal : " + lion.name + " (" + lion.family + ")");

        Animal lion1 = new Animal("Félidé", "Lion", 5, true);
       // Zoo myZoo1 = new Zoo("Parc Animalier", "Tunis", 20);

        System.out.println("Animal créé : " + lion1.name);
        //System.out.println("Zoo créé : " + myZoo1.name + " (" + myZoo.city + ")");

        myZoo.displayZoo();
        System.out.println(myZoo);
        //Prosit 3
        Zoo zoo1 = new Zoo("Zoo Esprit", "Tunis");
        Zoo zoo2 = new Zoo("Zoo Safari", "Sousse");

        Animal tigre = new Animal("Félidé", "Shere Khan", 7, true);
        Animal lion2 = new Animal("Félidé", "Lion", 5, true); // identique à lion
        // Test Ajout
        zoo1.addAnimal(lion);
        zoo1.addAnimal(tigre);
        zoo1.addAnimal(lion2); // doit être refusé (doublon)

        // Test Affichage
        zoo1.displayAnimals();

        // Test Recherche
        System.out.println("Indice : " + zoo1.searchAnimal(lion));
        System.out.println("Indice : " + zoo1.searchAnimal(tigre));

        // Test Suppression
        zoo1.removeAnimal(tigre);
        zoo1.displayAnimals();

        // Test Zoo plein
        for (int i = 0; i < 30; i++) {
            zoo1.addAnimal(new Animal("TestFamily", "Animal" + i, 2, false));
        }
        System.out.println("Zoo plein " + zoo1.isZooFull());

        // Test Comparaison
        zoo2.addAnimal(new Animal("Canidés", "Wolf", 4, true));
        Zoo plusGrand = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Zoo avec le plus d'animaux : " + plusGrand);
    }
}
