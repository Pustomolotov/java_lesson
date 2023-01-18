package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensuePreconditions(){
    app.goTo().homePage();
    if(app.contact().list().size() == 0){
      app.goTo().groupPage();
      if (app.group().list().size() == 0){
        app.group().create(new GroupData().withName("tes1"));
      }
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withLastName("Vitalevich").withFirstName("Artem").withMiddleName("Pustik").withTitle("test1").withCompanyName("companys").withFullAddress("Hogvarts").withPhoneNumber("123456789").withMailContact("B-o-t-u-n@mail.ru").withNotesContact("www.home.ru").withDay("14").withMonth("June").withYear("1996").withHomePage("kek").withGroup("test1"));
    }
  }
  @Test
  public void testContactDeletion() throws InterruptedException {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() - 1);
      before.remove(deletedContact);
      Assert.assertEquals(before, after);
  }
}
