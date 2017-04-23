package hotel;

/**
 *
 * @author Chandler Davidson
 */
public class Payment {
    
    /**
     * Class constructor
     */
    public Payment()
    {
        // This block was intentionally left blank.
    }
    
    /**
     * Returns whether or not the credit card number is valid (valid if has 16 digits)
     * @param creditCard
     * @return true/false
     */
    public static boolean checkPayment(String creditCard){
        return (creditCard.length() == 16);
    }
}