public class Main {
    private static final Employee[] employees = new Employee[10];
    private static int employeeCount = 0;

    public static void main(String[] args) {
        addEmployee("Аркадий Натанович Стругацкий", 1, 124000);
        addEmployee("Борис Натанович СТругацкий", 1, 122800);
        addEmployee("Виктор Робертович Цой", 2, 150000);
        addEmployee("Владимир Семёнович Высоцкий", 2, 135000);
        addEmployee("Евгений Павлович Леонов", 3, 132000);
        addEmployee("Юрий Владимирович Никулин", 3, 137000);
        addEmployee("Казимир Северенович Малевич", 4, 110000);
        addEmployee("Виктор Михайлович Васнецов", 4, 105000);
        addEmployee("Владимир Николаевич Челомей", 5, 121000);
        addEmployee("Сергей Павлович Королёв", 5, 160000);

        checkEmployeesCount();
        printAllEmployees();
        System.out.println("Сумма затрат на ЗП = " + totalSalary());
        System.out.println("Минимальная ЗП = " + minSalary());
        System.out.println("Максимальная ЗП = " + maxSalary());
        System.out.println("Средняя ЗП = " + averageSalary());
        printEmployeeName();
    }

    private static void checkEmployeesCount() {
        if (employeeCount == 0) {
            throw new RuntimeException("Нет данных о сотрудниках");
        }
    }

    private static void addEmployee(String fullName, int department, double salary) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = new Employee(fullName, department, salary);
        } else {
            throw new IndexOutOfBoundsException("Хранилище сотрудников заполнено!");
        }
    }

    private static void printAllEmployees() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static double totalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total = total + employee.getSalary();
            }
        }
        return total;
    }

    private static double minSalary() {
        double min = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                }
            }
        }
        return min;
    }

    private static double maxSalary() {
        double max = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                }
            }
        }
        return max;
    }

    private static double averageSalary() {
        double average;
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesCount++;
            }
        }
        average = totalSalary() / employeesCount;
        return average;
    }

    private static void printEmployeeName() {
        System.out.println("Список имен всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}