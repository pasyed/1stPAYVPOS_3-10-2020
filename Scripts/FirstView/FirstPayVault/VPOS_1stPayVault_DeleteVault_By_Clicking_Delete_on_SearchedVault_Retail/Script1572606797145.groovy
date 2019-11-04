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
 * Tested on Chrome Version 76.0.3809.100
 * Tested on Firefox Version 68.0,70.0
 *
 *
 */

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

WebUI.focus(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'))

CustomKeywords.'utilities.SafeActions.javascriptclick'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), GlobalVariable.PageLoadTime)

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), 'Click on FistPayVault tab', 
        (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_CreateVault'), 
    'Click on CreateVault button', (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), GlobalVariable.PageLoadTime)

vaultReference = CustomKeywords.'utilities.SafeActions.timeWithMilliSeconds'()

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), vaultReference, 
    'Entering Vault Reference Number', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_CreditCardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationMonth'), 
    cardMonth, 'Expiration Month', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationYear'), 
    cardYear, 'year', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ContactName'), customerName, 'Enter Contact Name', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_PostalCode'), postalCode, 'Enter Postal Code', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Address'), address, 'Enter ddress', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/chekBox_AddShippingInformation'), 
    GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ShippingMethod'), shippingMethod, 
    'Enter Shipping Method', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkbox_SameAsBillingInformation'), 
    GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Create'), 'Click on Create Button', 
        (([GlobalVariable.PageLoadTime]) as int[]))

popupSavedToVaultMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/popup_SavedToVaultMessage'), 
    GlobalVariable.PageLoadTime)

flag = CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Successfully Saved to Vault', popupSavedToVaultMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_RunSaleWithThisVault_InPopup'), 
    'Click on Run Sale With This Vault in Popup', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

value = CustomKeywords.'utilities.SafeActions.getAttributeValue'(findTestObject('Pages/FirstPayVault/tab_1stPayVault_Active'), 
    '1st_PayVault')

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_Amount'), GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Amount'), amount, 'Enter Amount', 
        (([GlobalVariable.PageLoadTime]) as int[]))

salesTax = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/input_SalesTaxUnderAmount'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.FirstPayVault.verifyAmountIsNotZero'(salesTax)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_CreditCardNumberForVerification'), GlobalVariable.delayBetweenTestSteps)

cardNumber = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/input_CreditCardNumberForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyCardNumber'(cardNumber, GlobalVariable.visaCardNumber)

/*expirationMonth = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/dropDownExpirationMonthForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(expirationMonth, cardMonth)*/
expirationYear = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/dropDownExpirationYearForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(expirationYear, cardYear)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_VerifyCardHolderName'), GlobalVariable.PageLoadTime)

name = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/input_VerifyCardHolderName'), 
    '1stPayVault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(name, customerName)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/checkbox_TaxExempt'), GlobalVariable.PageLoadTime)

CustomKeywords.'pages.FirstPayVault.verifyAmountIsNotZero'(salesTax)

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkbox_TaxExempt'), GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Checkout'), 'Click on Checkout', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_ReturnToSale_InTransactionComplete'), 
    'Click On Return Button', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), 'Click on FirstPayVault tab', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_SearchVault'), 'Click on Search Vault', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_Search'), 'Click On Search button', 
        (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), GlobalVariable.PageLoadTime)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.FirstPayVault.verifyInvoiceRecord'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), vaultReference)

CustomKeywords.'pages.FirstPayVault.clickOnDelete'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), findTestObject('Pages/FirstPayVault/button_deleteFromVault'), vaultReference)

WebUI.delay(2)

deleteVaultPopupMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/alertMessageAfterDeleteVault'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Vault Deletion successfully completed', deleteVaultPopupMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/closeLocatorForDeletePopupMessage'), 
    'Click on Close button', (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.closeBrowser()

