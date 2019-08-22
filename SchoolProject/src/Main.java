public class Main {
    public static void main(String[] args) {
        School school = new School("VLN", false, "Vancouver");

        // adding 10 students
        for (int i = 1; i < 11; ++i) {
            String first = "", last = "";
            for (int j = 0; j < i; ++j) { first += "f"; last += "l"; }

            school.addStudent(new Student(first, last, i));
        }


        // creating 3 teachers
        Teacher l = new Teacher("Linus", "Torvalds", "Linux"),
                j = new Teacher("James", "Gosling", "Java"),
                r = new Teacher("Richard", "Stallman", "GNU");

        // adding 3 teachers
        school.addTeacher(l);
        school.addTeacher(j);
        school.addTeacher(r);

        // displaying all students and teachers
        school.displayStudents();
        System.out.println();
        school.displayTeachers();

        // removing two students
        Student bad = new Student("f", "l", 1);
        Student bad1 = new Student("ff", "ll", 2);
        school.deleteStudent(bad);
        school.deleteStudent(bad1);

        // removing a teacher
        school.deleteTeacher(l);

        System.out.println("-----");
        school.displayTeachers();
        school.displayStudents();
    }
}
