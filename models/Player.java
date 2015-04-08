
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.models;

/**
 * The <code>Player</code> class contain informations about player.
 * 
 * @author Alicja Zorzycka
 * @since MLv1.0
 * @version 3.0
 */
public class Player implements Comparable<Player> {
    /** First name of player */
    private String firstName;
    /** Last name of player */
    private String surname;
    /** Number on the shirt */
    private int playerNumber; 
    
    /**
     * Set first name of player.
     * 
     * @param name first name of player
     */
    public void setFirstName(String name){
        this.firstName = name;        
    }
    
    /**
     * Set surname of player.
     * 
     * @param surname surname of player
     */
    public void setSurname(String surname){
        this.surname = surname;        
    }
    
    /**
     * Set number of player.
     * 
     * @param number number of player
     */
    public void setPlayerNumber(int number){
        this.playerNumber = number;        
    }
       
    /**
     * @return first name of player
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * @return surname of player
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     * @return number of player
     */
    public int getPlayerNumber(){
        return playerNumber;
    }
        
    /**
     * Get full information about one player.
     * 
     */
    @Deprecated
    public void getInfo(){
        System.out.println("Data of the player: ");
        System.out.print("First name: ");
        System.out.println(getFirstName());
        System.out.print("Surname: ");
        System.out.println(getSurname());
        System.out.print("Number: ");
        System.out.println(getPlayerNumber());
    }
    
    @Override
    public int compareTo(Player o) {
        int compareSurname = surname.compareTo(o.surname);
 
        if(compareSurname == 0) {
            return firstName.compareTo(o.firstName);
        }
        else {
            return compareSurname;
        }
    }

}
