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



//WebUI.callTestCase(findTestCase('login'), [('username') : 'standard_user', ('password') : 'secret_sauce'], FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

//WebUI.maximizeWindow()
WebUI.verifyElementPresent(findTestObject('Object Login Page/usernameField'), 1)

WebUI.setText(findTestObject('Object Login Page/usernameField'), 'standard_user')

WebUI.verifyElementPresent(findTestObject('Object Login Page/passwordField'), 1)

WebUI.setText(findTestObject('Object Login Page/passwordField'), 'secret_sauce')

WebUI.verifyElementPresent(findTestObject('Object Login Page/loginBtn'), 1)

WebUI.click(findTestObject('Object Login Page/loginBtn'))
WebUI.delay(5)
//actions.sendKeys(Keys.ESCAPE).perform()

// Pilih dropdown sorting sesuai data dari DDT (Excel)
WebUI.click(findTestObject('Object Product Page/dropdownSort'))

WebUI.selectOptionByValue(findTestObject('Object Product Page/dropdownSort'), sortType, false)

// Ambil teks dari produk pertama setelah disorting
String firstProduct = WebUI.getText(findTestObject('Object Product Page/firstProductName'))

// Verifikasi berdasarkan jenis sorting
if (sortType == 'az') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Backpack', false)
} else if (sortType == 'za') {
    WebUI.verifyMatch(firstProduct, 'Test.allTheThings() T-Shirt (Red)', false)
} else if (sortType == 'lohi') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Onesie', false)
} else if (sortType == 'hilo') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Fleece Jacket', false)
} else {
    KeywordUtil.markWarning("Sort type tidak dikenali: $sortType")
}

