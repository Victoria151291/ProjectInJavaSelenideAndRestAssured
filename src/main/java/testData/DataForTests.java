package testData;

import java.util.UUID;

public class DataForTests {

    public static DataForTests initDataForTests() {
        return new DataForTests();
    }

    public String getRandomTestUserEmail() {
        return getUniqueValue("testemail") + "@test.com";
    }

    public String getRandomTestUserPassword() {
        return getUniqueValue("");
    }

    private String getUniqueValue(String value) {
        value += UUID.randomUUID().toString().substring(0, 8);
        return value;
    }

}