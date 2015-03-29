/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.exceptions;

/**
 *
 * @author Cheryl Allred
 */
public class GameException extends Exception {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
    public GameException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public GameException(Throwable cause) {
        super(cause);
    } 
}
