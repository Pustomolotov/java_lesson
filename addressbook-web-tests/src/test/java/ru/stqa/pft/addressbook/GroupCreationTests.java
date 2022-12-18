package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

  @Test (priority = 0)
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData(groupName, "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
    System.out.println("group added successfully!");
  }

  @Test(priority = 1)
  public void addContact() throws Exception{
    gotoAddNewContact();
    fillContactForm(new ContactData("Artem", "Pustik", "Vitalevich", "test1", "companys", "Hogvarts", "123456789", "B-o-t-u-n@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
    submitContactCreation();
    returnToHomePage();
    System.out.println("contact added successfully!");
  }

}
