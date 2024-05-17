package utility;
import objects.Shelter;
import java.util.Scanner;
import java.util.List;

import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
  
  public void printWelcome() {
    // do nothing yet...
  } // printWelcome()

  public void printGoodday() {
    System.out.println("Have a great day pet lover");
  } // printGoodday()

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println("##### MAIN MENU #####");
      System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit");
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=2) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println("Please enter a 1 - 4");
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println("That's not a number!");
      } 
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()

  public void printPetDetails(Pet pet) {
    System.out.printf("Name: %s\n", pet.getName());
    System.out.printf("Age: %d\n", pet.getAge());
    System.out.printf("Breed: %s\n", pet.getBreed());
    System.out.printf("Color: %s\n", pet.getColor());
    System.out.printf("Owner: %s\n", pet.getOwner());
    System.out.printf("Is Adopted: %b\n", pet.getIsAdopted());
    System.out.println("Adopt this pet? Y/N");
  } // printPetDetails()
  
  public void printAvailablePets(List<Pet> list) {
    for(int i = 0; i < list.size(); i++) {
      if(!list.get(i).getIsAdopted()) {
        System.out.printf("(%d) Name: %s Type: %s Age: %d\n", i + 1,
          list.get(i).getName(), list.get(i).getType(), list.get(i).getAge());
      }
    } // for
    System.out.println("Enter 0 to go back");
  } // printAvailablePets()

  public void printShelterDetails(Shelter shelter) {
    System.out.printf("Shelter Address: %s\n", shelter.getAddress());
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    } // for
    System.out.println("hit any key to go back");
  } // printShelterDetails

} // class