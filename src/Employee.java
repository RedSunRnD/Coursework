import java.util.Objects;

public class Employee {
    private static int counter = 0;
    private final int id;
    private final String fullName;
    private int department;
    private double salary;

    public Employee(String fulName, int department, double salary) {
        this.id = ++counter;
        this.fullName = fulName;
        this.department = department;
        this.salary = salary;
    }

    //Геттеры
    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    //Сеттеры
    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Неверное значение департамента. Введите число от 1 до 5.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Неверное значение зарплаты. Введите положительное число.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter, id, fullName, department, salary);
    }

    @Override
    public String toString() {
        return String.format("ID: " + id + ", ФИО: " + fullName + ", Отдел: " + department + " Зарплата: " + salary + ".");
    }
}
