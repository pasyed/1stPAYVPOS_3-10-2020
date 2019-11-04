import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\VENKAT~1.ANN\\AppData\\Local\\Temp\\Katalon\\Test Cases\\FirstView\\Force Transactions\\VPOS_ForceTransaction_CardPresent_Or_Not_Present\\20191104_050344\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/FirstView/Force Transactions/VPOS_ForceTransaction_CardPresent_Or_Not_Present', new TestCaseBinding('Test Cases/FirstView/Force Transactions/VPOS_ForceTransaction_CardPresent_Or_Not_Present',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
