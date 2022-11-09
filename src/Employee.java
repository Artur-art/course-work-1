public class Employee {
    private String fullname;
    private int department;
    private double salary;
    private int id;
    private static int counter;

    public Employee(String fullname, int department, double salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        counter++;
        id = counter;
    }

    public String getFullname() {
        return fullname;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%d. %s; Номер отдела: %d; Зарплата: %.2f", id, fullname, department, salary);
    }

    public String toStringWithoutDpartment() {
        return String.format("%d. %s; Зарплата: %.2f",id, fullname,salary);
    }
}
