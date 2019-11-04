import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 *
 * Implemented By ZenQ
 * Tested on Firefox Version 70.0
 *
 *
 */
CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.javascriptclick'(findTestObject('Pages/Refund/tab_Refund'), GlobalVariable.PageLoadTime)

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Refund/tab_Refund'), 'Click on Refundtab', 
        (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, entryModeCheckBox, GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Refund/input_Amount'), amountInput, 'Enter Amount into Amount text box', 
        (([20]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Refund/dropDown_ExpirationMonth'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.Refund.verifyIfCardInformationIsChecked'(tabName, cardInformationCheckBox, GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Refund/input_CardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Refund/dropDown_ExpirationMonth'), 
    cardMonth, 'Enter Month', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Refund/dropDown_ExpirationYear'), 
    cardYear, 'Select Expiration Year', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Refund/input_SecurityCode'), securityCode, 'Enter Security code', 
        (([GlobalVariable.delayForElement]) as int[]))

//CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'September')
//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
//CustomKeywords.'utilities.SafeActions.selectSeleniumCodeYear'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2022')
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

//WebUI.executeJavaScript("document.getElementById('select-expiration-year').className='form-control parsley-success'", null)
/*CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'December')

WebUI.delay(4)*/
/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'December', 'Select by Value', (([20]) as int[]))*/
/*CustomKeywords.'utilities.SafeActions.safeClickWithoutScrollOnLabel'(findTestObject('Pages/Sale/label_ExpirationYear'), 
    'Click on Label', (([20]) as int[]))

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'March')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2035')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2025')*/
CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Refund/button_Checkout'), 'Click on Checkout button', 
        (([60]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

transactionCompleteMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/ForceTransactions/approved_TransactionMessage_TransactionComplete_Screen'), 
    GlobalVariable.delayForElement)

println(transactionCompleteMessage)

CustomKeywords.'pages.Force_Transaction.verifyStrings'(transactionCompleteMessage)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Refund/totalAmount'), GlobalVariable.delayForElement)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Refund/invoiceNumber'), GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Refund/button_ReturnToRefund'), 'Click on Return To Sale', 
        (([10]) as int[]))

WebUI.closeBrowser()
