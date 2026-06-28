package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPage_POM;
import POM_Pages.HomePage_POM;
import POM_Pages.LoginPage_POM;
import POM_Pages.ProductPage_POM;
import POM_Pages.Registration_Page;
import Utility_Files.Excel_Utility;
import helper.BaseTest;

public class SpreeCommerce_All_TestCases extends BaseTest{
	
	 String path = System.getProperty("user.dir") + "\\src\\test\\resources\\spree_test_data.xlsx";

    @Test(priority = 1)
    public void registration_testcase() throws IOException, InterruptedException {

        String fname = Excel_Utility.getcellData(path, "spree_registration", 1, 0);
        String lname = Excel_Utility.getcellData(path, "spree_registration", 1, 1);
        String email = Excel_Utility.getcellData(path, "spree_registration", 1, 2);
        String password = Excel_Utility.getcellData(path, "spree_registration", 1, 3);
        String confirmpass = Excel_Utility.getcellData(path, "spree_registration", 1, 4);

        Registration_Page r = new Registration_Page(wd);
        HomePage_POM h = new HomePage_POM(wd);
        LoginPage_POM l = new LoginPage_POM(wd);

        r.Registrations(fname, lname, email, password, confirmpass);
        Thread.sleep(3000);

         h.click_on_signout();
         Thread.sleep(2000);
         

        Log.info("Registration test completed");
    }
    
    @Test(priority = 2)
    public void login_testcase() throws Exception {

    	String path = System.getProperty("user.dir") + "\\src\\test\\resources\\spree_test_data.xlsx";

        String email = Excel_Utility.getcellData(path, "spree_login", 1, 0);
        String password = Excel_Utility.getcellData(path, "spree_login", 1, 1);

        LoginPage_POM l = new LoginPage_POM(wd);
        HomePage_POM h = new HomePage_POM(wd);

        l.login(email, password);

        Thread.sleep(3000);

        h.logout_process();
        
        Thread.sleep(3000);

        Log.info("Login and Logout Successful");
    }
    
    @Test(priority = 3)
    public void search_product_testcase() throws IOException, InterruptedException {

    	String path = System.getProperty("user.dir") + "\\src\\test\\resources\\spree_test_data.xlsx";

        String email = Excel_Utility.getcellData(path, "spree_login", 1, 0);
        String password = Excel_Utility.getcellData(path, "spree_login", 1, 1);

        String product = Excel_Utility.getcellData(path, "spree_product", 1, 0);

        LoginPage_POM l = new LoginPage_POM(wd);
        HomePage_POM h = new HomePage_POM(wd);

        l.login(email, password);
        Log.info("Login Successful");

        Thread.sleep(2000);

        h.search_productname(product);
        Log.info("Product searched successfully");

        Thread.sleep(3000);

        h.logout_process();
        Thread.sleep(3000);

        Log.info("Logout Successful");
    }
    
    @Test(priority = 4)
    public void add_to_cart_testcase() throws IOException, InterruptedException {

    	 String path = System.getProperty("user.dir") + "\\src\\test\\resources\\spree_test_data.xlsx";

        String email = Excel_Utility.getcellData(path, "spree_login", 1, 0);
        String password = Excel_Utility.getcellData(path, "spree_login", 1, 1);
        String product = Excel_Utility.getcellData(path, "spree_product", 1, 0);

        LoginPage_POM l = new LoginPage_POM(wd);
        HomePage_POM h = new HomePage_POM(wd);
        ProductPage_POM p = new ProductPage_POM(wd);
        CartPage_POM c = new CartPage_POM(wd);

        l.login(email, password);
        Log.info("Login Successful");
        Thread.sleep(3000);

        h.search_productname(product);
        Log.info("Product searched successfully");
        Thread.sleep(3000);

        p.select_product();
        Log.info("Product Opened");
        Thread.sleep(2000);

        p.click_on_addtocart();
        Log.info("Product Added To Cart");
        Thread.sleep(2000);

        c.click_on_viewCart();
        Thread.sleep(2000);

        h.logout_process();
        Log.info("Logout Successful");
        Thread.sleep(2000);
        
    }
    
    @Test(priority = 5)
    public void place_order_testcase() throws IOException, InterruptedException {

        String email = Excel_Utility.getcellData(path, "spree_login", 1, 0);
        String password = Excel_Utility.getcellData(path, "spree_login", 1, 1);
        String product = Excel_Utility.getcellData(path, "spree_product", 1, 0);

       // String c_email = Excel_Utility.getcellData(path, "spree_address", 1, 0);
        String c_country = Excel_Utility.getcellData(path, "spree_address", 1, 1);
        String c_fname = Excel_Utility.getcellData(path, "spree_address", 1, 2);
        String c_lname = Excel_Utility.getcellData(path, "spree_address", 1, 3);
        String c_company = Excel_Utility.getcellData(path, "spree_address", 1, 4);
        String c_address = Excel_Utility.getcellData(path, "spree_address", 1, 5);
        String c_city = Excel_Utility.getcellData(path, "spree_address", 1, 6);
        String c_state = Excel_Utility.getcellData(path, "spree_address", 1, 7);
        String c_postalCode = Excel_Utility.getcellData(path, "spree_address", 1, 8);
        String c_phone = Excel_Utility.getcellData(path, "spree_address", 1, 9);

        LoginPage_POM l = new LoginPage_POM(wd);
        HomePage_POM h = new HomePage_POM(wd);
        ProductPage_POM p = new ProductPage_POM(wd);
        CartPage_POM c = new CartPage_POM(wd);
        CheckoutPage_POM ch = new CheckoutPage_POM(wd);

        l.login(email, password);
        Thread.sleep(2000);

        h.search_productname(product);
        Thread.sleep(2000);

        p.select_product();
        Thread.sleep(2000);

        p.click_on_addtocart();
        Thread.sleep(2000);

        c.click_on_viewCart();
        Thread.sleep(2000);

        c.click_on_checkout();
        Thread.sleep(2000);

        ch.enterShippingAddress(
        		
                c_country,
                c_fname,
                c_lname,
                c_company,
                c_address,
                c_city,
                c_state,
                c_postalCode,
                c_phone
        );

       // ch.selectPaymentOption();
       // Thread.sleep(1000);

       // ch.termcondition();
        Thread.sleep(3000);

        ch.clickPlaceOrder();

        Thread.sleep(10000);

        ch.click_contiune_shopping();
        Thread.sleep(2000);

        h.logout_process();
        Thread.sleep(2000);

        Log.info("Order Placed and logout successfully");
    }
    
    
    
    }



