package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static  int lastNameIdx = 1;

    public static void main(String[] args) throws IllegalArgumentException {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        
        /**
         * fullName must be entered
         * if there is a comma, assume the first element is the last name
         * if there are three elements, assume the third element is the last name
         * if there are two elements with no comma, assume the second element is the last name
         * 
         */
        if (fullName == null || fullName.length()== 0){
            throw new IllegalArgumentException("Full name must be entered.");
        }
        String s;
        String [] pieces = fullName.split(" ");        
        if (fullName.contains(",")){
                fullName = getValueLessComma(pieces[0]);
                lastNameIdx = 0;
        }        
        if (pieces.length == 3)
                lastNameIdx = 2;
        String lastName = app.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String extractLastName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[lastNameIdx];
    }
    
    private static String getValueLessComma(String value) {
        return value.substring(0, value.length()-1);
        
    }

}
