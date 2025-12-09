import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main Class: Entry point for the Simple Health Service Appointment System
 * Contains the main program logic, demonstrating the use of classes, object creation, and appointment functions
 */
public class AssignmentOne {
    // Appointment collection (stores all appointment objects, globally accessible for easy method calls)
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3 —— Using Classes and Objects
        System.out.println("===== Part 3: Display of Health Professional Information =====");
        // Create 3 General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Zhang San", "General Practice", 8);
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Li Si", "General Practice", 5);
        GeneralPractitioner gp3 = new GeneralPractitioner(1003, "Wang Wu", "General Practice", 3);

        // Create 2 Cardiologist objects
        Cardiologist cardio1 = new Cardiologist(2001, "Zhao Liu", "Cardiovascular Diseases", "Coronary Heart Disease Diagnosis and Treatment");
        Cardiologist cardio2 = new Cardiologist(2002, "Sun Qi", "Cardiovascular Diseases", "Arrhythmia Treatment");

        // Print details of all health professionals
        gp1.printProfessionalDetails();
        gp2.printProfessionalDetails();
        gp3.printProfessionalDetails();
        cardio1.printProfessionalDetails();
        cardio2.printProfessionalDetails();

        System.out.println("------------------------------");

        // Part 5 —— Appointment Collection
        System.out.println("===== Part 5: Appointment Function Demonstration =====");
        // 1. Create appointments (2 with General Practitioners, 2 with Cardiologists)
        createAppointment("Xiao Ming", "13800138001", "09:00", gp1);
        createAppointment("Xiao Hong", "13900139002", "10:30", gp2);
        createAppointment("Xiao Gang", "13700137003", "14:00", cardio1);
        createAppointment("Xiao Li", "13600136004", "15:30", cardio2);

        // 2. Print existing appointments
        System.out.println("\n[First Print of All Appointments]");
        printExistingAppointments();

        // 3. Cancel appointment (cancel Xiao Gang's appointment via mobile phone number)
        System.out.println("\n[Executing Appointment Cancellation]");
        cancelBooking("13700137003");

        // 4. Print appointments again (verify cancellation result)
        System.out.println("\n[Second Print of All Appointments (1 Cancelled)]");
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    /**
     * Creates a new appointment and adds it to the collection
     * Polymorphism application: Can accept doctor objects of any HealthProfessional subclass
     * Data validation: Ensures all required information is not null/invalid
     * @param patientName Patient name
     * @param patientPhone Patient's mobile phone number
     * @param timeSlot Appointment time slot
     * @param doctor Selected doctor (subclass object)
     */
    private static void createAppointment(String patientName, String patientPhone, String timeSlot, HealthProfessional doctor) {
        // Data validation: Required information cannot be empty
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Failed to create appointment: Patient name cannot be empty!");
            return;
        }
        if (patientPhone == null || patientPhone.trim().isEmpty() || patientPhone.length() != 11) {
            System.out.println("Failed to create appointment: Invalid mobile phone number format (must be 11 digits)!");
            return;
        }
        if (timeSlot == null || timeSlot.trim().isEmpty() || !timeSlot.matches("\\d{2}:\\d{2}")) {
            System.out.println("Failed to create appointment: Invalid time slot format (must be in the format like 08:00)!");
            return;
        }
        if (doctor == null) {
            System.out.println("Failed to create appointment: No doctor selected!");
            return;
        }

        // Validation passed: Create appointment object and add to collection
        Appointment newAppointment = new Appointment(patientName, patientPhone, timeSlot, doctor);
        appointmentList.add(newAppointment);
        System.out.println("Appointment created successfully! Patient: " + patientName + ", Doctor: " + doctor.getName());
    }

    /**
     * Prints all existing appointments
     * If there are no appointments, prompts the user
     */
    private static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointment records currently available!");
            return;
        }

        System.out.println("Total number of existing appointments: " + appointmentList.size());
        // Traverse the collection and print details of each appointment
        for (Appointment appointment : appointmentList) {
            appointment.printAppointmentDetails();
        }
    }

    /**
     * Cancels an appointment via the patient's mobile phone number
     * Iterates through the collection to find a matching mobile phone number, deletes it if found, and prompts if not found
     * @param patientPhone Patient's mobile phone number (unique identifier for canceling appointments)
     */
    private static void cancelBooking(String patientPhone) {
        // Use iterator for traversal (supports simultaneous traversal and deletion)
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean isCancelled = false;

        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getPatientPhone().equals(patientPhone)) {
                iterator.remove(); // Safely delete the current appointment
                System.out.println("Appointment cancellation successful! The appointment record with mobile phone number " + patientPhone + " has been deleted");
                isCancelled = true;
                break; // Assume one mobile phone number corresponds to one appointment; exit after finding it
            }
        }

        // No matching mobile phone number found
        if (!isCancelled) {
            System.out.println("Appointment cancellation failed: No appointment record found with mobile phone number " + patientPhone);
        }
    }
}