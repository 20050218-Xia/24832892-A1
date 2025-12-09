/**
 * General Practitioner subclass (inherits from the base HealthProfessional class)
 * Implements the unique attributes and behaviors specific to general practitioners
 */
public class GeneralPractitioner extends HealthProfessional {
    // Unique attribute of general practitioners: Years of practice (key information distinguishing from other health professionals)
    private int yearsOfPractice;

    /**
     * Default constructor (no parameters)
     */
    public GeneralPractitioner() {
        super(); // Calls the parent class's default constructor
        this.yearsOfPractice = 0;
    }

    /**
     * Parameterized constructor (initializes all attributes, including parent class attributes)
     * @param id Doctor ID
     * @param name Name
     * @param specialization Specialization (fixed as "General Practice" for general practitioners)
     * @param yearsOfPractice Years of practice
     */
    public GeneralPractitioner(long id, String name, String specialization, int yearsOfPractice) {
        super(id, name, specialization); // Calls the parent class's parameterized constructor
        this.yearsOfPractice = yearsOfPractice;
    }

    /**
     * Prints the complete details of a general practitioner (including type, parent class attributes, and subclass-specific attributes)
     */
    public void printProfessionalDetails() {
        System.out.println("======================");
        System.out.println("Health Professional Type: General Practitioner");
        super.printBaseDetails(); // Calls the parent class's method to print basic information
        System.out.println("Years of Practice: " + yearsOfPractice + " years");
        System.out.println("======================");
    }

    // Getter method (optional, for future extension)
    public int getYearsOfPractice() {
        return yearsOfPractice;
    }
}