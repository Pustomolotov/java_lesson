package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

  private GroupHelper groupHelper;
  private  ContactHelper contactHelper;
  private  NavigationHelper navigationHelper;
  private  SessionHelper sessionHelper;
  String userLogin = "admin";
  String userPassword = "secret";
  String groupName = "groupOne";
  private JavascriptExecutor js;
  WebDriver wd;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/System32/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) wd;
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd, groupName);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd, groupName);
    sessionHelper.login(userLogin, userPassword);
  }


  public void stop() {
    sessionHelper.logOut(userLogin, userPassword);
    wd.quit();
  }



  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
