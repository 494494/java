import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five= 5;
        Integer[] others={0,5,10,-50,50};
        for(var i: others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: comapreTo= %d%n",five,(val==0?"==":(val<0)?"< ":">"),i,val);
        }
        String banana="banana";
        String[] fruits={"apple","Grapes","papaya","banana","tomato"};
        for(String f: fruits){
            int val = banana.compareTo(f);
            System.out.printf("%s %s %s: comapreTo= %d%n",banana,(val==0?"==":(val<0)?"< ":">"),f,val);
            Arrays.sort(fruits);
            System.out.println(Arrays.toString(fruits));
        }
        Student tim=new Student("Tim");
        Student[] students={
          new Student("Zach"),
          new Student("Tim") ,
          new Student("Ann")
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Comparator<Student> gpaComparator=new StudentgpaComparator();
        Arrays.sort(students,gpaComparator.reversed());
        System.out.println(Arrays.toString(students));
    }
}

class StudentgpaComparator implements Comparator<Student>{
    public int compare(Student o1,Student o2){
        return (o1.gpa+ o1.name).compareTo((o2.gpa+ o2.name));
    }
}

class Student implements Comparable<Student>{

    private static int LAST_Id=1000;
    private static Random random=new Random();

    String name;
    private int id;
    protected double gpa;

    public Student(String name){
        this.name=name;
        id=LAST_Id++;
        gpa= random.nextDouble(1,4);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
