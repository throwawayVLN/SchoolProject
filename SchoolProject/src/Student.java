public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    private static int totalStudents = 0; // this variable shows how many instances of Student is created and helps to make sure we assign a unique student number to each student

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade; 
        studentNumber = totalStudents++; // the new student's number is equal the total number of students, therefore, each student number will be unique
    }

    /* setter and getter for first name */
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /* setter and getter for last name */
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    /* setter and getter for grade */
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    /* prints the information of the student: "Name: name Grade: grade" */
    public String toString() { return "Name: " + firstName + ' ' + lastName + "\tGrade: " + grade; }

    /* getter for student number */
    public int getStudentNumber() { return studentNumber; }
}
