package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PomPages {
	
	WebDriver driver;
	JavascriptExecutor js ;
	@FindBy(xpath = "//h1[contains(text(),'Practice Form')]") private WebElement Scroll;
	@FindBy(xpath = "//input[@class='mr-sm-2 form-control']") private WebElement Email;
	@FindBy(xpath = "//input[@placeholder='First Name']") private WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName']") private WebElement lastname;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label") private WebElement rediobtn;
	@FindBy(xpath = "//input[@placeholder='Mobile Number']") private WebElement mobilefield;
	@FindBy(xpath = "//input[@id='dateOfBirthInput']") private WebElement dateofBirthfield;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement selectmonth;
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement selectYear;
	@FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--013']") private WebElement Date;
	@FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div/div[1]") private WebElement Subject;
	@FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label") private WebElement clicktextbox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitform;
	public PomPages(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String scroll() 
	{
	 js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Scroll);
		
		String gettext = Scroll.getText();
		return gettext;
	}
	
	
	public void enterfirstname(String firstnames) 
	{
		firstname.sendKeys(firstnames);
	}
	
	
	public String getFirstname()
	{
		String getfirstnames = firstname.getText();
		return  getfirstnames;
	}
	
	
	public void enterlastname(String name)
	{
		lastname.sendKeys( name);
	}

	
	public void enteremail(String email) 
	{
		Email.sendKeys(email);
	}
	
	
	public String getEmail()
	{
		String getemail = Email.getText();
		return getemail;
	}
	
	
	public void entermobile(String mobilenomber) throws InterruptedException 
	{
		Thread.sleep(2000);
		rediobtn.click();
		mobilefield.sendKeys(mobilenomber);
	}
	
	
	public void enterdateofbirth() 
	{
		dateofBirthfield.click();
		
		Select sc=new Select(selectmonth);
		sc.selectByValue("2");
		Select sx=new Select(selectYear);
		sx.selectByVisibleText("1997");
		Date.click();
	}
	
	
	public String getdateofbirth() 
	{
		String getdateofbirth = dateofBirthfield.getText();
		return getdateofbirth;
		
	}
	public void entersubject(String subject) throws InterruptedException {
		//Thread.sleep(3000);
		Subject.sendKeys(subject);
	}
	public String gettextsubject()
	{
		String text = Subject.getText();
		return text;
	}
	public void clickHobies() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)",clicktextbox);
		clicktextbox.click();
		submitform.click();
		
	    }
	

}
