package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData(groupName, "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
    System.out.println("group added successfully!");
  }
}
