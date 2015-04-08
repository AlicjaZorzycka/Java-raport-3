
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions;

/**
 * The class {@code CategoryException} is a form of
 * {@code Throwable} that indicates unexpected situation while adding player.
 * 
 * @author Alicja Zorzycka
 * @since LMv2.0
 * @version 1.0
 */
@Deprecated
public class PlayerExistsException extends Exception {
    
    /**
     * Constructs a new exception with {@code null} as its detail message.
     */
    public PlayerExistsException(){
        
    }
    
    /**
     * Constructs a new exception with the specified detail message.
     * @param information First name and surname of the player.
     */
    public PlayerExistsException (String information){
        super(information);
    }
}
