public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    /* setter and getter for first name */
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /* setter and getter for last name */
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    /* setter and getter for subject */
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    /* prints the information of the teacher: "Name: name Subject: subject" */
    public String toString() { return "Name: " + firstName + ' ' + lastName + "\t Subject: " +  subject; }
}
