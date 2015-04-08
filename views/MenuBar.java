
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views;

import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;   
import javax.swing.KeyStroke;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls.MenuBarController;

/**
 * The <code> MenuBar </code> class is menu bar for the program and
 * contains items for menu.
 *
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
    /** Menu - File. */
    private JMenu fileMenu;
    /** Menu - Edit. */
    private JMenu editMenu;
    /** Item - Open - for opening files. */
    private JMenuItem openFileMenuItem;
    /** Item - Save - for saving files. */
    private JMenuItem saveFileMenuItem;
    /** Item - exit - for close the program. */
    private JMenuItem exitFileMenuItem;
    /** Item - Add Player - for adding new player to team. */
    private JMenuItem addPlayerMenuItem;
    /** Item - Delete Player - for deleted player from team. */
    private JMenuItem deletePlayerMenuItem;
    
    /**
     * Constructor of MenuBar class start inicjalization process.
     */
    public MenuBar (){
        initFileMenu();
        initEditMenu();
    }
    
    /**
     * Inicjalization File Menu.
     */
    private void initFileMenu () {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        
        openFileMenuItem = new JMenuItem("Open", 'O');
        openFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.add(openFileMenuItem);
        
        saveFileMenuItem = new JMenuItem("Save", 'S');
        saveFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileMenu.add(saveFileMenuItem);
        
        exitFileMenuItem = new JMenuItem("Exit", 'x');
        exitFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        fileMenu.add(exitFileMenuItem);

        add(fileMenu);
    }
    
    /**
     * Inicjalization Edit Menu.
     */
    private void initEditMenu(){
        
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        
        addPlayerMenuItem = new JMenuItem("Add player", 'A');
        addPlayerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        editMenu.add(addPlayerMenuItem);
                
        deletePlayerMenuItem = new JMenuItem("Delete player", 'D');
        deletePlayerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        editMenu.add(deletePlayerMenuItem);
                
        add(editMenu);
        
    }
 
    
    /**
     * Method adds listeners to part of menuItems
     * 
     * @param control MenuBarController
     */
    public void addListeners(MenuBarController control) {
        
        addPlayerMenuItem.addActionListener(control.addNewPlayer());
        deletePlayerMenuItem.addActionListener(control.deletePlayer());
        openFileMenuItem.addActionListener(control.fileOpenSelected());
        saveFileMenuItem.addActionListener(control.fileSaveSelect());
        exitFileMenuItem.addActionListener(control.fileExitSelected());
    }
    
    
}
