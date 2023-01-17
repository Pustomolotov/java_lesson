package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensuePreconditions(){
    app.goTo().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.goTo().groupPage();
      if (!app.group().isThereAGroup()){
        app.group().create(new GroupData("Test1", "test2", "test3"));
      }
      app.goTo().gotoHomePage();
      app.getContactHelper().createContact(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test1" ));
    }
  }
  @Test
  public void testContactDeletion() throws InterruptedException {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().submitContactDelete(5);
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);
      before.remove(index);
      Assert.assertEquals(before, after);
  }
}
