
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerExistsException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Player;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.ClubViewer;

/**
 * The <code>FileOperation</code> class contains operations on text file.
 * 
 * @author Alicja Zorzycka 
 * @since MLv3.0
 * @version 1.0
 */

public class FileOperation {
    /** Club with all information of it. */
    Club club = new Club();
    /** File type variable */
    private File file;
     
    /**
     * Reading file and creating club with player's list from information in file.
     * 
     * @param filePath path to file
     * @return club new Club information
     * @throws java.io.IOException no file found
     */
    public Club readFile(String filePath) throws IOException {
        String dataFromFile;
        String[] separatedText;
        int counter = 0;
        file = new File(filePath);

        Scanner read = new Scanner(file);
        while (read.hasNextLine()) {
            if (counter < 5){
                if (counter == 0){
                    club.setName(read.nextLine());
                    counter = counter + 1;
                }
                if (counter == 1){
                    club.setStadion(read.nextLine());
                    counter = counter + 1; 
                }
                if (counter == 2){
                    club.setEstablished(read.nextInt());
                    counter = counter + 1; 
                }
                if (counter == 3){
                    read.nextLine();
                    club.setPresident(read.nextLine());
                    counter = counter + 1; 
                }
                if (counter == 4){
                    club.setCoach(read.nextLine());
                    counter = counter + 1; 
                }  
            }
            else{
                Player player = new Player();
                String firstName;
                String name;
                String numberString;
                int number; 
                
                dataFromFile = read.nextLine();
                separatedText = dataFromFile.split(" ");
                firstName = separatedText[0];
                name = separatedText[1];
                numberString = separatedText[2];
                number = Integer.parseInt(numberString);
                player = club.createPlayer(firstName, name, number);
                
                try {
                    club.addToTeam(player);
                } catch (PlayerExistsException ex) {
                    ClubViewer addViewer = new ClubViewer();
                    addViewer.playerExistMessage(ex.getMessage());
                } 
            }            
        }
        read.close();
        return club;
    }
    
    
    /**
     * The <code> openFileDialog </code> class which are responsible for open a
     * file find window and start a <code> readFile </code> method.
     * 
     * @param window main window
     * @return Club
     */
    public Club openFileDialog(MainWindow window) {
        
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(window);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try{
                if (!file.canRead()) {
                    throw new IOException();
                } else {
                    club.getList().clear();
                    club = readFile(file.getPath());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(window, "Error while processing file", "IO error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return club;
    }
    
    /**
    * The <code> saveFileDialog </code> method are responsible for open new
    * window in which user can find file to save player list.
    * 
    * @param window main window
    * @param club2 actual information about club
    */
    public void saveFileDialog(MainWindow window, Club club2) {

        System.out.println(club.getNumberOfPlayers());
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(window);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                if (!file.canWrite()) {
                    throw new IOException();
                } else {
                    saveFile(file.getPath(), club2);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(window, "Error while processing file", "IO error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    /**
     * The <code> saveFile </code> are responsible for saving player list to
     * file.
     * 
     * @param filePath path of file
     * @param club3
     * @throws IOException no file found
     */
    public void saveFile(String filePath, Club club3) throws IOException {

        this.club = club3;
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Integer temp = 0;
        
        bufferedWriter.write(club.getName() + "\n");
        bufferedWriter.write(club.getStadion() + "\n");
        bufferedWriter.write(club.getEstablished() + "\n");
        bufferedWriter.write(club.getPresident() + "\n");
        bufferedWriter.write(club.getCoach() + "\n");
        
        List<Player> team = new LinkedList<Player>();
        team = club.getList();
        
        while (temp < club.getNumberOfPlayers() ) {
            bufferedWriter.write(team.get(temp).getFirstName() + " ");
            bufferedWriter.write(team.get(temp).getSurname()+ " ");
            if (temp == (club.getNumberOfPlayers()-1) ){
                bufferedWriter.write(team.get(temp).getPlayerNumber() + "");
            }
            else{
                bufferedWriter.write(team.get(temp).getPlayerNumber() + "\n");
            }
            temp++;
        }

        bufferedWriter.close();
    }
    
}
