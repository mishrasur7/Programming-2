package Task_1;

public class PersonInheritanceProgram {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Chris Date", 3000);
        Teacher teacher2 = new Teacher("Joe Satriani", 5000);
        Student student = new Student("Steve Vai");

        System.out.println(teacher1);
        System.out.println(teacher2);

        System.out.println(student);
        student.completeCourse();
        student.completeCourse();

        System.out.println("---");
        System.out.println(student);
    }
}
