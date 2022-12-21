package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification()  throws Exception {
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kekyyyyyyyyy"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    System.out.println("contact modification successfully!");
  }
}
