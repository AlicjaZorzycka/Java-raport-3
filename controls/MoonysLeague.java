
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.io.IOException;
import javax.swing.JOptionPane;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;

/**
 * Main class, which control start of the program.
 * 
 * @author Alicja Zorzycka
 * @since MLv1.0
 * @version 3.0
 */

public class MoonysLeague {

    /**
     * Main method check start arguments, creates the necessary classes 
     * and run the program.
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
        Club club = new Club();
        FileOperation fileOperation = new FileOperation();
        Controller controller = new Controller();
        String filePath = null;
                
        if (args.length == 1){
            filePath = args[0];
            club = fileOperation.readFile(filePath);
            controller.run(club);
        }
        else{
            JOptionPane.showMessageDialog(null, "No arguments on start!");
            System.exit(0);
        }
              
    }

}
