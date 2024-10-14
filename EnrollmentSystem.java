// Base class Person
class Person {
    // Fields for Person class
    protected String name;
    protected int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person's information (to be overridden in subclasses)
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Student inheriting from Person
class Student extends Person {
    // Fields for Student class
    private String studentID;
    private String course;
    private int units;
    private final int feePerUnit = 1000; // Fixed fee per unit

    // Constructor to initialize student-specific fields along with name and age
    public Student(String name, int age, String studentID, String course, int units) {
        super(name, age); // Calls the constructor of the Person class
        this.studentID = studentID;
        this.course = course;
        this.units = units;
    }

    // Method to calculate total fees
    public double calculateFees() {
        return units * feePerUnit;
    }

    // Overridden method to display student's information
    @Override
    public void displayInfo() {
        System.out.println("------ Student Information ------");
        super.displayInfo(); // Call to Person's displayInfo method
        System.out.println("Student ID  : " + studentID);
        System.out.println("Course      : " + course);
        System.out.println("Units       : " + units);
        System.out.printf("Total Fees  : P%.2f%n", calculateFees());
        System.out.println("-------------------------------\n");
    }
}

// Subclass Instructor inheriting from Person
class Instructor extends Person {
    // Fields for Instructor class
    private String employeeID;
    private String department;
    private double salary;

    // Constructor to initialize instructor-specific fields along with name and age
    public Instructor(String name, int age, String employeeID, String department, double salary) {
        super(name, age); // Calls the constructor of the Person class
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Overridden method to display instructor's information
    @Override
    public void displayInfo() {
        System.out.println("----- Instructor Information -----");
        super.displayInfo(); // Call to Person's displayInfo method
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.printf("Salary      :   P%.2f%n", salary);
        System.out.println("-------------------------------\n");
    }
}

// Main public class EnrollmentSystem
public class EnrollmentSystem {

    public static void printDetails(Person p) {
        p.displayInfo(); // Dynamic method dispatch
    }

    public static void main(String[] args) {
        // Two Student objects
        Student student1 = new Student("Paul Sandrino", 18, "231003840", "Engineering", 6);
        Student student2 = new Student("Allen Tabije", 19, "231009876", "Engineering", 3);

        // Two Instructor objects
        Instructor instructor1 = new Instructor("Engr. Tanya Jovillano", 22, "712634", "Engineering", 1500000);
        Instructor instructor2 = new Instructor("Engr. Singkwenta", 50, "50505050", "Engineering", 50);

        // Use the polymorphic method to print details of students and instructors
        printDetails(student1);
        printDetails(student2);
        printDetails(instructor1);
        printDetails(instructor2);
    }
}
