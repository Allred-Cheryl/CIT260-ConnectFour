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
public class BoardException extends Exception {

    /**
     * Creates a new instance of <code>BoardException</code> without detail
     * message.
     */
    public BoardException() {
    }

    /**
     * Constructs an instance of <code>BoardException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BoardException(String msg) {
        super(msg);
    }
    public BoardException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BoardException(Throwable cause) {
        super(cause);
    } 
}
