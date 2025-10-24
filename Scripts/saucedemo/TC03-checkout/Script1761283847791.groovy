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

WebUI.callTestCase(findTestCase('saucedemo/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Product Page/dropdownSort'), 'hilo', false)

WebUI.click(findTestObject('Object Product Page/addToCart4'))

WebUI.click(findTestObject('Object Product Page/addToCart3'))

WebUI.click(findTestObject('Object Product Page/addToCart2'))

WebUI.click(findTestObject('Object Product Page/cartIcon'))

WebUI.verifyElementText(findTestObject('Object Cart Page/textYourCart'), 'Your Cart')

WebUI.click(findTestObject('Object Cart Page/removeProduct', [('index') : 2]))

WebUI.click(findTestObject('Object Cart Page/chekoutBtn'))

WebUI.verifyElementText(findTestObject('Object Cart Page/textChekoutInform'), 'Checkout: Your Information')

WebUI.verifyElementPresent(findTestObject('Object Cart Page/firstnameField'), 1)

WebUI.setText(findTestObject('Object Cart Page/firstnameField'), 'Baby')

WebUI.verifyElementPresent(findTestObject('Object Cart Page/lastnameField'), 1)

WebUI.setText(findTestObject('Object Cart Page/lastnameField'), 'Groot')

WebUI.verifyElementPresent(findTestObject('Object Cart Page/postalCodeField'), 1)

WebUI.setText(findTestObject('Object Cart Page/postalCodeField'), '25586')

WebUI.click(findTestObject('Object Cart Page/continueBtn'))

WebUI.verifyElementText(findTestObject('Object Cart Page/textChekcoutOverview'), 'Checkout: Overview')

WebUI.click(findTestObject('Object Cart Page/finishBtn'))

WebUI.verifyElementText(findTestObject('Object Cart Page/textChekcoutComplete'), 'Checkout: Complete!')

WebUI.click(findTestObject('Object Cart Page/backHomebtn'))

WebUI.verifyElementPresent(findTestObject('Object Product Page/menuBtn'), 1)

WebUI.click(findTestObject('Object Product Page/menuBtn'))

WebUI.verifyElementPresent(findTestObject('Object Product Page/logoutBtn'), 1)

WebUI.click(findTestObject('Object Product Page/logoutBtn'))

WebUI.verifyElementPresent(findTestObject('Object Login Page/loginBtn'), 1)

WebUI.closeBrowser()

