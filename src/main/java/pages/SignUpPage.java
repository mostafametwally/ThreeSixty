package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class SignUpPage extends Base {
	
	@FindBy(xpath="//*[@id=\"email\"]/input")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"password\"]/input")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"password-confirm\"]/input")
	WebElement Confirmpassword;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[1]/div/form/button")
	WebElement SignUpBtn;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[1]/div[2]/span[2]")
	WebElement NewProject;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[1]/div[2]/div/input")
	WebElement ProjectName;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[1]/div[2]/div/button")
	WebElement AddProjectBtn;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div/span[2]")
	WebElement AddNewTask;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/input")
	WebElement TaskName;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/button")
	WebElement AddTaskBtn;

	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/div/ul/li[1]")
	WebElement Today;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/div/ul/li[2]")
	WebElement Tomorrow;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/div/ul/li[3]")
	WebElement Next_week;
	
	Select porjects;
	public static WebDriverWait wait;
	Actions actions;
	// Constructor
	public SignUpPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		actions = new Actions(driver);
	}	
	
	public void openSignUpPage(String url) {
		driver.get(prop.getProperty(url));
	}
	public String getEmailErrorMsg() throws InterruptedException {
		SignUpBtn.click();
		String validationMsg= driver.findElement(By.xpath("//*[@id=\"email\"]/input")).getAttribute("validationMessage");
		return validationMsg; 
	}
	public String getPassWrdErrorMsg() {
		SignUpBtn.click();
		String validationMsg= driver.findElement(By.xpath("//*[@id=\"password\"]/input")).getAttribute("validationMessage");
		return validationMsg;
	}
	public String getConfirmPassWrdErrorMsg() {	
		SignUpBtn.click();
		String validationMsg= driver.findElement(By.xpath("//*[@id=\"password-confirm\"]/input")).getAttribute("validationMessage");
		return validationMsg;

	}	
	
	public void CreateNewAccount(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		Confirmpassword.sendKeys(password);
		SignUpBtn.click();
		wait.until(ExpectedConditions.urlContains("home"));
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		}
	public void addNewPorjct(String project) {
		
		NewProject.click();
		ProjectName.sendKeys(project);
		AddProjectBtn.click();
	}
	
	public void addNewTask(String UserName, String Password, String ProjectName, String taskName, String duedate) {		
		CreateNewAccount(UserName, Password);
		addNewPorjct(ProjectName);		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/section/div[1]/ul[2]/li/div")).click();;		
		AddNewTask.click();
		TaskName.sendKeys(taskName);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/span[3]")).click();
		wait.until(ExpectedConditions.visibilityOf(Today));
		if(duedate.equals( "Today")){Today.click();}
		if(duedate.equals( "Tomorrow")){Tomorrow.click();}
		if(duedate.equals( "Next Week")){Next_week.click();}
		AddTaskBtn.click();						
	}
}


