class Finance {

    private int salary;   // encapsulated variable

    // Setter
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Getter
    public int getSalary() {
        return salary;
    }
}

class CEO extends Finance {

    void approveSalary(int amount) {
        setSalary(amount);
        System.out.println("CEO approved salary: " + amount);
    }
}

class Employee extends Finance {

    String name;

    Employee(String name) {
        this.name = name;
    }

    void showSalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary received: " + getSalary());
    }
}

public class encapsulation {

    public static void main(String[] args) {

        CEO ceo = new CEO();
        Employee emp = new Employee("Umar");

        ceo.approveSalary(50000);

        emp.setSalary(ceo.getSalary());

        emp.showSalary();
    }
}