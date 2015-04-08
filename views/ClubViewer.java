
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views;

import java.util.Scanner;

/**
 * The <code>ClubViever</code> class contains methods and fields 
 * to contact with user.
 *
 * @author Alicja Zorzycka
 * @since MLv1.0
 * @version 1.0
 */
@Deprecated
public class ClubViewer {
        
    /**
     * Get surname of the player from the user.
     * 
     * @return surname of the player
     */
    public String getSurname(){
        Scanner scanner = new Scanner(System.in);
        String surname;
        System.out.print("Write surname: ");
        surname = scanner.nextLine();
        return surname;      
    }
    
    /**
     * Get first name of the player from the user.
     * 
     * @return first name of the player
     */
    public String getFirstName(){
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter data of the player");
        System.out.print("Write first name: ");
        name = scanner.nextLine();
        return name;
    }
    
    /**
     * Get number on the player's shirt from the user.
     * 
     * @return number on the player's shirt
     */
    public int getNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Write number: ");
        number = scanner.nextInt();
        return number;
    }
    
    /**
     * Get reply if status <code>injured</code> of the player must be change.
     * 
     * @return Status of health: 
     * 0 - healthy 
     * 1 - unhealthy
     * 2 - wrong reply
     */
    public int getInjured(){
        Scanner scanner = new Scanner(System.in);
        int unhealthy; 
        String reply;
        System.out.println("Is player injured?");
        System.out.println("Write yes/no: ");
        reply = scanner.nextLine();
        
        if (reply.equalsIgnoreCase("no")){
            unhealthy = 0;
        }
        else {
            if (reply.equalsIgnoreCase("yes")){
                unhealthy = 1;
            }
            else {
                unhealthy = 2;
            }
        }
        return unhealthy;
    }
      
    /**
     * Inform about wrong functions.
     * 
     * @param message Message from exceptions object.
     */
    public void playerExistMessage (String message){
        System.out.println("Player " + message + "is already in the team.");
    }
    
    public void notExistMessage (String message){
        System.out.println("Player " + message + "doesn't exist...");
    }
    
    public void notFoundMessage (String message){
        System.out.println("Player " + message + "wasn't found in the team...");
    }
    
}
