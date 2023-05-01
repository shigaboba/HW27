public class Main {

    public static void main(String[] args) {
        double index = 10;
        int departmentNumber = 1;
        double salaryLevel = 5;
        EmployeeBook bookPuk = new EmployeeBook();
        bookPuk.printEmployeeBook();
       System.out.println("Сумма затрат на зарплаты в месяц: " + bookPuk.calculateSum());
        bookPuk.findLoser();
        bookPuk.findMaxSalary();
        bookPuk.findAverageSalary();
        bookPuk.printNames();
        bookPuk.indexSalaries(index);
        bookPuk.findLoserOfDepartment(departmentNumber);
        bookPuk.findMaxSalaryInDeparment(departmentNumber);
        System.out.println("В отделе " + departmentNumber + " сумма затрат на зарплаты в месяц: " + bookPuk.calculateSumForDepartment(departmentNumber));
        bookPuk.findAverageSalaryInDepartment(departmentNumber);
        bookPuk.indexSalariesInDepartment(index, departmentNumber);
        bookPuk.printDepartmentBook(departmentNumber);
        bookPuk.findSalaryLessNumber(salaryLevel);
        bookPuk.findSalaryMoreNumber(salaryLevel);
        bookPuk.changeEmployeeDepartment("Flura Kildiyarova", 1);
        bookPuk.changeEmployeeSalary("Nazifa Kadyrova", 20);
        bookPuk.printNamesWithDepartments();
        bookPuk.addEmployee("Nazifa Kadyrova", 1, 100000);
        bookPuk.addEmployee("Nazifa Kadyrova", 1, 100000);
        bookPuk.removeEmployee("Salavat Yulaev");
        bookPuk.printEmployeeBook();
    }
}
