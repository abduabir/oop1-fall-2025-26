
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args)
    {
      Scanner scanner = new Scanner(System.in);

      System.out.println("=== Bangladesh Mortgage Calculator(BDT)===");
      
      System.out.print("Enter Loan ammount: ");
      double PrincipalAmmount = scanner.nextDouble();
      
      System.out.print("Enter Annual Interest rate in (%): ");
      double interest = scanner.nextDouble();
      
      System.out.print("Enter Loan period in years: ");
      int years = scanner.nextInt();

      double monthlyRate = interest/100/12;
      int numberOfPayments = years*12;
      double monthlyPayment = PrincipalAmmount*(monthlyRate*Math.pow(1+monthlyRate,numberOfPayments)) / (Math.pow(1+monthlyRate,numberOfPayments)-1); 
      double totalPayment =  monthlyPayment * numberOfPayments;
      double totalInterest = totalPayment - PrincipalAmmount;

      System.out.println("===Mortgage Summury===");
      System.out.println("Loan ammount: "+ PrincipalAmmount);
      System.out.println("Monthly Payment: "+ monthlyPayment);
      System.out.println("Total Payment: "+ totalPayment);
      System.out.println("Total Interest: "+ totalInterest);

    }
}
