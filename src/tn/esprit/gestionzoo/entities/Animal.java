package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
   private  int age;
    boolean isMammal;
    public Animal(){}
    // Constructeur paramétré
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }
    @Override
    public String toString() {
        return "tn.esprit.gestionzoo.entities.Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null ) {
            this.name = name;
        } else {
            System.out.println("Erreur : le nom de l'animal ne peut pas être vide.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur : l'âge de l'animal ne peut pas être négatif.");
        }
    }
}
