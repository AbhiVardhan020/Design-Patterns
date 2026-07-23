
// Creator
abstract class PaymentCreator{
    // Factory method
    abstract Payment createPayment();

    void processPayment(){
        Payment payment = createPayment();
        System.out.println("----------------------------");
        payment.initiatePayment();
        payment.authenticate();
        boolean success = payment.pay();
        if(success){
            System.out.println("Payment successful");
            payment.generateReceipt();
        }else{
            System.out.println("Payment failed, Please retry");
        }
        System.out.println("----------------------------\n\n\n");
    }
}

// Concrete creator
class UPIPaymentCreator extends PaymentCreator{
    @Override
    public Payment createPayment(){
        return new UPIPayment();
    }
}

// Concrete creator
class DebitCardPaymentCreator extends PaymentCreator{
    @Override
    public Payment createPayment(){
        return new DebitCardPayment();
    }
}

// Concrete creator
class CreditCardPaymentCreator extends PaymentCreator{
    @Override
    public Payment createPayment(){
        return new CreditCardPayment();
    }
}



// Product
abstract class Payment{
    protected abstract void initiatePayment();

    protected void authenticate(){
        System.out.println("Authenticating the user");
    }

    protected abstract boolean pay();

    protected void generateReceipt(){
        System.out.println("Generating payment receipt");
    }
}



// Concrete product
class UPIPayment extends Payment{
    @Override
    protected void initiatePayment(){
        System.out.println("Initiating payment via UPI");
    }
    @Override
    protected boolean pay(){
        System.out.println("Paying via UPI");
        return true;
    }
    
}

// Concrete product
class DebitCardPayment extends Payment{
    @Override
    protected void initiatePayment(){
        System.out.println("Initiating payment via Debit card");
    }
    @Override
    protected boolean pay(){
        System.out.println("Paying via debit card");
        return true;
    }
}

// Concrete product
class CreditCardPayment extends Payment{
    @Override
    protected void initiatePayment(){
        System.out.println("Initiating payment via Credit card");
    }
    @Override
    protected boolean pay(){
        System.out.println("Paying via credit card");
        return false;
    }
}

// Driver class
public class FactoryPatternDemo {

    public static void main(String[] args) {
        
        PaymentCreator pay1 = new UPIPaymentCreator();

        pay1.processPayment();

        
        PaymentCreator pay2 = new DebitCardPaymentCreator();
        
        pay2.processPayment();

        
        PaymentCreator pay3 = new CreditCardPaymentCreator();

        pay3.processPayment();

    }
}
