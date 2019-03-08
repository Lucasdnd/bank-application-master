package fr.imie.bank.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(birthDate, email, firstName, id, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    return Objects.equals(birthDate, other.birthDate) && Objects.equals(email, other.email)
        && Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
        && Objects.equals(lastName, other.lastName);
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
        + email + ", birthDate=" + birthDate + "]";
  }



}
