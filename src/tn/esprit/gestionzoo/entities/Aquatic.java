package tn.esprit.gestionzoo.entities;

public abstract  class Aquatic extends Animal {
    protected String habitat;

    // Constructeur par défaut
    public Aquatic() {
    }

    // Constructeur paramétré
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Habitat: " + habitat;
    }

    // Méthode abstraite : doit être redéfinie dans les sous-classes
    public abstract void swim();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aquatic)) return false;
        Aquatic a = (Aquatic) o;
        return this.name.equals(a.name) && this.age == a.age && this.habitat.equals(a.habitat);
    }
}
