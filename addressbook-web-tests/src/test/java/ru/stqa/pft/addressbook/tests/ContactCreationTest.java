package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void addContact() throws Exception{
    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    System.out.println("contact added successfully!");
  }

}
