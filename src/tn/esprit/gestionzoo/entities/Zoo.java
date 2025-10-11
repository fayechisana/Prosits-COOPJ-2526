package tn.esprit.gestionzoo.entities;

public class Zoo {
     final int NBR_CAGES = 25;   // constante
     Animal[] animals;
     private String name;
     String city;
     int animalCount;// compteur d’animaux
    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int count; // nombre d'animaux ajoutés
    public Zoo(){}
    // Constructeur paramétré
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
    }
    public void displayZoo() {
        System.out.println("tn.esprit.gestionzoo.entities.Zoo : " + name + ", Ville : " + city + ", Cages : " + NBR_CAGES);
    }
    @Override
    public String toString() {
        return "tn.esprit.gestionzoo.entities.Zoo [Nom=" + name + ", Ville=" + city + ", Cages=" + NBR_CAGES + "]";
    }
    // ✅ Instruction 10 : Ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (animalCount >= NBR_CAGES) {
            System.out.println("Le zoo est plein, impossible d'ajouter l'animal");
            return false;
        }
        // Vérifie l’unicité
        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal existe déjà");
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }
    // ✅ Instruction 11 : Afficher les animaux
    public void displayAnimals() {
        System.out.println("Liste des animaux dans le zoo " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    // ✅ Instruction 11 : Recherche d’un animal par nom
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }
    // ✅ Instruction 13 : Suppression d’un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal introuvable");
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }
    // ✅ Instruction 15 : Vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    // ✅ Instruction 15 : Comparer deux zoos
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) return z1;
        else if (z2.animalCount > z1.animalCount) return z2;
        else {
            return null; // identiques
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null ) {
            this.name = name;
        } else {
            System.out.println("Erreur : le nom du zoo ne peut pas être vide.");
        }
    }
    // Instruction 25 : Ajouter un animal aquatique
    public void addAquaticAnimal(Aquatic aquatic) {
        if (count < aquaticAnimals.length) {
            aquaticAnimals[count++] = aquatic;
        } else {
            System.out.println("Zoo is full! Cannot add more aquatic animals.");
        }
    }
    // Instruction 26 : Appeler swim() pour tous les animaux aquatiques
    public void swimAll() {
        for (int i = 0; i < count; i++) {
            aquaticAnimals[i].swim();
        }
    }
    // Instruction 27 : Profondeur maximale des pingouins
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;
        for (int i = 0; i < count; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > maxDepth) {
                    maxDepth = p.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }
    // Instruction 28 : Affichage du nombre par type
    public void displayNumberOfAquaticsByType() {
        int dolphins = 0, penguins = 0;
        for (int i = 0; i < count; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) dolphins++;
            if (aquaticAnimals[i] instanceof Penguin) penguins++;
        }
        System.out.println("Number of Dolphins: " + dolphins);
        System.out.println("Number of Penguins: " + penguins);
    }

}
