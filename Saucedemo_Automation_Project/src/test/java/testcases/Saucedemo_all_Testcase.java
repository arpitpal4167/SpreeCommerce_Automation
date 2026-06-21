package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPages_POM;
import POM_Pages.HomePage_ProductPage_POM;
import POM_Pages.LoginPage_POM;
import helper.BaseTest;
import utility_Files.Excel_Utility;

public class Saucedemo_all_Testcase extends BaseTest{
  @Test(priority = 1)
  public void login_testcase() throws IOException, InterruptedException
  {
	  
	  //1. Login using Excel data
	  
	  String user = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx","saucedemo_Login",1,0 );
	  String pass = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1,1);
	  
	  LoginPage_POM l = new LoginPage_POM(wd);
	  HomePage_ProductPage_POM h= new HomePage_ProductPage_POM(wd);
	  
	  l.login(user, pass);
	  Thread.sleep(2000);
	  h.logout_process();
	  Log.info("Login and logout Successful");
	}
  
  @Test(priority = 2)
  public void add_to_cart_testcase() throws IOException, InterruptedException
  {
	  
	  //2. Add product to cart
	  String user = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx","saucedemo_Login",1,0 );
	  String pass = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1,1);
	  
	  LoginPage_POM l = new LoginPage_POM(wd);
	  HomePage_ProductPage_POM h= new HomePage_ProductPage_POM(wd);
	  
	  l.login(user, pass);
	  Log.info("Login successful");
	  Thread.sleep(2000);
	 
	  h.click_on_add_to_cart_button();
	  Thread.sleep(2000);
	  h.click_on_cart_icon();
	  Log.info("Product added and cart opened");
	  
	  h.logout_process();
	  Log.info("User logged out");
	  
  }
  @Test(priority = 3)
  public void checkout_address() throws IOException, InterruptedException
  {
	//3. Checkout & Address
	  String user = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx","saucedemo_address", 1, 0);
	  String pass = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1,1);
	  String fname = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx","saucedemo_address",1,2 );
	  String lname = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1,3);
	  String zip = Excel_Utility.getcellData(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1,4);
	  
	  LoginPage_POM l = new LoginPage_POM(wd);
	  HomePage_ProductPage_POM h = new HomePage_ProductPage_POM(wd);
	  CartPage_POM ct = new CartPage_POM(wd);
	  CheckoutPages_POM ch = new CheckoutPages_POM(wd);
	  
	  l.login(user, pass);
	  Log.info("Login Successful");
	  Thread.sleep(2000);
	  
	  h.click_on_add_to_cart_button();
	  Thread.sleep(2000);
	  h.click_on_cart_icon();
	  Log.info("Product added and cart opened");
	  Thread.sleep(2000);
	  
	  ct.click_on_checkout_button();
	  Log.info("Navigates to checkout page for adding address details");
	  Thread.sleep(2000);
	  
	  ch.enterDetails(fname, lname, zip);
	  Log.info("Address details entered");
	  Thread.sleep(2000);
	  
	  ch.clickFinish();
	  Thread.sleep(2000);
	  String successMsg = wd.findElement(By.className("complete-header")).getText();
	  Assert.assertEquals(successMsg, "Thank you for your order!");
	  Log.info("Order placed successfully");
	  
	  ch.click_on_Back_Home();
	  Log.info("Navigated to home or product page");
	  
	  h.logout_process();
	  Log.info("User logged out");
	  Thread.sleep(2000);
	  
	  
	  
  }
}
