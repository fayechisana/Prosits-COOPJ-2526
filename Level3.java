package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();
 /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms
 des enseignants en majuscule separés par # */

        String names = teachers.stream()
                        .map(teacher -> teacher.getName().toUpperCase())
                .reduce(((s, s2) ->s+"#"+s2 ))
                        .get();

        System.out.println("TO DO 1-------------------");
        System.out.println(names);

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream()
                        .filter(t->t.getSubject().equals(Subject.JAVA))
                                .filter(teacher -> teacher.getSalary()>80000)
                                        .collect(Collectors.toSet());


        System.out.println("TO DO 2------------------------");
        System.out.println(teachers1);


        /* TO DO 3: Retourner une TreeSet d'enseignants
        (tri par nom et en cas d'égalité tri par salaire) */
        Comparator<Teacher> cm = new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        TreeSet<Teacher> teachers2 =teachers.stream()
                .collect(Collectors.toCollection(()->
                        new TreeSet<>(cm.thenComparing((a,b)->a.getSalary()-b.getSalary()))));
                       // .sorted(cm.thenComparing((a,b)->a.getSalary()- b.getSalary()))

        System.out.println("TO DO 3--------------------------");
        //System.out.println(teachers2);

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject, List<Teacher>> map1 = teachers.stream()
                        .collect(Collectors.groupingBy(teacher -> teacher.getSubject()));

        System.out.println("TO DO 4---------------------");
        System.out.println(map1);
        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants
        par salaire */

        Map<Integer, String> map2 = teachers.stream()
                        .collect(Collectors.toMap(a->a.getSalary(),b->b.getName(),(x,y)->x+" "+y));

        System.out.println("TO DO 5--------------------------");
        System.out.println(map2);
        //Map<Integer, String> map3 = teachers.stream()

        /* TO DO 6: Afficher les nom des enseignants de chaque module */
        System.out.println("TO DO 6-------------------------------------");
        map1.entrySet().stream().collect(Collectors.toMap(entry->entry.getKey()
                ,entry->entry.getValue().stream().map(t->t.getName()).reduce((a,b)->a+" "+b).get()))
                .entrySet().stream().forEach(x->{
                    System.out.println(x.getKey());
                    System.out.println(x.getValue());
                });



    }
}
