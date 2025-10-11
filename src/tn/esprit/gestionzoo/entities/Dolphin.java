package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    protected float swimmingSpeed;

    // Constructeur par défaut
    public Dolphin() {
    }

    // Constructeur paramétré
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }



    @Override
    public String toString() {
        return super.toString() + ", Swimming Speed: " + swimmingSpeed + " km/h";
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }
}

