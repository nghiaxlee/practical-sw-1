package prac;

public class Student {
    private String name_;
    private String nationality_;
    private double grades_;


    public Student() {
    }

    public Student(String name_, String nationality_, double grades_) {
        this.name_ = name_;
        this.nationality_ = nationality_;
        this.grades_ = grades_;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name_) {
        this.name_ = name_;
    }

    public String getNationality() {
        return nationality_;
    }

    public void setNationality(String nationality_) {
        this.nationality_ = nationality_;
    }

    public double getGrades() {
        return grades_;
    }

    public void setGrades(double grades_) {
        this.grades_ = grades_;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name_ + '\'' +
                ", nationality='" + nationality_ + '\'' +
                ", grades=" + grades_ +
                '}';
    }
}
