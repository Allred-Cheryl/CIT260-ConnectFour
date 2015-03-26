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
public class ConnectFourException extends Exception {

    /**
     * Creates a new instance of <code>ConnectFourException</code> without
     * detail message.
     */
    public ConnectFourException() {
    }

    /**
     * Constructs an instance of <code>ConnectFourException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConnectFourException(String msg) {
        super(msg);
    }
    
    public ConnectFourException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ConnectFourException(Throwable cause) {
        super(cause);
    }
}
