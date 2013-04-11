package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    /**
     * daysVacation cannot be greater than 28 
     * @param daysVacation 
     */
    public void setDaysVacation(int daysVacation) {
        if(daysVacation > MAX_VACATION_DAYS) {
            throw new IllegalArgumentException("daysVacation cannot be greater than 28");
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }
    
    /**
     * do not allow null or zero length, ask about numeric first names
     * Do not allow number, allow hyphens or spaces first names
     * Allow any letter case for the text and massage later in code depending
     * on requirements
     * @param firstName 
     */

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("Entry required.");
        }
        char[] chars = firstName.toCharArray();
        for(char c : chars){
            if (!Character.isLetter(c) || c != '-' || c != ' ')
                throw new IllegalArgumentException("Must be letters, hyphens, or spaces only.");
        }    
        this.firstName = firstName;
        
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if(hireDate == null)
            throw new IllegalArgumentException("Date must be entered.");
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }
/**
 * do not allow null or zero length, ask about numeric last names
     * Maybe allow number at end only, allow hyphens or spaces last names
     * Allow any letter case for the text and massage later in code depending
     * on requirements
 * @param lastName 
 */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() == 0){
            throw new IllegalArgumentException("Entry required.");
        }
        char[] chars = firstName.toCharArray();
        for(char c : chars){
            if (!Character.isLetter(c) || c != '-' || c != ' ')
                throw new IllegalArgumentException("Must be letters, hyphens, or spaces only.");
        }    
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    /**
     * Sets a social security number 
     * @param ssn - the value
     * @throws IllegalArgumentException if ssn does not contain 9 digits only,
     *  if there are not 2 hyphens, if it is not entered
     *  
     */
    public void setSsn(String ssn) throws IllegalArgumentException {
        String[] pieces = ssn.split("-");
        if (ssn.contains("-") && pieces.length != 3)  {
             throw new IllegalArgumentException("must be 2 Hyphens");   
                }
        ssn = ssn.replaceAll("-", "");
        if (ssn.length() != 9){
            throw new IllegalArgumentException("must be 9 digits");
        }
        char[] chars = ssn.toCharArray();
        for(char c : chars){
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("must have 9 digits");
        }
        if(ssn == null || ssn.length() == 0) {
            throw new IllegalArgumentException ("SSN must entered and non-zero");
        }
        this.ssn = ssn;
    }
    
    
}
