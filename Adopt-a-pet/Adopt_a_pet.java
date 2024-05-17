import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import objects.Pet;
import objects.Shelter;
import objects.User;
import utility.Ink;

public class Adopt_a_pet {
  private static Scanner input = new Scanner(System.in);
  private static Ink ink = new Ink();
  private static User user;
  private static Shelter shelter = new Shelter();
  private static int choice;
  private static boolean isDone = false;

  public static void main(String[] args) {
     createUser();
     createPets();

     while (!isDone) {
        choice = ink.validateMainMenu();
        switch (choice) {
          case 1:
              handlePetListing();
              break;
          case 2:
              handleShelterDetails();
              break;
          case 3:
              bookAppointment(); // Check if this line is present and properly executed
              break;
          case 4:
              isDone = true; // Set isDone to true to exit the loop
              break;
          case 5:
              handlePetFiltering();
              break;
          default:
              System.out.println("Oops! Invalid choice. Please try again.");
      }
     }

     ink.printGoodday();
  }
  public static void createPets() {
      Pet pet1 = new Pet("spot", "dog", 3, "black", "hound");
      shelter.addPet(pet1);
      Pet pet2 = new Pet("cleveland", "dog", 7, "brown", "boxer");
      shelter.addPet(pet2);
      Pet pet3 = new Pet("monster", "cat", 1, "calico", "calico");
      shelter.addPet(pet3);
  }

  public static void createUser() {
      System.out.println("What is your name? ");
      String name = input.nextLine();
      System.out.println("What is your email? ");
      String email = input.nextLine();
      System.out.println("What is your phone number? ");
      String phoneStr = input.nextLine();
      int phone = Integer.parseInt(phoneStr.replaceAll("[^\\d]", ""));
      user = new User(name, email, phone);
  }

  public static void handlePetListing() {
      ink.printAvailablePets(shelter.getPets());
      while (true) {
          System.out.println("Enter the number of the pet you want to view or 0 to go back: ");
          int pick = input.nextInt();
          input.nextLine(); // Consume the newline
          if (pick != 0) {
              ink.printPetDetails(shelter.getPet(pick - 1));
              System.out.println("Adopt this pet? Y/N");
              String answer = input.nextLine();
              if (answer.equalsIgnoreCase("Y")) {
                  shelter.adopt(pick - 1, user.getName());
                  break;
              } else {
                  System.out.println("Returning to the list of available pets...");
              }
          } else {
              break;
          }
      }
  }

  public static void handleShelterDetails() {
      ink.printShelterDetails(shelter);
      System.out.println("Press Enter to go back to the main menu.");
      input.nextLine();
  }

  public static void handlePetFiltering() {
      System.out.println("Enter the type of pet to filter (e.g., dog, cat): ");
      String type = input.nextLine();
      List<Pet> filteredPets = shelter.filterPetsByType(type);
      ink.printAvailablePets(filteredPets); // Printing the filtered pets
      System.out.println("Press Enter to go back to the main menu.");
      input.nextLine();
  }

  public static void bookAppointment() {
    System.out.println("Booking appointment...");
    System.out.println("Enter the appointment date (YYYY-MM-DD): ");
    String dateInput = input.nextLine();
    

    while (!validateDate(dateInput)) {
       System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format: ");
       dateInput = input.nextLine();
    }

    LocalDate appointmentDate = LocalDate.parse(dateInput);
    System.out.println("Appointment booked for " + appointmentDate + ". Press Enter to go back to the main menu.");
    input.nextLine();
    System.out.println("Appointment booked successfully.");
 }

 public static boolean validateDate(String date) {
    try {
       LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
       return true;
    } catch (DateTimeParseException e) {
       return false;
    }
 }
}