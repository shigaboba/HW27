import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private Map<String, Employee> employees;

    public EmployeeBook() {
        this.employees = new HashMap<>();
        employees.put("Fidan Gafarov", new Employee("Fidan Gafarov", 1, 4));
        employees.put("Guzel Urazova", new Employee("Guzel Urazova", 2, 4));
        employees.put("Magafur Gizatullin", new Employee("Magafur Gizatullin", 3, 6));
        employees.put("Salavat Yulaev", new Employee("Salavat Yulaev", 4, 7));
        employees.put("Flura Kildiyarova", new Employee("Flura Kildiyarova", 5, 69));
        employees.put("Aydar Galimov", new Employee("Aydar Galimov", 1, 9));
        employees.put("Salavat Fathetdinov", new Employee("Salavat Fathetdinov", 2, 99));
        employees.put("Flura Suleimanova", new Employee("Flura Suleimanova", 3, 55));
        employees.put("Hania Farhi", new Employee("Hania Farhi", 4, 64));
        employees.put("Vasilya Fattahova", new Employee("Vasilya Fattahova", 5, 45));
    }


    public void printEmployeeBook() {
        for (Map.Entry<String, Employee> s1 : employees.entrySet()) {
            System.out.println(s1.getValue().toString());
        }
    }

    public double calculateSum() {
        double sum = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            sum += employee.getValue().getSalary();
        }
        return sum;
    }

    public void findLoser() {
        double minSalary = Double.MAX_VALUE;
        String key = " ";
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (minSalary > employee.getValue().getSalary()) {
                minSalary = employee.getValue().getSalary();
                key = employee.getKey();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees.get(key));
    }

    public void findMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = " ";
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (maxSalary < employee.getValue().getSalary()) {
                maxSalary = employee.getValue().getSalary();
                key = employee.getKey();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees.get(key));
    }

    public void findAverageSalary() {
        double AverageSalary = calculateSum() / employees.size();
        System.out.println("Средняя зарплата: " + AverageSalary);
    }

    public void printNames() {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            System.out.println(employee.getValue().getName());
        }
    }

    public void indexSalaries(double index) {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            employee.getValue().setSalary(employee.getValue().getSalary() * (1 + index / 100));
            System.out.println(employee.getValue().toString());
        }
    }

    public void findLoserOfDepartment(int departmentNumber) {
        double minSalary = Double.MAX_VALUE;
        String key = " ";
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber & minSalary > employee.getValue().getSalary()) {
                minSalary = employee.getValue().getSalary();
                key = employee.getKey();
            }
        }
        System.out.println("В отделе " + departmentNumber + " сотрудник с минимальной зарплатой: " + employees.get(key));
    }

    public void findMaxSalaryInDeparment(int departmentNumber) {
        double maxSalary = Double.MIN_VALUE;
        String key = " ";
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber & maxSalary < employee.getValue().getSalary()) {
                maxSalary = employee.getValue().getSalary();
                key = employee.getKey();
            }
        }
        System.out.println("В отделе " + departmentNumber + " сотрудник с максимальной зарплатой: " + employees.get(key));
    }

    public double calculateSumForDepartment(int departmentNumber) {
        double sum = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber) {
                sum += employee.getValue().getSalary();
            }
        }
        return sum;
    }

    public void findAverageSalaryInDepartment(int departmentNumber) {
        int peopleNumberInDepartment = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber) {
                peopleNumberInDepartment++;
            }
        }
        double averageSalary = calculateSumForDepartment(departmentNumber) / peopleNumberInDepartment;
        System.out.println("В отделе " + departmentNumber + " средняя зарплата: " + averageSalary);
    }

    public void indexSalariesInDepartment(double index, int departmentNumber) {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber) {
                employee.getValue().setSalary(employee.getValue().getSalary() * (1 + index / 100));
                System.out.println(employee.getValue().getSalary());
            }
        }
    }

    public void printDepartmentBook(int departmentNumber) {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == departmentNumber) {
                System.out.println(employee.getValue().toString());
            }
        }
    }

    public void findSalaryLessNumber(double salaryLevel) {
        System.out.println("Сотрудники с зарплатой меньше " + salaryLevel + ":");
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getSalary() < salaryLevel) {
                System.out.println(employee.getValue().toString());
            }
        }
    }

    public void findSalaryMoreNumber(double salaryLevel) {
        System.out.println("Сотрудники с зарплатой больше " + salaryLevel + ":");
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getSalary() > salaryLevel) {
                System.out.println(employee.getValue().toString());
            }
        }
    }

    public void addEmployee(String name, int department, int salary) {
        if (!employees.containsKey(name)) {
            employees.put(name, new Employee(name, department, salary));
        }
        else System.out.println("Этот сотрудник уже добавлен");
    }

    public void removeEmployee(String victimName) {
        employees.remove(victimName);
    }

    public void changeEmployeeDepartment(String Name, int department) {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getName().equals(Name)) {
                employee.getValue().setDepartment(department);
                return;
            }
        }
    }

    public void changeEmployeeSalary(String Name, int salary) {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getName().equals(Name)) {
                employee.getValue().setSalary(salary);
                return;
            }
        }
    }

    public void printNamesWithDepartments() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Сотрудники отдела " + i + ":");
            for (Map.Entry<String, Employee> employee : employees.entrySet()) {
                if (employee.getValue().getDepartment() == i) {
                    System.out.println(employee.getValue().getName());
                }
            }
        }
    }
}
