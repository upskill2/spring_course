package aop;

public class Student {

    private String surname;
    private int course;
    private double averageGrade;


    public Student(String surname, int course, double averageGrade) {
        this.surname = surname;
        this.course = course;
        this.averageGrade = averageGrade;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", course=" + course +
                ", abGrade=" + averageGrade +
                '}';
    }
}
