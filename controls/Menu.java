
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.controls;

import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerExistsException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerNotExistException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Club;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models.Player;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.ClubViewer;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views.MenuViever;

/**
 * The <code>Menu</code> class manage the program.
 *
 * @author Alicja Zorzycka
 * @since LMv2.0
 * @version 2.0

 */
@Deprecated
public class Menu {
      
    /**
     * Control users and do what they want.
     * 
     * @param club A club which must exist to manage the players. 
     */
    @Deprecated
    public void start (Club club){
        int choice; 
        MenuViever menuViewer = new MenuViever(); 
        menuViewer.displayMenu();
        do {
            System.out.println("=============================");
            System.out.println("Choose what you want to do...");
            choice = menuViewer.chooseMenu();

            switch (choice) {
                case 1:
                    Player newPlayer = new Player();
                    String addName;
                    String addSurname;
                    int addNumber;
                    ClubViewer addViewer = new ClubViewer();
                    addName = addViewer.getFirstName();
                    addSurname = addViewer.getSurname();
                    addNumber = addViewer.getNumber();
                    newPlayer = club.createPlayer(addName, addSurname, addNumber);

                    try {
                        club.addToTeam(newPlayer);
                    } catch (PlayerExistsException ex) {
                        addViewer.playerExistMessage(ex.getMessage());
                    }

                    break;
                    
                case 2:
                    Player deletePlayer = new Player();
                    String deleteName;
                    String deleteSurname;
                    ClubViewer deleteViewer = new ClubViewer();
                    deleteName = deleteViewer.getFirstName();
                    deleteSurname = deleteViewer.getSurname();
                    deletePlayer = club.createPlayer(deleteName, deleteSurname);
                 
                    try {
                        club.deletePlayer(deletePlayer);
                    } catch (PlayerNotExistException ex) {
                        deleteViewer.notExistMessage(ex.getMessage());
                    }

                    break;
                    
                case 3:
                    club.displayPlayers();
                    break;
                    
                case 4:
                    Player playerToFind = new Player();
                    String findName;
                    String findSurname;
                    ClubViewer findViewer = new ClubViewer();
                    findName = findViewer.getFirstName();
                    findSurname = findViewer.getSurname();
                    playerToFind = club.createPlayer(findName, findSurname);

                    try {
                        club.findPlayer(playerToFind);
                    } catch (PlayerNotExistException ex) {
                        findViewer.notFoundMessage(ex.getMessage());
                    }

                    break;
                    
                case 5:                  
                    break;
                    
                    
                default:
                    menuViewer.wrongMenu();                 
            }

        } while (choice != 5);
    }
    
}
