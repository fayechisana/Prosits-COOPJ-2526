package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        System.out.println("---to do 1");
        teachers.stream().forEach(x-> System.out.println(x));

        /*
         * TO DO 2: Afficher les enseignants dont
         * le nom commence par la lettre n
         */
        System.out.println("---------TO do 2");
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("n"))
                .forEach(teacher -> System.out.println(teacher));

        /*
         * TO DO 3: Afficher les enseignants
         * dont le nom commence par la lettre n et
         * le salaire > 100000
         */
        System.out.println("---------TO do 3");
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("n")&&
                        teacher.getSalary()>100000)
//                .filter(teacher -> teacher.getSalary()>100000)
                .forEach(teacher -> System.out.println(teacher));
        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire
         * (éliminer les redondances)
         */
        System.out.println("---------TO do 4");
       teachers.stream()
               .filter(t->t.getSubject().equals(Subject.JAVA))
                       .sorted((t1,t2)->t1.getSalary()- t2.getSalary())
                               .distinct()
                                       .forEach(t-> System.out.println(t));



        /*
         * TO DO 5: Afficher les noms des enseignants dont
         * le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */  System.out.println("---------TO do 5.1");
       teachers.stream()
               .filter(t->t.getSalary()>60000)
                       .map(t->t.getName())
                               .forEach(s -> System.out.println(s));



        /* Second Way */ System.out.println("---------TO do 5.2");
        teachers.stream()
                .filter(t->t.getSalary()>60000)
                        .forEach(t-> System.out.println(t.getName()));

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants
         * dont le nom commence par m et
         *  afficher celui qui a le salaire le plus élevé
         */ System.out.println("---------TO do 6");
        teachers.stream()
                .filter(t->t.getName().startsWith("m"))
                .peek(t->t.setSalary(t.getSalary()+200))
                .max((t1,t2)->t1.getSalary()-t2.getSalary())
                .ifPresent(t-> System.out.println(t));




    }
}
