package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  private String groupName;


  public ContactHelper(WebDriver wd, String groupName) {
    super(wd);
    this.groupName = groupName;
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData){
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getFirstName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("address"), contactData.getFullAddress());
    type(By.name("home"), contactData.getPhoneNumber());
    type(By.name("mobile"), contactData.getPhoneNumber());
    type(By.name("work"), contactData.getPhoneNumber());
    type(By.name("fax"), contactData.getPhoneNumber());
    type(By.name("email"), contactData.getMailContact());
    type(By.name("email2"), contactData.getMailContact());
    type(By.name("email3"), contactData.getMailContact());
    type(By.name("homepage"), contactData.getHomePage());
    clickSelect(By.name("bday"), contactData.getDay());
    clickSelect(By.name("bmonth"), contactData.getMonth());
    type(By.name("byear"), contactData.getYear());
    clickSelect(By.name("aday"), contactData.getDay());
    clickSelect(By.name("amonth"), contactData.getMonth());
    type(By.name("ayear"), contactData.getYear());
  try {
    wd.findElement(By.xpath("//select[@name='new_group']"));
    clickSelect(By.name("new_group"), groupName);
    System.out.println("WebElement SEE");
  } catch (Exception e) {
    System.out.println("WebElement DON'T SEE");
  }
    type(By.name("address2"), contactData.getFullAddress());
    type(By.name("phone2"), contactData.getPhoneNumber());
    type(By.name("notes"), contactData.getNotesContact());

  }


  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void submitContactModification() {
    click(By.xpath("//input[22]"));
  }

  public void submitContactDelete() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }
}
