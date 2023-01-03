package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoGroupPage();
      if(!app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      }
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().createContact(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test555" ));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContactDelete();
    System.out.println("Contact deleted successfully!");
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
