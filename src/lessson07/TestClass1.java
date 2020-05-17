package lessson07;

@TestClass
public class TestClass1 {

    @Test(priority = 5)
    private void testmethod1() {
        System.out.println("5. testmethod № 1 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 10)
    private void testmethod2() {
        System.out.println("10. testmethod № 2 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 7)
    private void testmethod3() {
        System.out.println("7. testmethod № 3 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 3)
    private void testmethod4() {
        System.out.println("3. testmethod № 4 from class " + getClass().getSimpleName() + " is running");
    }

    @Test()
    private void testmethod5() {
        System.out.println("1. testmethod № 5 from class " + getClass().getSimpleName() + " is running");
    }

    @AfterSuite
    private void someAfterSuiteMethod() {
        System.out.println("The End. Some after suite method from class" + getClass().getSimpleName() + " is running");
    }

    /* для теста RuntimeExeption

    @AfterSuite
    private void someAfterSuiteMethod2(){
        System.out.println("Another after suite method(#2) from class" + getClass().getSimpleName() + " is running");
    }
    */

    @BeforeSuit
    private void someBeforeSuitMethod() {
        System.out.println("Start. Some before suite method from class" + getClass().getSimpleName() + " is running");
    }

}
