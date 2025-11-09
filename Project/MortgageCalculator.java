import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args)
    {
      Scanner scanner = new Scanner(System.in);

      System.out.println("=== Bangladesh Mortgage Calculator(BDT)===");
      
      double salary = 0.0;
      while (true) { 
          System.out.print("Enter your monthly salary(BDT): ");
          if(scanner.hasNextDouble()){
             salary= scanner.nextDouble();
             scanner.nextLine();
             if (salary>0){
              break;
             } else{
                System.out.println("***Salary must be gratter than zero.***");
              }
            } else {
              System.out.println("***Invalid input! Salary must be a number.***");
              scanner.nextLine();
            }
      }
    
    

     int creditScore = -1;
        while (true) { 
            System.out.print("Enter your Credit Score (0 - 500): ");
            if (scanner.hasNextInt()) {
              creditScore = scanner.nextInt();
              scanner.nextLine();
              if(creditScore>=0 && creditScore<=500){
                break;
              }
                else{
                  System.out.println("***Credit Score must be between 0 and 500.***");
                }
              
        } else{
          System.out.println("***Credit Score must be a numeric number.***");
          scanner.nextLine();
        }
        }
 boolean criminalRecord = false;
        while (true) {
            System.out.print("Do you have a criminal record? (true / false): ");
            if (scanner.hasNext()) {
                String token = scanner.next().toLowerCase().trim();
                scanner.nextLine();
            if (token.equals("true")) {
              criminalRecord = true;
              break;
            } else if (token.equals("false")) {
              criminalRecord = false;
              break;
                } else {
                System.out.println("***Criminal record must be 'true' or 'false'.***");
                }
            } else {
                System.out.println("***Criminal record must be 'true' or 'false'.***");
                scanner.nextLine();
            }
        }
        if (creditScore < 300 && criminalRecord) {
            System.out.println("\nNot eligible for loan: Credit score is below 300 and criminal record found.");
            scanner.close();
            return;
        } else if (creditScore < 300) {
            System.out.println("\nNot eligible for loan: Credit score must be at least 300.");
            scanner.close();
            return;
        } else if (criminalRecord) {
            System.out.println("\nNot eligible for loan: Applicant has a criminal record.");
            scanner.close();
            return;
        } else {
            System.out.println("\nYou meet basic eligibility requirements. Proceeding to loan details...");
        }
         double principal = 0.0;
        while (true) {
            System.out.print("Enter loan amount (Principal in BDT): ");
            if (scanner.hasNextDouble()) {
                principal = scanner.nextDouble();
                scanner.nextLine();
            if (principal > 0) {
            if (principal <= (salary * 2)) {
              break;
              } else {
                System.out.println("***Loan denied! Amount exceeds twice your salary. Enter a smaller principal***");
              }
              } else {
                System.out.println("***Principal must be greater than 0.***");
                }
            } else {
                System.out.println("***Invalid input! Principal must be a number.***");
                scanner.nextLine();
            }
        } 
        double annualInterestRate = 0.0;
        while (true) {
            System.out.print("Enter annual interest rate *avoid(%)*: ");
            if (scanner.hasNextDouble()) {
                annualInterestRate = scanner.nextDouble();
                scanner.nextLine();
                if (annualInterestRate > 0) {
                break;
                } else {
                    System.out.println("***Interest rate must be greater than 0.***");
                }
            } else {
                System.out.println("***Interest rate must be a number.***");
                scanner.nextLine();
            }
        }
        int years = 0;
        while (true) {
            System.out.print("Enter loan period (in years): ");
            if (scanner.hasNextInt()) {
                years = scanner.nextInt();
                scanner.nextLine();
                if (years > 0) {
                 break;
                } else {
                  System.out.println("***Loan period must be greater than 0.***");
                }
            } else {
                System.out.println("***Loan period must be a number.***");
                scanner.nextLine();
            }
        }
        double monthlyInterestRate = (annualInterestRate / 100.0) / 12.0;
        int numberOfPayments = years * 12;

        double mortgagePayment;
        if (monthlyInterestRate == 0) {
            mortgagePayment = principal / numberOfPayments;
        } else {
            mortgagePayment = principal
                    * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        }

        double totalPayment = mortgagePayment * numberOfPayments;
        double totalInterest = totalPayment - principal;

        Locale bdLocale = Locale.of("en", "BD");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(bdLocale);

        System.out.println("\n=== Mortgage Summary ===");
        System.out.println("Loan Amount: " + currencyFormatter.format(principal));
        System.out.println("Monthly Payment: " + currencyFormatter.format(mortgagePayment));
        System.out.println("Total Payment: " + currencyFormatter.format(totalPayment));
        System.out.println("Total Interest: " + currencyFormatter.format(totalInterest));

        scanner.close();
}
    }