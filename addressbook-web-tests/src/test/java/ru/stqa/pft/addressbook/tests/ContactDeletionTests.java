package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoGroupPage();
      if(!app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      }
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().createContact(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test555" ));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDelete();
    System.out.println("Contact deleted successfully!");
  }
}
