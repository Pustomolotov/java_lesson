package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void addContact() throws Exception{
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    app.contact().addNewContact();
    if (app.contact().isThereAGroupWithContact()){
      app.goTo().groupPage();
      app.group().create(new GroupData("test1", null, null));
    }
    ContactData contact = new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek", "test555" );
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
