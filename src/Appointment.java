/**
 * Appointment class: Stores patient appointment information
 * Contains core information such as patient details, appointment time slot, selected doctor, etc.
 */
public class Appointment {
    // Patient details: Name and mobile phone number (no need to create a separate Patient class)
    private String patientName; // Patient name
    private String patientPhone; // Patient's mobile phone number (unique identifier for canceling appointments)

    // Appointment time slot (format example: 08:00, 14:30)
    private String timeSlot;

    // Selected doctor (polymorphism application: can accept objects of any subclass of HealthProfessional)
    private HealthProfessional selectedDoctor;

    /**
     * Default constructor (no parameters)
     */
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Not provided";
        this.timeSlot = "No appointment";
        this.selectedDoctor = new HealthProfessional();
    }

    /**
     * Parameterized constructor (initializes all instance variables)
     * @param patientName Patient name
     * @param patientPhone Patient's mobile phone number
     * @param timeSlot Appointment time slot
     * @param selectedDoctor Selected doctor (subclass object)
     */
    public Appointment(String patientName, String patientPhone, String timeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.timeSlot = timeSlot;
        this.selectedDoctor = selectedDoctor;
    }

    /**
     * Method to print all appointment information
     */
    public void printAppointmentDetails() {
        System.out.println("----------------------");
        System.out.println("Appointment Details:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile Number: " + patientPhone);
        System.out.println("Appointment Time Slot: " + timeSlot);
        System.out.println("Treating Doctor Information:");
        // Call the doctor's base information printing method (polymorphism: executes logic based on actual subclass type)
        selectedDoctor.printBaseDetails();
        System.out.println("----------------------");
    }

    // Getter method (Used to query the mobile phone number when canceling an appointment)
    public String getPatientPhone() {
        return patientPhone;
    }
}