
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerNotExistException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Player;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.DeletePlayerWindow;

/**
 * The <code> DeletePlayerController </code> class is controller for delete player.
 * 
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */

public class DeletePlayerController {
    /** Main controller of the program. */
    private Controller controller;
    /** Main Window of the program. */
    private MainWindow window;
    /** Club with all information about players. */
    private Club club;
    /** Window to delete player. */
    private DeletePlayerWindow windowDel;
    
    /**
     * Constructor of DeletePlayerController class.
     * 
     * @param control main Controller
     * @param window main Window
     * @param windowDel DeletePlayerWindow
     * @param club club
     */
    public DeletePlayerController (Controller control, MainWindow window, DeletePlayerWindow windowDel,Club club){
        this.club = club;
        this.controller = control;
        this.window = window;
        this.windowDel = windowDel;
    }
    
    /**
     * Method waits for seletions of button - Delete Player - from DeletePlayerWindow.
     * 
     * @return listener
     */
    public ActionListener deleteNewPlayer() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if ( !isString(windowDel.nameField.getText()) ){
                    if ( !isString(windowDel.surrnameField.getText()) ){
                        Player player = new Player();
                        player = club.createPlayer(windowDel.nameField.getText(), windowDel.surrnameField.getText());
                        try {
                            club.deletePlayer(player);
                        } catch (PlayerNotExistException ex) {
                            // not possilbe
                        }

                        JOptionPane.showMessageDialog(windowDel,"Player deleted!");
                        windowDel.dispatchEvent(new WindowEvent(windowDel, WindowEvent.WINDOW_CLOSING));
                        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                        controller.run(club);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(windowDel,"Field Surname has wrong data!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(windowDel,"Field Name has wrong data!");
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
