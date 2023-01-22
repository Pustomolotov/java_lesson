package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test
  public void addContact() throws Exception{
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().addNewContact();
    if (app.contact().isThereAGroupWithContact()){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    ContactData contact = new ContactData()
            .withLastName("Vitalevich").withFirstName("Artem").withMiddleName("Pustik").withTitle("test1").withCompanyName("companys").withFullAddress("Hogvarts").withPhoneNumber("123456789").withMailContact("B-o-t-u-n@mail.ru").withNotesContact("www.home.ru").withDay("14").withMonth("June").withYear("1996").withHomePage("kek").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
  }

  @Test
  public void addBadContact() throws Exception{
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().addNewContact();
    if (app.contact().isThereAGroupWithContact()){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    ContactData contact = new ContactData()
            .withLastName("Vitalevich").withFirstName("Artem'").withMiddleName("Pustik").withTitle("test1").withCompanyName("companys").withFullAddress("Hogvarts").withPhoneNumber("123456789").withMailContact("B-o-t-u-n@mail.ru").withNotesContact("www.home.ru").withDay("14").withMonth("June").withYear("1996").withHomePage("kek").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
