package ru.geekbrains;

public class lesson4 {

    public static void main(String[] args) {

        employee e0 = new employee("Tom Kakto Tam", 10000, 50);
        employee e1 = new employee("Sam Kakto Tam", 10000, 46);
        employee e2 = new employee("John Kakto Tam", 10000, 30);
        employee e3 = new employee("Bob Kakto Tam", 10000, 25);
        employee e4 = new employee("Fil Kakto Tam", 10000, 20);
        System.out.printf("Employee: %s\n age: %d\n", e4.getFio(), e4.getAge());

        employee[] employees = new employee[5];
        employees[0] = e0;
        employees[1] = e1;
        employees[2] = e2;
        employees[3] = e3;
        employees[4] = e4;

//        for (int i = 0; i < employees.length; i ++) {
//                System.out.printf("ID: %s Employee: %s Salary: %d age: %d\n", employees[i].getId(), employees[i].getFio(), employees[i].getSalary(), employees[i].getAge());
//        }

        for (int i = 0; i < employees.length; i ++) {
            if (employees[i].getAge() > 40) {
                System.out.printf("ID: %s Employee: %s Salary: %d age: %d\n", employees[i].getId(), employees[i].getFio(), employees[i].getSalary(), employees[i].getAge());
            }
        }

        System.out.println("Average Salary: " + getAvgSalary(employees));
        System.out.println("Average Age: " + getAvgAge(employees));

        upSalary(employees, 5000);
    }

    private static void upSalary(employee[] emp, int upsum) {
        for (int i = 0; i < emp.length; i++) {
            System.out.printf("It was: Employee: %s Salary: %d\n", emp[i].getFio(), emp[i].getSalary());
            emp[i].upSalary(upsum);
            System.out.printf("Became: Employee: %s Salary: %d\n", emp[i].getFio(), emp[i].getSalary());
        }

    }

    private static int getAvgSalary(employee[] emp) {
        int salarySum = 0;
        int avg;
        for (int i = 0; i < emp.length; i++) {
            salarySum = salarySum + emp[i].getSalary();
        }
        return avg = salarySum / emp.length;
    }

    private static int getAvgAge(employee[] emp) {
        int ageSum = 0;
        int avg;
        for (int i = 0; i < emp.length; i++) {
            ageSum = ageSum + emp[i].getAge();
        }
        return avg = ageSum / emp.length;
    }
}