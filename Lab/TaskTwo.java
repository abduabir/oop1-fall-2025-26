public class TaskTwo {
    public static void main(String[] args) {
        //1:
        String firstname = "Abdullah";
        String lastname = "Abir";
        String fullName = firstname + " " + lastname;
        System.out.println("Full Name: " + fullName);

        //2:
        String productName = "Pen";
        String productID = "45";
        String productCode = productName + productID;
        System.out.println("Product Code: "+ productCode );

        //3:
        String eMail= "abir43315@gmail.com";
        String username = eMail.substring(0, 4);
        System.out.println("User Name: " + username);
        

        //4:
        String str1 = "No Nothing";
        System.out.println("User Message: "+ str1);
        System.out.println("Message Lenght: "+ str1.length());

        //5:
        String userEntered = "I'm abdullah Abir";
        System.out.println("User entered: "+ userEntered);
        String uppercaseConv = userEntered.toUpperCase();
        String lowercaseConv = userEntered.toLowerCase();
        System.out.println("converted to Uppercase: "+ uppercaseConv);
        System.out.println("converted to Lowercase: "+ lowercaseConv);

        //6:

    }
}