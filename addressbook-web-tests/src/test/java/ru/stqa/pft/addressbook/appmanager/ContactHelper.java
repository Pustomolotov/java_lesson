package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {



  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation){
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
    if (creation) {
          clickSelect(By.name("new_group"), contactData.getGroup());
    } else  {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address2"), contactData.getFullAddress());
    type(By.name("phone2"), contactData.getPhoneNumber());
    type(By.name("notes"), contactData.getNotesContact());

  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("//input[22]"));
  }

  public void submitContactDelete(int timeOut) throws InterruptedException {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    timeOut(timeOut);
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public boolean isThereAGroupWithContact() {
    int  countElements = wd.findElements(By.xpath("//*[@id=\"content\"]/form/select[5]/option")).size();
    if (countElements >=2){
      return false;
    }
    return true;
  }

  public void gotoAddNewContact() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))){
      return;
    }
    click(By.linkText("add new"));
  }

  public void createContact (ContactData contact) {
    gotoAddNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return  isElementPresent(By.name("entry"));
  }

  public int getContactCount() {
    return  wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"] > td:nth-child(2)"));
    for (WebElement element : elements){
      String lastName = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("id");
      ContactData contact = new ContactData(id, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
