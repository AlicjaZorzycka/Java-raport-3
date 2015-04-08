
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.PlayersTable;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.MenuBar;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.Toolbar;

/**
 * The <code> MainWindow</code> class is main controller handling main frame. It 
 * contains useful methods and fields to show whole window.
 *
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 * 
 */
public class MainWindow extends JFrame {
    /** Menu Bar for main window. */
    MenuBar menuBar;
    /** Panel split the window. */
    private JSplitPane centerPane;
    /** Toolbar for main window. */
    Toolbar toolbar;
    /** Club with information about it. */
    public Club club;
    
    /**
     * Creates new form of MainFrame
     * 
     * @param club2 club
     */
    public MainWindow (Club club2){
        club = club2;
        initComponents();
    }
    
    /**
     * Inicjalization components of window.
     */
    private void initComponents (){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Monny's League");
        setSize(new Dimension(800, 600));
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        toolbar = new Toolbar();
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        JTextArea output = new JTextArea(5, 30);
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(output, BorderLayout.CENTER);
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        JTextArea infoClub = new JTextArea();
        infoClub.setText("Club's name: " + club.getName() 
                        + "\nStadion: " + club.getStadion() 
                        + "\nEstablished: " + club.getEstablishedString() 
                        + "\nPresident: " + club.getPresident()
                        + "\nCoach: " + club.getCoach());
        infoClub.setEditable(false);
                
        PlayersTable newContentPane = new PlayersTable(club);
        newContentPane.setOpaque(true); 
        
        centerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, infoClub, newContentPane);
        getContentPane().add(centerPane, BorderLayout.CENTER);
        centerPane.setRightComponent(newContentPane);
        
        pack();
    }     
    
}
