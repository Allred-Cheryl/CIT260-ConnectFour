/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.controls;
import byui.cit260.connectfour.interfaces.DisplayInfo;
/**
 *
 * @author Luis
 */
public class ConnectFourError implements DisplayInfo {
    
 
    
    public Object displayError(Object object){
        String message = (String) object;
        System.out.println("\t???????????????????????????????????????????????");
        System.out.println("\t Error:" + message);
        System.out.println("\t???????????????????????????????????????????????");
    return null;
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void display(String startGame__please_enter_a_valid_number_of) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
