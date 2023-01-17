package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

public class ApplicationManager {

  private GroupHelper groupHelper;
  private  ContactHelper contactHelper;
  private  NavigationHelper navigationHelper;
  private  SessionHelper sessionHelper;
  String userLogin = "admin";
  String userPassword = "secret";
  private JavascriptExecutor js;
  WebDriver wd;
  private Browser browser;

  public ApplicationManager(Browser browser) {

    this.browser = browser;
  }

  public void init() {
    if (browser.equals(Browser.CHROME)) {
      wd = new ChromeDriver();
    }else if (browser.equals(Browser.FIREFOX)){
      wd = new FirefoxDriver(new FirefoxOptions().setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
    }
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    js = (JavascriptExecutor) wd;
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
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

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
