
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls.ToolbarController;

/**
 * The <code> Toolbar </code> class is toolbar for main window. 
 * 
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */

public class Toolbar extends JPanel {
    /** Toolbar */
    private JToolBar playerToolBar;
    /** Button in toolbaar for adding new player. */
    private JButton addPlayerButton;
    /** Button in toolbar for deleted new player. */
    private JButton deletePlayerButton;
    /** Button in toolbar for close the program. */
    private JButton exitButton;
    
    /**
     * Constructor of Toolbar class start inicjalization process.
     */
    public Toolbar() {
        super(new BorderLayout());
        initComponents();
    }
    
    /**
     * Inicjalization components of toolbar.
     */
    private void initComponents(){
        
        playerToolBar = new JToolBar("Add/Clear");
        playerToolBar.setRollover(true);
        playerToolBar.setFloatable(false);
        
        addPlayerButton = new JButton();
        deletePlayerButton = new JButton();
        exitButton = new JButton();
        
        addPlayerButton.setIcon(new ImageIcon("Images\\add2S.jpg"));
        addPlayerButton.setToolTipText("Add new player");
        addPlayerButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        addPlayerButton.setFocusable(false);
        addPlayerButton.setMaximumSize(new Dimension(35, 35));
        addPlayerButton.setPreferredSize(new Dimension(35, 35));
        playerToolBar.add(addPlayerButton);
        
        deletePlayerButton.setIcon(new ImageIcon("Images\\deleteS.png"));
        deletePlayerButton.setToolTipText("Delete player");
        deletePlayerButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        deletePlayerButton.setFocusable(false);
        deletePlayerButton.setMaximumSize(new Dimension(36, 35));
        deletePlayerButton.setPreferredSize(new Dimension(36, 35));
        playerToolBar.add(deletePlayerButton);
        
        exitButton.setIcon(new ImageIcon("Images\\exitS.png"));
        exitButton.setToolTipText("Close program");
        exitButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        exitButton.setFocusable(false);
        exitButton.setMaximumSize(new Dimension(35, 35));
        exitButton.setPreferredSize(new Dimension(35, 35));
        playerToolBar.add(exitButton);
        
        add(playerToolBar, BorderLayout.LINE_START);        
        
    }
    
    /**
     * Method adds listeners to toolbars buttons.
     * 
     * @param control ToolbarController
     */
    public void addListeners(ToolbarController control) {
        addPlayerButton.addActionListener(control.addPlayerSelected());
        deletePlayerButton.addActionListener(control.deletePlayerSelected());
        exitButton.addActionListener(control.exitSelected());
    }

}
