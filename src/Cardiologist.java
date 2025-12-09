/**
 * Cardiologist subclass (inherits from the base HealthProfessional class)
 * Implements the unique attributes and behaviors specific to cardiologists
 */
public class Cardiologist extends HealthProfessional {
    // Unique attribute of cardiologists: Sub-specialty area (e.g., Coronary Heart Disease, Arrhythmia, etc.)
    private String subSpecialty;

    /**
     * Default constructor (no parameters)
     */
    public Cardiologist() {
        super(); // Calls the parent class's default constructor
        this.subSpecialty = "Not specified";
    }

    /**
     * Parameterized constructor (initializes all attributes, including parent class attributes)
     * @param id Doctor ID
     * @param name Name
     * @param specialization Specialization (fixed as "Cardiovascular Diseases" for cardiologists)
     * @param subSpecialty Sub-specialty area
     */
    public Cardiologist(long id, String name, String specialization, String subSpecialty) {
        super(id, name, specialization); // Calls the parent class's parameterized constructor
        this.subSpecialty = subSpecialty;
    }

    /**
     * Prints the complete details of a cardiologist (including type, parent class attributes, and subclass-specific attributes)
     */
    public void printProfessionalDetails() {
        System.out.println("======================");
        System.out.println("Health Professional Type: Cardiologist");
        super.printBaseDetails(); // Calls the parent class's method to print basic information
        System.out.println("Sub-specialty Area: " + subSpecialty);
        System.out.println("======================");
    }

    // Getter method (optional, for future extension)
    public String getSubSpecialty() {
        return subSpecialty;
    }
}