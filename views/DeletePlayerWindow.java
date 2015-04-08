
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls.Controller;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls.DeletePlayerController;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls.MainWindow;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;

/**
 * The <code> DeletePlayerWindow </code> class is responsible for starting 
 * new frame to delete player.
 * 
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 1.0
 */
public class DeletePlayerWindow extends JFrame {
    /** Main container. */
    private JPanel contentPane;
    /** Field for first name. */
    public JTextField nameField;
    /** Field for surname. */
    public JTextField surrnameField;
    /** Controller of DeletePlayerWindow. */
    public DeletePlayerController delPlayerController;

    /**
     * Constructor of DeletePlayerWindow.
     * 
     * @param control main controller
     * @param mainWindow main window
     * @param club club
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DeletePlayerWindow(Controller control, MainWindow mainWindow, Club club) { 
        delPlayerController = new DeletePlayerController(control, mainWindow, this, club);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 260, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 232, 151);
        contentPane.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Delete Player", null, panel, null);
        panel.setLayout(null);

        JLabel lblName = new JLabel("First Name");
        lblName.setBounds(10, 11, 67, 14);
        panel.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(87, 8, 86, 20);
        panel.add(nameField);
        nameField.setColumns(10);

        JLabel lblSurrname = new JLabel("Surrname");
        lblSurrname.setBounds(10, 36, 67, 14);
        panel.add(lblSurrname);

        surrnameField = new JTextField();
        surrnameField.setBounds(87, 33, 86, 20);
        panel.add(surrnameField);
        surrnameField.setColumns(10);

        JButton btnDeletePlayer = new JButton("Delete Player");
        btnDeletePlayer.addActionListener(delPlayerController.deleteNewPlayer());
        btnDeletePlayer.setBounds(45, 90, 117, 23);
        panel.add(btnDeletePlayer);

        setVisible(true);
    }
    
}
