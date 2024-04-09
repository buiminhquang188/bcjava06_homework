package org.cybersoft.buoi8.bai2;

public class Students {
    public static boolean isContainStudentID(Student[] students, String ID) {
        boolean isContainStudentID = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].ID.equalsIgnoreCase(ID)) {
                isContainStudentID = true;
                break;
            }
        }

        return isContainStudentID;
    }

    public static void seedStudent(Student[] students) {
        students[0] = new Student("Quang", "MS01", 4f, 4f, 4f);
        students[1] = new Student("Dung", "MS02", 5f, 5f, 5f);
        students[2] = new Student("Dung", "MS03", 6f, 6f, 6f);
        students[3] = new Student("Tran", "MS04", 7f, 7f, 7f);
        students[4] = new Student("Thinh", "MS05", 8f, 8f, 8f);
        students[5] = new Student("Thanh", "MS06", 9f, 9f, 9f);
    }

    public static void printStudents(Student[] students) {
        String leftAlignFormat = "| %-6s | %-8s | %-8.2f | %-11.2f | %-13.2f | %-7.2f | %-12s |%n";

        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
        System.out.format("| ID     | Name     | Math     | Physics     | Chemistry     | GPA     | Capacity     |%n");
        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.format(leftAlignFormat, students[i].ID, students[i].name, students[i].math, students[i].physics, students[i].chemistry, students[i].gpa, students[i].getStudentCapacity());
            }
        }
        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
    }

    public static Student getStudentByHighestGPA(Student[] students) {
        Student highestGPAStudent = students[0];
        for (int i = 0; i < students.length; i++) {
            if (students[i].gpa > highestGPAStudent.gpa) {
                highestGPAStudent = students[i];
            }
        }
        return highestGPAStudent;
    }

    public static Student[] getStudentByWeakGPA(Student[] students) {
        int numberOfWeakStudent = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentCapacity()
                    .equalsIgnoreCase("Weak")) {
                numberOfWeakStudent++;
            }
        }

        Student[] weakStudents = new Student[numberOfWeakStudent];
        int weakStudentIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentCapacity()
                    .equalsIgnoreCase("Weak")) {
                weakStudents[weakStudentIndex] = students[i];
                weakStudentIndex++;
            }
        }

        return weakStudents;
    }

    public static Student[] getStudentByName(Student[] students, String name) {
        int numberOfStudentFound = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(name)) {
                numberOfStudentFound++;
            }
        }

        Student[] studentsByName = new Student[numberOfStudentFound];
        int studentsByNameIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(name)) {
                studentsByName[studentsByNameIndex] = students[i];
                studentsByNameIndex++;
            }
        }

        return studentsByName;
    }

    public static Student[] getStudentByID(Student[] students, String ID) {
        int numberOfStudentIDFound = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].ID.equalsIgnoreCase(ID)) {
                numberOfStudentIDFound++;
            }
        }

        Student[] studentsByName = new Student[numberOfStudentIDFound];
        int studentsByIDIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].ID.equalsIgnoreCase(ID)) {
                studentsByName[studentsByIDIndex] = students[i];
                studentsByIDIndex++;
            }
        }

        return studentsByName;
    }

    public static Student[] deleteStudentByID(Student[] students, String ID) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].ID.equalsIgnoreCase(ID)) {
                students[i] = null;
            }
        }

        return students;
    }
}
