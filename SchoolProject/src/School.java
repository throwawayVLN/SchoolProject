import java.util.ArrayList;
import java.util.Objects;

public class School {
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();

    public String name; // the name of the school
    public boolean isPublic; // shows whether the school is public or private
    public String city; // the city in which the school is located

    /* default constructor */
    public School() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.name = "";
        this.isPublic = true;
        this.city = "";
    }

    /* constructor that gets all fields to initialize */
    public School(ArrayList<Teacher> teachers, ArrayList<Student> students,
                  ArrayList<String> courses, String name, boolean isPublic, String city) {
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
        this.name = name;
        this.isPublic = isPublic;
        this.city = city;
    }

    /* constructor that only gets name and isPublic and city, but initializes all fields */
    public School(String name, boolean isPublic, String city) {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.name = name;
        this.isPublic = isPublic;
        this.city = city;
    }

    /* getter and setter for name of the school */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /* getter and setter for isPublic */
    public boolean isPublic() { return isPublic; }
    public void setPublic(boolean aPublic) { isPublic = aPublic; }

    /* getter and setter for city */
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    /* getter and setter for teachers list */
    public ArrayList<Teacher> getTeachers() { return teachers; }
    public void setTeachers(ArrayList<Teacher> teachers) { this.teachers = teachers; }

    /* getter and setter for students list */
    public ArrayList<Student> getStudents() { return students; }
    public void setStudents(ArrayList<Student> students) { this.students = students; }

    /* getter and setter for courses list */
    public ArrayList<String> getCourses() { return courses; }
    public void setCourses(ArrayList<String> courses) { this.courses = courses; }

    /* gets a teacher as a parameter and adds it to the end of the teachers list */
    public void addTeacher(Teacher newTeacher) { teachers.add(newTeacher); }

    /* gets a students object as its parameter and adds it to the end of the students list */
    public void addStudent(Student newStudent) { students.add(newStudent); }

    /* gets a teacher object and removes a teacher from the list*/
    public void deleteTeacher(Teacher teacher) {
        teachers.removeIf(t -> (teacher == t));

        // only removes the teacher if their name is on the list, I'm not sure if it's what the criteria asked
        /* teachers.removeIf(t -> (teacher.getFirstName().equals(t.getFirstName()) &&
                teacher.getLastName().equals(t.getLastName()))); */
    }

    /* gets a student object and removes a student from the list if it has the same name */
    public void deleteStudent(Student student) {
        students.removeIf(s -> (student.getFirstName().equals(s.getFirstName()) &&
                                student.getLastName().equals(s.getLastName())));

        // or I could use the following expression
        /* students.removeIf(s -> (s == student) */
    }

    /* displays all of the teachers on the teachers list */
    public void displayTeachers() { teachers.forEach(t -> System.out.println(t)); }

    /* displays all of the students on the students list */
    public void displayStudents() { students.forEach(s -> System.out.println(s)); }

}
