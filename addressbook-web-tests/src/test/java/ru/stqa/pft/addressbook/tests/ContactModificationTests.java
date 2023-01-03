package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
      }
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().createContact(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test1" ));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().editContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Artem", null, null, null, null, null, null, null, null, null, null, null, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    System.out.println("contact modification successfully!");
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
