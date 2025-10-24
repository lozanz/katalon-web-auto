import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseUrl)

//WebUI.maximizeWindow()
WebUI.verifyElementPresent(findTestObject('Object Login Page/usernameField'), 1)

WebUI.setText(findTestObject('Object Login Page/usernameField'), username)

WebUI.verifyElementPresent(findTestObject('Object Login Page/passwordField'), 1)

WebUI.setText(findTestObject('Object Login Page/passwordField'), password)

WebUI.verifyElementPresent(findTestObject('Object Login Page/loginBtn'), 1)

WebUI.click(findTestObject('Object Login Page/loginBtn'))

if (testType == 'valid') {
    WebUI.verifyElementText(findTestObject('Object Product Page/textProducts'), 'Products')
} else if (testType == 'emptyUser') {
    WebUI.verifyTextPresent('Epic sadface: Username is required', false, FailureHandling.STOP_ON_FAILURE)
} else if (testType == 'emptyPass') {
    WebUI.verifyTextPresent('Epic sadface: Password is required', false, FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.verifyTextPresent('Epic sadface: Username and password do not match any user in this service', false, FailureHandling.STOP_ON_FAILURE)
}

