public class Manager {
    private LoginPage loginPage;
    private SecondPage secondPage;
    private ThirdPage thirdPage;

    public Manager() {
        loginPage = new LoginPage(this);
        loginPage.createLoginPage();
    }

    public void showSecondPage() {
        secondPage = new SecondPage(this);
        secondPage.createSecondPage();
    }

    public void showThirdPage() {
        thirdPage = new ThirdPage();
        thirdPage.createThirdPage();
    }
}