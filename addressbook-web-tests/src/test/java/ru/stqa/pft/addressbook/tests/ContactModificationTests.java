package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Artem", null, null, null, null, null, null, null, null, null, null, null, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    System.out.println("contact modification successfully!");
  }
}
