//package Student_Management;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        Teacher manisha= new Teacher("manisha",1,300);
//        Teacher aman = new Teacher("aman",1,400);
//        List<Teacher>teachers = new ArrayList<>();
//        teachers.add(aman);
//        teachers.add(manisha);
//        Student ram = new Student(1,"ram",4);
//        Student sham = new Student(2,"sham",2);
//
//        List<Student> students = new ArrayList<>();
//        students.add(ram);
//        students.add(sham);
//
//        School ghs = new School(teachers,students);
//        ram.payfee(1000);
//        sham.payfee(100000);
//        System.out.println(ghs.getTotalmoneyearnerd());
//
//
//
//
//    }
//}
package Student_Management;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        System.out.println("Enter details for teachers:");
        System.out.print("How many teachers? ");
        int numTeachers = getIntInput(scanner);
        scanner.nextLine();
        for (int i = 0; i < numTeachers; i++) {
            System.out.print("Enter teacher name: ");
            String teacherName = scanner.nextLine();
            System.out.print("Enter teacher id: ");
            int teacherId = getIntInput(scanner);
            System.out.print("Enter teacher salary: ");
            int teacherSalary = getIntInput(scanner);
            teachers.add(new Teacher(teacherName, teacherId, teacherSalary));
            scanner.nextLine();
        }

        System.out.println("Enter details for students:");
        System.out.print("How many students? ");
        int numStudents = getIntInput(scanner);
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student id: ");
            int studentId = getIntInput(scanner);
            System.out.print("Enter student grade: ");
            int studentGrade = getIntInput(scanner);
            students.add(new Student(studentId, studentName, studentGrade));
            scanner.nextLine();
        }

        School ghs = new School(teachers, students);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Pay fee");
            System.out.println("2. Exit");
            int choice = getIntInput(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID to pay fee: ");
                    int studentId = getIntInput(scanner);
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getId() == studentId) {
                            found = true;
                            System.out.print("Enter amount to pay: ");
                            int amount = getIntInput(scanner);
                            student.payfee(amount);
                            System.out.println("Fee paid successfully.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student ID not found. Please enter a valid student ID.");
                    }
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
}
