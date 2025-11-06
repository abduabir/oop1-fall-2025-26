
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args)
    {
      Scanner scanner = new Scanner(System.in);

      System.out.println("=== Bangladesh Mortgage Calculator(BDT)===");
      
      System.out.print("Enter your Salary: ");
      if(!scanner.hasNextDouble()){
        System.out.print("Not Valid!! Salary amount must be a Number.");
      }
        else
        {
          double salary = scanner.nextDouble();

      System.out.print("Enter your Cradit score(0-500): ");
      if(!scanner.hasNextInt()){
        System.out.print("Not valid!! Cradit Score must be in between (0-500)");
      }
      else {
        int craditScore = scanner.nextInt();
      
      System.out.print("Do you have any Criminal Records?(true/false): ");
      if (!scanner.hasNextBoolean()) {
        System.out.print("Not valid!! Criminal record must be true or false. ");
      }
      else {
        boolean criminalRecords = scanner.nextBoolean();

        if(craditScore<300 && criminalRecords==true){
          System.out.print("Sorry You're not eligible to get loan. \n *Poor Cradit Score and Criminal records found.* ");
        }
        else if(craditScore<300){
          System.out.print("Sorry You're not eligible to get loan. \n *Poor Cradit Score*");
        }
        else if(criminalRecords==true){
         System.out.print("Sorry You're not eligible to get loan. \n *Criminal records found.* "); 
        }
        else {
          System.out.println("\nCongratiolations!! You're Eligible to get loan.");

      System.out.print("\n Enter Loan amount: ");
      if (!scanner.hasNextDouble()){
        System.out.print("Invalid!! Loan ammount must be a Number. ");
      }
      else{
      double PrincipalAmmount = scanner.nextDouble();
      if(salary*2<PrincipalAmmount){
        System.out.print("Sorry, You're not eligible to get loan.\n *Loan ammount must be under 2 times the Salary ammount.* ");
      }
      else{
      
      System.out.print("Enter Annual Interest rate in (%): ");
      if (!scanner.hasNextDouble()) {
        System.out.println("Not valid! Interest rate must be a number.");
      } 
      else {
      double interest = scanner.nextDouble();
      
      System.out.print("Enter Loan period in years: ");
      if (!scanner.hasNextInt()) {
        System.out.println("Not valid! Years must be a number.");
      } 
      else {
      int years = scanner.nextInt();

      double monthlyRate = interest/100/12;
      int numberOfPayments = years*12;
      double monthlyPayment = PrincipalAmmount
                              *(monthlyRate*Math.pow(1+monthlyRate,numberOfPayments)) 
                              / (Math.pow(1+monthlyRate,numberOfPayments)-1); 
      double totalPayment =  monthlyPayment * numberOfPayments;
      double totalInterest = totalPayment - PrincipalAmmount;

      Locale bdLocale = Locale.of("en", "BD");
      NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(bdLocale);


       System.out.println("\n=== Mortgage Summary ===");
        System.out.println("Loan Amount: " + currencyFormatter.format(PrincipalAmmount));
        System.out.println("Monthly Payment: " + currencyFormatter.format(monthlyPayment));
        System.out.println("Total Payment: " + currencyFormatter.format(totalPayment));
        System.out.println("Total Interest: " + currencyFormatter.format(totalInterest));

}
}
}
}
}
}
}
}
        scanner.close();
   }
}
