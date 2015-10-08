
package exception;

/**
 *
 * @author Rihards
 */
public class CompanyNotFoundException extends Exception{
     public CompanyNotFoundException (String message){
        super(message);
    }
    public CompanyNotFoundException(){
        super("Company with requested cvr is not found");
    }
}
