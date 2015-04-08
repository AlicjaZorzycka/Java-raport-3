
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;


/**
 * The <code> PlayersTable </code> class coontains player list and show them
 * as a table in GUI.
 * 
 * @author Alicja Zorzycka
 * @since MLv3.0
 * @version 3.0
 * 
 */
public class PlayersTable extends JPanel {

    /**
     * Constructor of PlayersTable class.
     * 
     * @param club club
     */
    public PlayersTable(Club club) {
        super(new GridLayout(1,0));
        
        String[] columnNames = {
            "Lp", "First Name", "Last Name", "Number"
        };
        
          
        List<Player> base = new LinkedList<Player>();
        base = club.getList();
        int sizeRow = base.size();
        int sizeColumn = columnNames.length;
        Object[][] data = new Object[sizeRow][sizeColumn];
        int record = 0;
      
        for (Player player : base) {
            data[record][0] = record + 1;
            data[record][1] = player.getFirstName();
            data[record][2] = player.getSurname();
            data[record][3] = player.getPlayerNumber();
            record++;
        }
        
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    
}
