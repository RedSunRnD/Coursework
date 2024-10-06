public class Main {
    private static final Employee[] employees = new Employee[10];
    private static int employeeCount = 0;

    public static void main(String[] args) {
//        addEmployee("Аркадий Натанович Стругацкий", 1, 124000);
        addEmployee("Борис Натанович СТругацкий", 1, 122800);
        addEmployee("Виктор Робертович Цой", 2, 150000);
//        addEmployee("Владимир Семёнович Высоцкий", 2, 135000);
        addEmployee("Евгений Павлович Леонов", 3, 132000);
        addEmployee("Юрий Владимирович Никулин", 3, 137000);
//        addEmployee("Казимир Северенович Малевич", 4, 115000);
        addEmployee("Виктор Михайлович Васнецов", 4, 100000);
        addEmployee("Владимир Николаевич Челомей", 5, 121000);
        addEmployee("Сергей Павлович Королёв", 5, 160000);

        checkEmployeesCount();
        printAllEmployees();
        System.out.println("Сумма затрат на ЗП = " + totalSalary());
        System.out.println("Минимальная ЗП = " + minSalary());
        System.out.println("Максимальная ЗП = " + maxSalary());
        System.out.println("Средняя ЗП = " + averageSalary());
        printEmployeeName();
        indexSalary(5);
        printAllEmployees();
        System.out.println("Сотрудник с минимальной ЗП в отделе №4: " + findMinSalaryByDepartment(5));
        System.out.println("Сотрудник с максимальной ЗП в отделе №5: " + findMaxSalaryByDepartment(5));
        System.out.println("Сумма затрат на отдел №3 = " + calculateTotalByDepartment(3));
        System.out.println("Средняя ЗП в отделе №2 = " + calculateAverageByDepartment(2));
        indexSalaryByDepartment(5, 5);
        printAllEmployees();
        printEmployeesByDepartment(5);
        System.out.println("Сотрудники с зарплатой меньше 140000:");
        printEmployeesWithSalaryLessThan(140000);
        System.out.println("Сотрудники с зарплатой больше 140000:");
        printEmployeesWithSalaryMoreOreEqualThan(140000);
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

    private static void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }
    private static Employee findMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    private static Employee findMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    private static double calculateTotalByDepartment(int department) {
        double totalByDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalByDepartment = totalByDepartment + employee.getSalary();
            }
        }
        return totalByDepartment;
    }

    private static double calculateAverageByDepartment(int department) {
        double totalByDepartment = 0;
        double averageByDepartment = 0;
        int employeeCountByDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalByDepartment = totalByDepartment + employee.getSalary();
                employeeCountByDepartment++;
            }
        }
        averageByDepartment = totalByDepartment / employeeCountByDepartment;
        return averageByDepartment;
    }

    private static void indexSalaryByDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    private static void printEmployeesByDepartment(int department) {
        System.out.println("Сотрудник отдела № " + department + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.toString().replace("Отдел: " + department + " ", ""));
            }
        }
    }

    private static void printEmployeesWithSalaryLessThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() + ", Имя: " + employee.getFullName() + ", Зарплата: " + employee.getSalary() + ".");
            }
        }
    }

    private static void printEmployeesWithSalaryMoreOreEqualThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() + ", Имя: " + employee.getFullName() + ", Зарплата: " + employee.getSalary() + ".");
            }
        }
    }
}