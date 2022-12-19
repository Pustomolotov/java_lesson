package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

  @Test
  public void addContact() throws Exception{
    gotoAddNewContact();
    fillContactForm(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
    submitContactCreation();
    returnToHomePage();
    System.out.println("contact added successfully!");
  }

}