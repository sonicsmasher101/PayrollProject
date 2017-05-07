import java.util.Scanner;

public class Tester{
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    Employee employee = new Employee("Rishi Menon", 1086);
    employee.clockIn();
    System.out.println("Press enter when you want to clock out employee!");
    in.next();
    employee.clockOut();
    System.out.println("Employee wages: " employee.getPay());
  }
}
