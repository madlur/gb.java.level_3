package lessson07;

@TestClass
public class TestClass2 {

    @Test(priority = 4)
    private void testmethod1() {
        System.out.println("4. testmethod № 1 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 6)
    private void testmethod2() {
        System.out.println("6. testmethod № 2 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 8)
    private void testmethod3() {
        System.out.println("8. testmethod № 3 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 2)
    private void testmethod4() {
        System.out.println("2. testmethod № 4 from class " + getClass().getSimpleName() + " is running");
    }

    @Test(priority = 6)
    private void testmethod5() {
        System.out.println("6. testmethod № 5 from class " + getClass().getSimpleName() + " is running");
    }

    @AfterSuite
    private void someAfterSuiteMethod() {
        System.out.println("The end. Some after suite method from class" + getClass().getSimpleName() + " is running");
    }


    @BeforeSuit
    private void someBeforeSuitMethod() {
        System.out.println("Start. Some before suite method from class" + getClass().getSimpleName() + " is running");
    }
    /* для теста RuntimeExeption

    @BeforeSuit
    private void someBeforeSuitMethod2(){
        System.out.println("Another before suite method (#2) from class" + getClass().getSimpleName() + " is running");
    }
     */


}
