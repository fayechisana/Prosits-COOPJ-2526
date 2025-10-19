package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

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

       // System.out.println("tn.esprit.gestionzoo.entities.Zoo : " + myZoo.name + " à " + myZoo.city);
        System.out.println("tn.esprit.gestionzoo.entities.Animal : " + lion.name + " (" + lion.family + ")");

        Animal lion1 = new Animal("Félidé", "Lion", 5, true);
       // tn.esprit.gestionzoo.entities.Zoo myZoo1 = new tn.esprit.gestionzoo.entities.Zoo("Parc Animalier", "Tunis", 20);

        System.out.println("tn.esprit.gestionzoo.entities.Animal créé : " + lion1.name);
        //System.out.println("tn.esprit.gestionzoo.entities.Zoo créé : " + myZoo1.name + " (" + myZoo.city + ")");

        myZoo.displayZoo();
        System.out.println(myZoo);
        //Prosit 3
        Zoo zoo1 = new Zoo("tn.esprit.gestionzoo.entities.Zoo Esprit", "Tunis");
        Zoo zoo2 = new Zoo("tn.esprit.gestionzoo.entities.Zoo Safari", "Sousse");

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

        // Test tn.esprit.gestionzoo.entities.Zoo plein
        for (int i = 0; i < 30; i++) {
            zoo1.addAnimal(new Animal("TestFamily", "tn.esprit.gestionzoo.entities.Animal" + i, 2, false));
        }
        System.out.println("tn.esprit.gestionzoo.entities.Zoo plein " + zoo1.isZooFull());

        // Test Comparaison
        zoo2.addAnimal(new Animal("Canidés", "Wolf", 4, true));
        Zoo plusGrand = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("tn.esprit.gestionzoo.entities.Zoo avec le plus d'animaux : " + plusGrand);
        //--------------------- Prosit 5
        // ✅ Instruction 21 : Constructeurs par défaut
        System.out.println("=== Constructeurs par défaut ===");
        //Aquatic a1 = new Aquatic();
        Terrestrial t1 = new Terrestrial();
        Dolphin d1 = new Dolphin();
        Penguin p1 = new Penguin();

       // System.out.println(a1);
        System.out.println(t1);
        System.out.println(d1);
        System.out.println(p1);

        // ✅ Instruction 22 : Constructeurs paramétrés
        System.out.println("\n=== Constructeurs paramétrés ===");
        //Aquatic a2 = new Aquatic("Fish", "Shark", 8, false, "Ocean");
        Terrestrial t2 = new Terrestrial("Felidae", "Lion", 5, true, 4);
        Dolphin d2 = new Dolphin("Delphinidae", "Flipper", 6, true, "Sea", 25.5f);
        Penguin p2 = new Penguin("Spheniscidae", "Pingo", 3, false, "Iceberg", 15.0f);

       // System.out.println(a2);
        System.out.println(t2);
        System.out.println(d2);
        System.out.println(p2);

        // ✅ Instruction 24 : Méthode swim()
        System.out.println("=== Test des méthodes swim() ===");
       // a2.swim();  // Aquatic
        d2.swim();  // Dolphin (redéfinition)
        p2.swim();  // Penguin hérite de Aquatic → même message que Aquatic
        System.out.println("Prosit 6-------------");
        // Ajouter dans le zoo
        myZoo.addAquaticAnimal(d1);
        myZoo.addAquaticAnimal(p1);

        // Appeler swim()
        myZoo.swimAll();
        // Profondeur maximale des pingouins
        System.out.println("Max Penguin Swimming Depth: " + myZoo.maxPenguinSwimmingDepth());

        // Nombre d’animaux par type
        myZoo.displayNumberOfAquaticsByType();

        // Vérifier equals
        Dolphin dolphin2 = new Dolphin("Flipper","Ocean",5,true,"Sea",30);
        System.out.println("d1 equals dolphin2? " + d1.equals(dolphin2));

        System.out.println("----------------Prosit 7");
        //  1. Animal valide
        try {
            myZoo.addAnimal(new Animal("Lion", 5));
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        System.out.println();

        //  2. Animal avec âge négatif
        try {
            myZoo.addAnimal(new Animal("Serpent", -2));
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        System.out.println();

        //  3. Ajouts jusqu’à dépassement de capacité
        try {
            myZoo.addAnimal(new Animal("Tigre", 3));
            myZoo.addAnimal(new Animal("Girafe", 7));
            myZoo.addAnimal(new Animal("Zèbre", 4)); // Dépassement ici
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        myZoo.displayAnimals();
    }
}
