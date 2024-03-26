import org.testng.annotations.DataProvider;

public class CreateUserDataProvider {

    @DataProvider(name = "createUserData")
    public Object[][] createUserData() {
        return new Object[][] {{"Morpheus","Lead"},{"James","Manager"}};
    }
}
