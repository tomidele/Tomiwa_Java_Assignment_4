package objects;

public class User {
  private String name;
  private String email;
  private int phone;

  public User(String name, String email, int phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  } // constructor

  //===============>>
  // GETTERS
  public String getName() {
    return this.name;
  }
  public String getEmail() {
    return this.email;
  }
  public int getPhone() {
    return this.phone;
  }

  //===============>>
  // SETTERS
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPhone(int phone) {
    this.phone = phone;
  }
} // class