package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensuePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.goTo().groupPage();
      if (app.group().all().size() == 0){
        app.group().create(new GroupData().withName("Test1"));
      }
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withLastName("Artem").withFirstName("Artem").withMiddleName("Pustik").withTitle("test1").withCompanyName("companys").withFullAddress("Hogvarts").withPhoneNumber("123456789").withMailContact("B-o-t-u-n@mail.ru").withNotesContact("www.home.ru").withDay("14").withMonth("June").withYear("1996").withHomePage("kek").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Shoma").withLastName("Kek");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }
}
