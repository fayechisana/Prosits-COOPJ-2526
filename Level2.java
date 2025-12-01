package levels;
import models.Subject;
import models.Teacher;
import utils.Data;
//
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//
public class Level2 {
//
   public static void main(String[] args) {
       System.out.println("to do 1");
        List<Teacher> teachers = Data.employees();
        /* TO DO 1: Retourner le nombre des ensei
        gnants dont le nom commence avec s */
       long nbr = teachers.stream()
                       .filter(t->t.getName().startsWith("s") )
                               .count();



       System.out.println(nbr);

       /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
       System.out.println("to do 2");
       long sum = teachers.stream()
               .filter(t->t.getSubject().equals(Subject.FLUTTER) )
                       .mapToInt(t-> t.getSalary())
                               .sum();



       System.out.println(" la somme est " + sum);

       System.out.println("to do 3");
//        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream()
                        .filter(t->t.getName().startsWith("a"))
                                .mapToInt(Teacher->Teacher.getSalary())
                                        .average().getAsDouble();

       System.out.println("etourner la moyenne des salaires des enseignants dont le nom commence avec a " + average);


//        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream()
                        .filter(teacher ->teacher.getName().startsWith("f") )
                                .toList();

       System.out.println("to do 4" + teachers1);
//
//        /* TO DO 5: Retourner set des enseignants dont le nom commence par s */
       Set<Teacher> teachers2 = teachers.stream()
                       .filter(t->t.getName().startsWith("s"))
                               .collect(Collectors.toSet());



       System.out.println("to do 5" + teachers2);

//         TO DO 6: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
           boolean test = teachers.stream()
                           .anyMatch(teacher -> teacher.getSalary()>100000);

           System.out.println(test);

//
//        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
//        /*First way*/
        teachers.stream()
                .filter(t->t.getSubject().equals(Subject.UNITY))
                        .filter(t->t.getName().startsWith("g"))
                                .findFirst().ifPresent(x-> System.out.println(x));




//        /*Second way*/
        teachers.stream()
                .filter(t->t.getSubject().equals(Subject.UNITY))
                .filter(t->t.getName().startsWith("g"))
                        .limit(1).forEach(x-> System.out.println(x));

    /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("s"))
                        .skip(1).limit(1).forEach(x-> System.out.println(x));

//


   }
}
