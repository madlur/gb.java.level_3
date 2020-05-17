package lessson07;


public class TestClass3 {
    @Test(priority = 10)
    private void methodThatNeverStart() {
        System.out.println("You didn`t see this method and class");
    }
}
