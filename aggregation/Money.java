public class Money {
    private long dollars;
    private long cents;

    // constructor which is passed amount xxxx.xxxx
    public Money(double amount) {
        this.dollars = (long) amount;
        this.cents = Math.round((amount - this.dollars) * 100);
        // if cents is 100, then increment dollars by 1 and set cents to 0
        if (this.cents == 100) {
            this.dollars++;
            this.cents = 0;
        }
    }

    // copy constructor from another Money object
    public Money(Money otherObject) {
        this.dollars = otherObject.dollars;
        this.cents = otherObject.cents;
    }

    // I also added a constructor that takes two longs - dollars and cents
    // This avoids the need of conversion double<->long
    public Money(long dollars, long cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    // add money from other Money object
    // return a new Money object
    // do not modify the current object
    public Money add(Money otherAmount) {
        long new_dollars = this.dollars + otherAmount.dollars;
        long new_cents = this.cents + otherAmount.cents;
        if (new_cents >= 100) {
            new_dollars++;
            new_cents -= 100;
        }
        return new Money(new_dollars, new_cents);
    }

    // subtract one Money object from another
    // return a new Money object
    // cafeful with the sign of the result
    // no error checking for negative amounts!
    public Money subtract(Money otherAmount) {
        long new_dollars = this.dollars - otherAmount.dollars;
        long new_cents = this.cents + otherAmount.cents;
        if (new_cents < 0) {
            new_dollars--;
            new_cents += 100;
        }
        return new Money(new_dollars, new_cents);
    }

    // compare two Money objects, many ways to do this
    //
    // many ways to do this, I chose to return -1, 0, 1
    // in the assignment we weren't given any specific requirements
    //
    // return -1 if this object is less than other
    // returns 0 if this object is equal to other
    // returns 1 if this object is greater than other
    public int compareTo(Money otherObject) {
        if (this.dollars < otherObject.dollars) {
            // more dollars in other object
            return -1; 
        } else if (this.dollars > otherObject.dollars) {
            // more dollars in this object
            return 1; 
        }
        // dollars are equal, so we compare cents
        if (this.cents < otherObject.cents) {
            // more cents in other object
            return -1; 
        } else if (this.cents > otherObject.cents) {
            // more cents in this object
            return 1; 
        }
        // dollars and cents are equal
        return 0;
    }

    // check if two Money objects are equal
    // return true if they are equal, false otherwise
    public boolean equals(Money otherObject) {
        return  ((this.dollars == otherObject.dollars) 
                && (this.cents == otherObject.cents));
    }

    // toString() method
    public String toString() {
        return String.format("$%d.%02d", this.dollars, this.cents);
    }
}