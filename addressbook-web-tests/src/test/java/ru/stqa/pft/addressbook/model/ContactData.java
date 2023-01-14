package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String title;
  private final String companyName;
  private final String fullAddress;
  private final String phoneNumber;
  private final String mailContact;
  private final String homePage;
  private final String day;
  private final String month;
  private final String year;
  private final String notesContact;
  private String group;

  public ContactData(String firstName, String middleName, String lastName, String title, String companyName, String fullAddress, String phoneNumber, String mailContact, String homePage, String day, String month, String year, String notesContact, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.title = title;
    this.companyName = companyName;
    this.fullAddress = fullAddress;
    this.phoneNumber = phoneNumber;
    this.mailContact = mailContact;
    this.homePage = homePage;
    this.day = day;
    this.month = month;
    this.year = year;
    this.notesContact = notesContact;
    this.group = group;
  }

  public ContactData(int id,String firstName, String middleName, String lastName, String title, String companyName, String fullAddress, String phoneNumber, String mailContact, String homePage, String day, String month, String year, String notesContact, String group) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.title = title;
    this.companyName = companyName;
    this.fullAddress = fullAddress;
    this.phoneNumber = phoneNumber;
    this.mailContact = mailContact;
    this.homePage = homePage;
    this.day = day;
    this.month = month;
    this.year = year;
    this.notesContact = notesContact;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getMailContact() {
    return mailContact;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getNotesContact() {
    return notesContact;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
