package org.cybersoft.buoi8.bai2;

import java.util.Scanner;

public class User {
    Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getUserOption() {
        int userOptions;

        printMenu();
        System.out.print("Choose options: ");
        userOptions = scanner.nextInt();

        while (userOptions < 0 || userOptions > 7) {
            printMenu();
            System.out.print("Invalid number, please try again: ");
            userOptions = scanner.nextInt();
        }

        return userOptions;
    }

    public int getUserConfirmExit() {
        int userConfirmExit;

        printConfirmExit();
        System.out.print("Do you want to exit?: ");
        userConfirmExit = scanner.nextInt();

        while (userConfirmExit != 0) {
            printConfirmExit();
            System.out.print("Invalid number, please try again: ");
            userConfirmExit = scanner.nextInt();
        }

        return userConfirmExit;
    }

    public int getNumberStudentManual() {
        int numberOfStudent;
        System.out.print("How many student you want to input manually: ");

        numberOfStudent = scanner.nextInt();

        while (numberOfStudent < 0) {
            System.out.print("Invalid number, please try again: ");
            numberOfStudent = scanner.nextInt();
        }

        return numberOfStudent;
    }

    public void getInputStudent(Student[] students, int numberOfStudent, boolean isSeed) {
        int i = isSeed ? 6 : 0;

        for (; i < numberOfStudent; i++) {
            Student student = new Student();
            student.getInformationStudent(students, scanner);
            students[i] = student;
        }
    }

    public String getInputStudentName() {
        System.out.print("Please input student name: ");
        return scanner.next();
    }

    public String getInputStudentID() {
        System.out.print("Please input student ID: ");
        return scanner.next();
    }

    public void printMenu() {
        System.out.println("=========================================================");
        System.out.println("1. Insert new student.");
        System.out.println("2. Print all student.");
        System.out.println("3. Print student have highest GPA");
        System.out.println("4. Print all student have weak capacity");
        System.out.println("5. Find student by name");
        System.out.println("6. Find student by ID");
        System.out.println("7. Delete student by ID");
        System.out.println("0. Exit");
    }

    public void printConfirmExit() {
        System.out.println("=========================================================");
        System.out.println("0. Exit");
    }

    public void printWarningNoStudent() {
        System.out.println("You must insert student first");
    }

    public void processUserOption(int userOption) {
        Student[] students = null;
        while (userOption >= 0 && userOption <= 7) {
            switch (userOption) {
                case 1:
                    if (students != null && students[students.length - 1] != null) {
                        System.out.println("Cannot input more student");
                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        students = processInsertNewStudent(students);
                        userOption = getUserOption();
                    }
                    break;
                case 2:
                    if (students != null) {
                        Students.printStudents(students);
                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                case 3:
                    if (students != null) {
                        Student highestStudentGPA = Students.getStudentByHighestGPA(students);
                        highestStudentGPA.printStudent(highestStudentGPA);

                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                case 4:
                    if (students != null) {
                        Student[] weakStudents = Students.getStudentByWeakGPA(students);
                        Students.printStudents(weakStudents);

                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                case 5:
                    if (students != null) {
                        String studentName = getInputStudentName();
                        Student[] studentByName = Students.getStudentByName(students, studentName);
                        Students.printStudents(studentByName);

                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                case 6:
                    if (students != null) {
                        String studentID = getInputStudentID();
                        Student[] studentsByID = Students.getStudentByID(students, studentID);
                        Students.printStudents(studentsByID);

                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                case 7:
                    if (students != null) {
                        String studentID = getInputStudentID();
                        Student[] studentsByID = Students.deleteStudentByID(students, studentID);
                        Students.printStudents(studentsByID);

                        int userConfirmExit = getUserConfirmExit();

                        if (userConfirmExit == 0) {
                            userOption = getUserOption();
                            break;
                        }
                    } else {
                        printWarningNoStudent();
                    }
                    userOption = getUserOption();
                    break;
                default:
                    scanner.close();
                    return;
            }
        }
    }

    public Student[] processInsertNewStudent(Student[] students) {
        int numberOfSeedStudent = 0;
        int numberOfManualStudent = 0;

        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Do you want to seed student: ");
        int seedOption = scanner.nextInt();

        numberOfManualStudent = getNumberStudentManual();
        while (seedOption == 2 && numberOfManualStudent == 0) {
            System.out.println("You must input number of student when not choose option seed");
            numberOfManualStudent = getNumberStudentManual();
        }

        if (seedOption == 1) {
            numberOfSeedStudent = 6;
            students = new Student[numberOfManualStudent + numberOfSeedStudent];
            Students.seedStudent(students);
            getInputStudent(students, numberOfSeedStudent + numberOfManualStudent, true);
        } else {
            students = new Student[numberOfManualStudent + numberOfSeedStudent];
            getInputStudent(students, numberOfManualStudent, false);
        }

        return students;
    }
}
