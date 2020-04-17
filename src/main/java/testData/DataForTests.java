package testData;

import org.json.JSONObject;

import java.util.UUID;

public class DataForTests {

    public static DataForTests initDataForTests() {
        return new DataForTests();
    }

    public String getRandomTestAccountEmail() {
        return getUniqueValue("testemail") + "@test.com";
    }

    public String getRandomTestAccountPassword() {
        return getUniqueValue("");
    }

    private String getUniqueValue(String value) {
        value += UUID.randomUUID().toString().substring(0, 8);
        return value;
    }

    public JSONObject getJSONForAuth() {
        JSONObject json = new JSONObject();
        json.put("email", "testemail49c75352@test.com");
        json.put("password", "e38b19e3");
        return json;
    }
}