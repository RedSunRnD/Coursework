public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private int employeeCount = 0;

    public void checkEmployeesCount() {
        if (employeeCount == 0) {
            throw new RuntimeException("Нет данных о сотрудниках");
        }
    }

    public void addEmployee(String name, int department, double salary) { // Перенесено
        if (employeeCount < employees.length) {
            employees[employeeCount++] = new Employee(name, department, salary);
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void printAllEmployees() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double totalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total = total + employee.getSalary();
            }
        }
        return total;
    }

    public double minSalary() {
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

    public double maxSalary() {
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

    public double averageSalary() {
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

    public void printEmployeeName() {
        System.out.println("Список имен всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }
    public Employee findMinSalaryByDepartment(int department) {
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

    public Employee findMaxSalaryByDepartment(int department) {
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

    public double calculateTotalByDepartment(int department) {
        double totalByDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalByDepartment = totalByDepartment + employee.getSalary();
            }
        }
        return totalByDepartment;
    }

    public double calculateAverageByDepartment(int department) {
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

    public void indexSalaryByDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployeesByDepartment(int department) {
        System.out.println("Сотрудник отдела № " + department + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.toString().replace("Отдел: " + department + " ", ""));
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() + ", Имя: " + employee.getFullName() + ", Зарплата: " + employee.getSalary() + ".");
            }
        }
    }

    public void printEmployeesWithSalaryMoreOreEqualThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() + ", Имя: " + employee.getFullName() + ", Зарплата: " + employee.getSalary() + ".");
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
