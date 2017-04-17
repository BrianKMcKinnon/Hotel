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
        // initialize something
    }
    
    // Does payment need to do anything more?
    public static boolean checkPayment(String creditCard){
        return (creditCard.length() == 16);
    }
}