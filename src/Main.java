public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Аркадий Натанович Стругацкий", 1, 124000);
        employeeBook.addEmployee("Борис Натанович СТругацкий", 1, 122800);
        employeeBook.addEmployee("Виктор Робертович Цой", 2, 150000);
        employeeBook.addEmployee("Владимир Семёнович Высоцкий", 2, 135000);
        employeeBook.addEmployee("Евгений Павлович Леонов", 3, 132000);
        employeeBook.addEmployee("Юрий Владимирович Никулин", 3, 137000);
        employeeBook.addEmployee("Казимир Северенович Малевич", 4, 115000);
        employeeBook.addEmployee("Виктор Михайлович Васнецов", 4, 100000);
        employeeBook.addEmployee("Владимир Николаевич Челомей", 5, 121000);
        employeeBook.addEmployee("Сергей Павлович Королёв", 5, 160000);
        employeeBook.checkEmployeesCount();
        employeeBook.printAllEmployees();
        System.out.println("Сумма затрат на ЗП = " + employeeBook.totalSalary());
        System.out.println("Минимальная ЗП = " + employeeBook.minSalary());
        System.out.println("Максимальная ЗП = " + employeeBook.maxSalary());
        System.out.println("Средняя ЗП = " + employeeBook.averageSalary());
        employeeBook.printEmployeeName();
        employeeBook.indexSalary(5);
        employeeBook.printAllEmployees();
        System.out.println("Сотрудник с минимальной ЗП в отделе №4: " + employeeBook.findMinSalaryByDepartment(5));
        System.out.println("Сотрудник с максимальной ЗП в отделе №5: " + employeeBook.findMaxSalaryByDepartment(5));
        System.out.println("Сумма затрат на отдел №3 = " + employeeBook.calculateTotalByDepartment(3));
        System.out.println("Средняя ЗП в отделе №2 = " + employeeBook.calculateAverageByDepartment(2));
        employeeBook.indexSalaryByDepartment(5, 5);
        employeeBook.printAllEmployees();
        employeeBook.printEmployeesByDepartment(5);
        System.out.println("Сотрудники с зарплатой меньше 140000:");
        employeeBook.printEmployeesWithSalaryLessThan(140000);
        System.out.println("Сотрудники с зарплатой больше 140000:");
        employeeBook.printEmployeesWithSalaryMoreOreEqualThan(140000);
        employeeBook.deleteEmployee(8);
        employeeBook.printAllEmployees();
        System.out.println("Сотрудник с указанным ID: " + employeeBook.getEmployeeById(10));
    }
}