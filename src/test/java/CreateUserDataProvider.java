import org.testng.annotations.DataProvider;

public class CreateUserDataProvider {

    @DataProvider(name = "createUserData", parallel = true)
    public Object[][] createUserData() {
        return new Object[][]{{"Morpheus", "Lead"},
                {"James", "Manager"},
                {"Mike", "Employee"},
                {"Bob", "Employee"},
                {"Justin", "CEO"}};
    }
}
