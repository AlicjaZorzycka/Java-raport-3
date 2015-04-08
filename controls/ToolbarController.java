
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;

/**
 * The <code> ToolbarController </code> class is controller for toolbar.
 * 
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */

public class ToolbarController {
    /** Club with all information about it. */
    private Club club;
    /** Main window of the program. */
    private MainWindow window;
    /** Main controller of the program. */
    private Controller controll;
    
    /**
     * Constructor of ToolbarController class.
     * 
     * @param club Club
     * @param window MainWindow
     * @param controll Controller
     */
    public ToolbarController(Club club, MainWindow window, Controller controll) {
        this.club = club;
        this.window = window;
        this.controll = controll;
    }
    
    
    /**
     * Method waits for seletions of addPlayerButton from playerToolbar.
     * 
     * @return addPlayer button listener
     */
    public ActionListener addPlayerSelected() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controll.addPlayerWindow();

            }
        };
    }
    
    /**
     * Method waits for seletions of deletePlayerButton from playerToolbar.
     * 
     * @return addPlayerButton listener
     */
    public ActionListener deletePlayerSelected() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controll.deletePlayerWindow();
            }
        };
    }
    
    /**
     * Method waits for seletions of exitButton from playerToolbar.
     * 
     * @return exitButton listener
     */
    public ActionListener exitSelected() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }
}
