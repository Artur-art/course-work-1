public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        employees[0] = new Employee("Hulk Hogan", 2, 123675.87);
        employees[1] = new Employee("Dwayne Jhonson", 3, 87641.87);
        employees[2] = new Employee("Billie Kay", 3, 99530.87);
        employees[3] = new Employee("Anwar Jimbawi", 2, 75360.87);
        employees[4] = new Employee("Akina Minami", 3, 55754.87);
        employees[5] = new Employee("Franklin Jhonson", 2, 97246.87);
        printArray();
        System.out.println("Сумма зарплат работников: " + sumSalaries(employees));
        int neededDepartment = 2;
        Employee[] neededDepartmentArray = filterByDepartment(neededDepartment);
        System.out.println("Сотрудник с минимальной зарплатой: " + finEmployeeWithMinSalary(neededDepartmentArray));
        System.out.println("Сотрудник с максимальной зарплатой: " + finEmployeeWithMaxSalary(neededDepartmentArray));
        System.out.printf("Средняя зарплата сотрудников: %.2f\n ", averageSalary(neededDepartmentArray));
        printFullNames();
        neededDepartmentArray = filterByDepartment(neededDepartment);
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + neededDepartment + " " + finEmployeeWithMinSalary(neededDepartmentArray));
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + neededDepartment + " " + finEmployeeWithMaxSalary(neededDepartmentArray));
        System.out.println("Сумму затрат на зарплату по отделу " + neededDepartment + " " + sumSalaries(neededDepartmentArray));
        System.out.printf("Средняя  зарплата работников  отдела " + neededDepartment + ": %.2f\n", averageSalary(neededDepartmentArray));
        increaseSalariesInDepartment(neededDepartment, 10);
        neededDepartmentArray = filterByDepartment(neededDepartment);
        System.out.println("Сотрудники отдела " + neededDepartment + " после индексации зарплаты");
        printArray(neededDepartment);
        System.out.println("Сотрудники с зарплатой меньшей чем 45к: ");
        printEmployeesWithSalaryLessThan(45000);
        System.out.println("Сотрудники с зарплатой большей или равной 45к: ");
        printEmployeesWithSalaryMoreThan(45000);
    }


    public static void printArray() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }

        }
    }

    public static void printArray(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toStringWithoutDpartment());
            }
        }
    }

    public static double sumSalaries(Employee[] empls) {
        double result = 0;
        for (int i = 0; i < empls.length; i++) {
            if (empls[i] != null) {
                result += empls[i].getSalary();
            }
        }
        return result;
    }

    public static Employee finEmployeeWithMinSalary(Employee[] empls) {
        Employee result = empls[0];
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < empls.length; i++) {
            if (empls[i] != null && empls[i].getSalary() < min) {
                min = empls[i].getSalary();
                result = empls[i];
            }
        }
        return result;
    }

    public static Employee finEmployeeWithMaxSalary(Employee[] empls) {
        Employee result = empls[0];
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < empls.length; i++) {
            if (empls[i] != null && empls[i].getSalary() > max) {
                max = empls[i].getSalary();
                result = empls[i];
            }
        }
        return result;
    }

    public static double averageSalary(Employee[] empls) {
        int couterOfNotNullElements = 0;
        for (int i = 0; i < empls.length; i++) {
            if (empls[i] != null) {
                couterOfNotNullElements++;
            }
        }
        return sumSalaries(empls) / couterOfNotNullElements;
    }

    public static void printFullNames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullname());

            }
        }
    }

    public static void increaseSalaries(double rate) {
        double coeff = 1 + rate / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * coeff);
            }
        }
    }

    public static void increaseSalariesInDepartment(int department, double rate) {
        double coeff = 1 + rate / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * coeff);

            }
        }
    }

    public static Employee[] filterByDepartment(int department) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                counter++;
            }
        }
        Employee[] result = new Employee[counter];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                result[index] = employees[i];
                index++;
            }
        }
        return result;
    }

    public static void printEmployeesWithSalaryLessThan(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                System.out.println(employees[i].toStringWithoutDpartment());

            }
        }
    }

    public static void printEmployeesWithSalaryMoreThan(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                System.out.println(employees[i].toStringWithoutDpartment());

            }
        }
    }
}


