
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;

/**
 * The <code> MenuBarController </code> class is controller for MenuBar.
 * 
 * @author Alicja Zorzycka 
 * @since MLv3.0
 * @version 1.0 
 *
 */
public class MenuBarController {
    /** Main controller of the program. */
    private Controller controller;
    /** Main Window of the program. */
    private MainWindow window;
    /** Club with all information about it. */
    private Club club;
        
    /**
     * Constructor of ManuBarController.
     *
     * @param controller2 Main Controller
     * @param mainWindow Main Window
     * @param club2 Club
     */
    public MenuBarController(Controller controller2, MainWindow mainWindow, Club club2){
        this.controller = controller2;
        this.window = mainWindow;
        this.club = club2;
    }
    
    /**
     * Method waits for seletions of add player from menu bar.
     * 
     * @return new player menuItem listener
     */
    public ActionListener addNewPlayer() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addPlayerWindow();
            }
        };
    }
    /**
     * Method waits for seletions of delete player from menu bar.
     * 
     * @return delete player menuItem listener
     */
    public ActionListener deletePlayer() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deletePlayerWindow();
            }
        };
    }
    
    /**
     * Method waits for seletions of Exit menuItem from menu bar.
     * 
     * @return exit menuItem listener
     */
    public ActionListener fileExitSelected() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }
    
    /**
     * Method waits for seletions of Open menuItem from menu bar.
     * 
     * @return open file menuItem listener
     */
    public ActionListener fileOpenSelected() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                club = controller.fileOperation.openFileDialog(window);
                controller.run(club);
                window = controller.mainWindow;
            }
        };
    }
    
    /**
     * Method waits for seletions of Save menuItem from menu bar.
     * 
     * @return save file menuItem listener
     */
    public ActionListener fileSaveSelect() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.fileOperation.saveFileDialog(window, controller.club);
            }
        };
    }
}
