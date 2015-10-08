
package exception;

/**
 *
 * @author Rihards
 */
public class PersonNotFoundException extends Exception{
    
    public PersonNotFoundException (String message){
        super(message);
    }
    public PersonNotFoundException(){
        super("Person with requested id is not found");
    }
}
