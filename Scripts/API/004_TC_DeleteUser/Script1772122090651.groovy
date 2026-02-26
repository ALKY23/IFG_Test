import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

def response = WS.sendRequest(findTestObject('Object Repository/API/Delete_User', [
	('id') : GlobalVariable.userId
]))

WS.verifyResponseStatusCode(response, 204)