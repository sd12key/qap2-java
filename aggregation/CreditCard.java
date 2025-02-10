public class CreditCard {
    private Money balance;
    private Money creditLimit;
    private Person owner;

    // constructor
    public CreditCard(Person newCardHolder, Money limit) {
        // aggregation for cardholder, we pass the reference of the cardholder object
        // (since person (cardholder) object can exist without credit card object)
        this.owner = newCardHolder;
        // for credit limit and balance we create new Money objects (composition)
        this.creditLimit = new Money(limit); 
        this.balance = new Money(0.0); 
    }

    // get card balance, returning a new Money object
    // so that the actual balance on the card cannot be changed accidentally
    public Money getBalance() {
        return new Money(this.balance);
    }

    // get card credit limit, returning a new Money object
    public Money getCreditLimit() {
        return new Money(this.creditLimit);
    }

    // get the cardholder details (string format)
    public String getPersonals() {
        return this.owner.toString();
    }

    // charge the card with $$$ amount
    public void charge(Money amount) {
        // check for <=0 values, charge only makes sence if the amount is positive
        if (amount.compareTo(new Money(0, 0)) <= 0) {
            System.out.println("Invalid charge amount: must be positive value.");
            return;
        }

        // create new Money object with the new balance
        Money newBalance = balance.add(amount);

        // check if the new balance is less than or equal to the credit limit
        if (newBalance.compareTo(creditLimit) <= 0) {
            // set the new balance
            balance = newBalance;
            System.out.println("Charge: " + amount);
        } else {
            // if the new balance exceeds the credit limit
            System.out.println("Exceeds credit limit");
        }
    }

    // make a payment of $$$ amount to the card
    public void payment(Money amount) {
        // check for <=0 values, payment only makes sence if the amount is positive
        if (amount.compareTo(new Money(0, 0)) <= 0) {
            System.out.println("Invalid payment amount: must be positive value.");
            return;
        }

        balance = balance.subtract(amount);
        System.out.println("Payment: " + amount);
    }
}