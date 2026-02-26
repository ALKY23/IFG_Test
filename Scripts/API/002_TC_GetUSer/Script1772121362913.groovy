import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

def response = WS.sendRequest(findTestObject('Object Repository/API/GET_User', [
	('id') : GlobalVariable.userId
]))

WS.verifyResponseStatusCode(response, 200)

def json = new JsonSlurper().parseText(response.getResponseBodyContent())

assert json.id == GlobalVariable.userId
assert json.status == "active"