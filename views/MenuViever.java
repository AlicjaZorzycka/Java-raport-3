
package pl.polsl.java.lab1.alicja.zorzycka.moonysleague.views;

import java.util.Scanner;
       
/**
 * The <code>MenuViever</code> class contains useful methods and fields used 
 * to contact with user.
 * 
 * @author Alicja Zorzycka
 * @since MLv1.0
 * @version 1.0
 */
@Deprecated
public class MenuViever {
    /** 
     * Display menu.
     */
    public void displayMenu(){
        System.out.println("Welcome to the Monny's League!\n");
        System.out.println("Choose option: ");
        System.out.println("[1] - add");
        System.out.println("[2] - delete");
        System.out.println("[3] - display");
        System.out.println("[4] - find player");
        System.out.println("[5] - change health status of the player");
        System.out.println("[6] - exit");
    }
    
    /**
     * Take from user the number to the menu.
     * @return variable <code>choice</code> used in main switch
     */
    public int chooseMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
                   
        do {
            if (!scanner.hasNextInt()) {
                System.out.println("Pleasa enter a number");
                scanner.nextLine();
            }
            else {
                choice = scanner.nextInt();            
            }          
        } while(choice == 0);
        
        return choice; 
    }
    
    /**
     * Inform about wrong choice.
     */
    public void wrongMenu(){
        System.out.println("There's no such a thing!");
        System.out.println("Please choose again...");
    }
    
}
