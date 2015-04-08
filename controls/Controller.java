
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.EventQueue;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.AddPlayerWindow;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.DeletePlayerWindow;

/**
 * Main Controller responsible for GUI and everything what happend in the program.
 *
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */

public class Controller {

    /** Toolbar controller. */
    ToolbarController toolbarControl;
    /** Menu Bar controller. */
    MenuBarController menuBarControl;
    /** Main window. */
    public MainWindow mainWindow;
    /** Club with all information about it. */
    public Club club;
    /** Window to add player. */
    private AddPlayerWindow windowAddPlayer;
    /** Window to delete player. */
    private DeletePlayerWindow windowDeletePlayer;    
    /** Files operation - load and save. */
    public FileOperation fileOperation;
    
    /**
     * Constuctor of Controller class.
     */
    public Controller (){
        this.club = new Club();
        this.fileOperation = new FileOperation();
        this.menuBarControl = new MenuBarController(this, mainWindow, club);  
    }
    
    /**
     * Main function whos responsibility for GUI.
     * 
     * @param club2 club 
     */
    public void run(Club club2){
        this.club = club2; 
        this.toolbarControl = new ToolbarController(club, mainWindow, this);
        this.mainWindow = new MainWindow(club);
        addListeners();
        EventQueue.invokeLater(() -> {
            mainWindow.setVisible(true);
        });
        
    }
    
    /**
     * Method adds listeners.
     */
    public void addListeners() {
        mainWindow.toolbar.addListeners(toolbarControl);
        mainWindow.menuBar.addListeners(menuBarControl);
    }
    
    /**
     * Method open window to add player.
     */
    public void addPlayerWindow() {
        this.windowAddPlayer = new AddPlayerWindow(this, mainWindow,club);       
    }
    
    /**
     * Method open window to delete player.
     */
    public void deletePlayerWindow(){
        this.windowDeletePlayer = new DeletePlayerWindow(this, mainWindow, club);
    }

}
