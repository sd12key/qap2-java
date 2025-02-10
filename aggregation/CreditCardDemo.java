public class CreditCardDemo {
    public static void main(String[] args) {
        final Money LIMIT = new Money(1000);
        final Money FIRST_AMOUNT = new Money(200);
        final Money SECOND_AMOUNT = new Money(10.02);
        final Money THIRD_AMOUNT = new Money(25);
        final Money FOURTH_AMOUNT = new Money(990);

        Person owner = new Person (
            "Diane", "Christie", 
            new Address("237J Harvey Hall", "Menomonie", "WI", "54751")
        );

        CreditCard visa = new CreditCard(owner, LIMIT);

        System.out.println();
        System.out.println(visa.getPersonals());
        System.out.println();
        System.out.println("---> Balance:\t\t" + visa.getBalance());
        System.out.println("---> Credit Limit:\t" + visa.getCreditLimit());
        System.out.println();
        System.out.println("Attempt to charge:\t" + FIRST_AMOUNT);
        System.out.print("---> ");
        visa.charge(FIRST_AMOUNT);
        System.out.println("New balance:\t\t" + visa.getBalance());
        System.out.println();
        System.out.println("Attempt to charge:\t" + SECOND_AMOUNT);
        System.out.print("---> ");        
        visa.charge(SECOND_AMOUNT);
        System.out.println("New Balance:\t\t" + visa.getBalance());
        System.out.println();
        System.out.println("Attempt to pay:\t\t" + THIRD_AMOUNT);
        System.out.print("---> ");
        visa.payment(THIRD_AMOUNT);
        System.out.println("New balance:\t\t" + visa.getBalance());
        System.out.println();
        System.out.println("Attempt to charge:\t" + FOURTH_AMOUNT);
        System.out.print("---> ");
        visa.charge(FOURTH_AMOUNT);
        System.out.println("New balance:\t\t" + visa.getBalance());
        System.out.println();
    }
}