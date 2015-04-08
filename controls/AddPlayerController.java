
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerExistsException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Player;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.AddPlayerWindow;

/**
 * The <code> AddPlayerController </code> class is controller for adding player.
 *
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */
public class AddPlayerController {
    /** Main controlller of the program. */
    private Controller controller;
    /** Main Window of the program. */
    private MainWindow window;
    /** Club with information about players. */
    private Club club;
    /** Window to add player. */
    private AddPlayerWindow windowAdd;
    
    /**
     * Constructor of AddPlayerController.
     * 
     * @param control
     * @param window
     * @param windowAdd
     * @param club 
     */
    public AddPlayerController (Controller control, MainWindow window, AddPlayerWindow windowAdd,Club club){
        this.club = club;
        this.controller = control;
        this.window = window;
        this.windowAdd = windowAdd;
    }
    
    /**
     * Method waits for seletions of button - Add Player - from AddPlayerWindow.
     * 
     * @return listener
     */
    public ActionListener addNewPlayer() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if ( !isString(windowAdd.nameField.getText()) ){
                    if ( !isString(windowAdd.surrnameField.getText()) ){
                        if ( isInteger(windowAdd.numberField.getText()) ){
                            Player player = new Player();
                            player = club.createPlayer(windowAdd.nameField.getText(), windowAdd.surrnameField.getText(), 
                                        Integer.parseInt(windowAdd.numberField.getText()) );
                            try {
                                club.addToTeam(player);
                            } catch (PlayerExistsException ex) {
                                
                            }
                            JOptionPane.showMessageDialog(windowAdd,"Player added!");
                            windowAdd.dispatchEvent(new WindowEvent(windowAdd, WindowEvent.WINDOW_CLOSING));
                            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                            controller.run(club);
                        }
                        else{
                            JOptionPane.showMessageDialog(windowAdd,"Field Number has wrong data!");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(windowAdd,"Field Surname has wrong data!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(windowAdd,"Field Name has wrong data!");
                }

            };

      };
    }
    
    
    /**
    * The <code> isString </code> method are responsible for checking if str
    * value are string.
    * 
    * @param str String to check
    * @return true if value in str are non numeric.
    */
   public static boolean isString(String str) {
        try {
            @SuppressWarnings("unused")
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
   }
    
    /**
    * The <code> isInteger </code> method are responsible for checking if value
    * are numeric.
    * 
    * @param str String to check
    * @return true if value in str are String
    */
   public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
   }
    
}
