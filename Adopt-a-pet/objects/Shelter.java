package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
   private String address = "123 Scoopers Lane";
   private String[] hours = new String[]{"Mon: 8am - 4pm", "Tues: 8am - 4pm", "Wed: 8am - 4pm", "Thurs: 8am - 4pm", "Fri: 8am - 4pm", "Sat/Sun: closed"};
   private ArrayList<Pet> pets = new ArrayList<>();

   public Shelter() {
   }

   public String getAddress() {
      return this.address;
   }

   public String[] getHours() {
      return this.hours;
   }

   public ArrayList<Pet> getPets() {
      return this.pets;
   }

   public Pet getPet(int index) {
      return this.pets.get(index);
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setHours(String[] hours) {
      this.hours = hours;
   }

   public void adopt(int index, String owner) {
      Pet pet = this.pets.get(index);
      pet.setIsAdopted();
      pet.setOwner(owner);
      System.out.printf("%s is now yours!\n", pet.getName());
      this.pets.remove(index);
   }

   public void addPet(Pet pet) {
      this.pets.add(pet);
   }

   public List<Pet> filterPetsByType(String type) {
      return this.pets.stream()
                      .filter(pet -> pet.getType().equalsIgnoreCase(type))
                      .collect(Collectors.toList());
   }
}
