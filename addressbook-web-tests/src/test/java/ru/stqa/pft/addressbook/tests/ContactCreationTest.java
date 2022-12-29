package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase{

  @Test
  public void addContact() throws Exception{
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().gotoAddNewContact();
    if (app.getContactHelper().isThereAGroupWithContact()){
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      app.getNavigationHelper().gotoAddNewContact();
    }
    app.getContactHelper().fillContactForm(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test1" ), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    System.out.println("contact added successfully!");
  }

}
