/**
 * Base class for Health Professionals
 * Universal parent class for all health professionals (general practitioners, specialists, etc.)
 * Contains common attributes and behaviors of all health professionals
 */
public class HealthProfessional {
    // Required instance variables: ID (numeric only), Name
    private long id; // Unique identifier for health professionals (numeric type)
    private String name; // Name of the health professional

    // Additional basic information: Specialization (basic attribute possessed by all doctors)
    private String specialization;

    /**
     * Default constructor (no parameters)
     */
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.specialization = "Not specified";
    }

    /**
     * Parameterized constructor (initializes all instance variables)
     * @param id Health professional ID
     * @param name Name
     * @param specialization Specialization
     */
    public HealthProfessional(long id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    /**
     * Method to print all instance variables of the base class
     */
    public void printBaseDetails() {
        System.out.println("Basic Health Professional Information:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }

    // Getter methods (Used for the Appointment class to access doctor information in subsequent operations)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}