
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models;

import java.util.LinkedList;
import java.util.List;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerExistsException;
import pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerNotExistException;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * The <code>Club</code> class contain informations about club.
 * 
 * @author Alicja Zorzycka
 * @since MLv1.0
 * @version 3.0
 */

public class Club  {
    
    /** Name of the club. */
    private String name;
    /** Name of the stadion*/
    private String stadion;
    /** Year when the club was founded. */
    private int established;
    /** Name of the most important person in the club. */
    private String president;
    /** Name of the person who trains the team. */
    private String coach;
    /** List of the player in the club's team. */
    List<Player> team = new LinkedList<Player>();
    
    /**
     * Set name of the club.
     * 
     * @param name name of the club
     */
    public void setName (String name){
        this.name = name;
    }
    
    /**
     * Set name of the stadion.
     * 
     * @param stadion name of the stadion
     */
    public void setStadion (String stadion){
        this.stadion = stadion;
    }
    
    /**
     * Set year when club was founded.
     * 
     * @param established year when club was founded
     */
    public void setEstablished (int established){
        this.established = established;
    }
    
    /**
     * Set name of the club's president.
     * 
     * @param president name of the president
     */
    public void setPresident (String president){
        this.president = president;
    }
    
    /**
     * Set name of the couch.
     * 
     * @param coach name of the couch
     */
    public void setCoach (String coach){
        this.coach = coach;
    }
    
    /**
     * 
     * @return name of the club
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return name of the stadion
     */
    public String getStadion(){
        return stadion;
    }
    
    /**
     * 
     * @return name of the president
     */
    public String getPresident(){
        return president;
    }
    
    /**
     * 
     * @return name of the coach
     */
    public String getCoach(){
        return coach;
    }
    
    /**
     * 
     * @return year when the club was founded
     */
    public int getEstablished(){
        return established;
    }
    
    /**
     * 
     * @return year when the club was founded
     */
    public String getEstablishedString(){
        String value;
        value = Integer.toString(established);
        return value;
    }
    
    /**
     * Create new player.
     * 
     * @param name first name of player
     * @param surname surname of player
     * @param number number on the player's shirt
     * @return created player
     */
    public Player createPlayer (String name, String surname, int number){
        Player newPlayer = new Player();
        newPlayer.setFirstName(name);
        newPlayer.setSurname(surname);
        newPlayer.setPlayerNumber(number);
        return newPlayer;
    }
    
    public Player createPlayer (String name, String surname){
        Player newPlayer = new Player();
        newPlayer.setFirstName(name);
        newPlayer.setSurname(surname);
        return newPlayer;
    }
    
    /**
     * Add player to the team.
     * 
     * @param newPlayer Player to be added to the team.
     * @throws pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerExistsException
     * throw when player exist.
     */
    public void addToTeam(Player newPlayer) throws PlayerExistsException {
        boolean playerExist = false;  
        
        if (team.isEmpty())
            team.add(newPlayer);
        else{
            for (Player player : team) {
                if (newPlayer.getSurname().equals(player.getSurname())){
                    if (newPlayer.getFirstName().equals(player.getFirstName())) {
                        playerExist = true;  
                    }
                }
            }
                        
            if (!playerExist) {
                team.add(newPlayer);  
            }
            else {
                JOptionPane.showMessageDialog(null, "Player exist!");
            }
  
        } 
        Collections.sort(team);

    }

    /**
     * Write informations about players in the team.
     * 
     */
    @Deprecated
    public void displayPlayers(){
        for (Player team1 : team) {
            System.out.println("-----------");
            System.out.print("First name: ");
            System.out.println(team1.getFirstName());
            System.out.print("Surname: ");
            System.out.println(team1.getSurname());
            System.out.print("Number: ");
            System.out.println(team1.getPlayerNumber());
        }
    }
    
    /**
     * Delete player from the team.
     * 
     * @param playerToDelete player who will be deleted from the team
     * @throws pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerNotExistException
     * throw when player not exist.
     */
    public void deletePlayer(Player playerToDelete) throws PlayerNotExistException{
                
        if (team.isEmpty())
            JOptionPane.showMessageDialog(null, "No players in the team!");
        else{
            for (int i = 0; i<team.size(); i++){
            
                if (playerToDelete.getSurname().equals(team.get(i).getSurname())){
                    if (playerToDelete.getFirstName().equals(team.get(i).getFirstName())){ 
                        team.remove(i); 
                        return;
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "There is no such a player in the team!");
                    }
                }
                else {

                }
            }
            JOptionPane.showMessageDialog(null, "There is no such a player in the team!");
        }   

    }
    
    /**
     * Find player in the team.
     * 
     * @param playerToFind The player which want to be found.
     * @throws pl.polsl.java.lab1.alicja.zorzycka.moonysleague.exceptions.PlayerNotExistException
     * throw when player not exist.
     */
    @Deprecated
    public void findPlayer(Player playerToFind) throws PlayerNotExistException{
  
        boolean playerExist = false; 
        Player playerFound = new Player();
        
        if (team.isEmpty())
            System.out.println("Team has no players");
        else{
            for (Player player : team) {
                if (playerToFind.getSurname().equals(player.getSurname()))
                    if (playerToFind.getFirstName().equals(player.getFirstName())) {
                        playerExist = true;      
                        playerFound = player;
                    }
            }
            
            if (playerExist) {
                playerFound.getInfo();
            }
            else {
                throw new PlayerNotExistException(playerToFind.getFirstName() + " " + playerToFind.getSurname() + " ");
            }
        }   
    }
    
    /**
     * Find player in the team.
     * 
     * @param playerToFind The player which want to be found.
     * @return Player which was found.
     * @throws PlayerNotExistException throw when player not exist.
     */
    @Deprecated
     public Player findPlayerToChange (Player playerToFind) throws PlayerNotExistException{
  
        boolean playerExist = false; 
        Player playerFound = new Player();
        
        if (team.isEmpty()){
            System.out.println("Team has no players");
            playerFound.setFirstName("notExist");
            return playerFound;
        }
        else{
            for (Player player : team) {
                if (playerToFind.getSurname().equals(player.getSurname()))
                    if (playerToFind.getFirstName().equals(player.getFirstName())) {
                        playerExist = true;      
                        playerFound = player;
                    }
            }
            
            if (playerExist) {
                return playerFound;
            }
            else {
                throw new PlayerNotExistException(playerToFind.getFirstName() + " " + playerToFind.getSurname() + " ");
            }
        }   
    }
      
    /**
     * How many players are in the team.
     * 
     * @return number of players in the team
     */
    public int getNumberOfPlayers (){
        return this.team.size();
    }
    
    /**
     * Get list of the players.
     * 
     * @return list of the players
     */
    public List<Player> getList(){
        return team;
    }
    
    /**
     *  Get information about club and write them.
     */
    @Deprecated
    public void getInfo(){
        System.out.print("Name: ");
        System.out.println(getName());
        System.out.print("Stadion: ");
        System.out.println(getStadion());
        System.out.print("Established: ");
        System.out.println(getEstablished());
        System.out.print("President: ");
        System.out.println(getPresident());
        System.out.print("Coach: ");
        System.out.println(getCoach());
    }
    
}
