import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable

def randomEmail = "haikal${System.currentTimeMillis()}@mail.com"

def response = WS.sendRequest(findTestObject('Object Repository/API/POST_CreateUser', [
    ('email') : randomEmail
]))

println("Status Code: " + response.getStatusCode())
println("Response Body: " + response.getResponseBodyContent())

WS.verifyResponseStatusCode(response, 201)

def json = new JsonSlurper().parseText(response.getResponseBodyContent())

GlobalVariable.userId = json.id

assert json.email == randomEmail
assert json.status == "active"

println("Created User ID: " + json.id)