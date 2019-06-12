import org.testng.Assert;
import org.testng.annotations.Test;

public class FindCheapIphone extends BaseTests {

    private IphoneSix iphone;

    @Test
    public void findcheaperIphoneFromAmazone() {
        navigateToAmazonWebsite();

        LendingPage landingPage = new LendingPage(chromeDriver);
        landingPage.typeAndSubmitTextInSerchField(chromeDriver);

         IphoneSixSearchResults iphoneSixSearchResults = new IphoneSixSearchResults(chromeDriver);
         iphone = iphoneSixSearchResults.returnBestIphoneChoise(chromeDriver);

         EMailUtility mail = new EMailUtility(iphone.getName(),Double.toString(iphone.getPrice()));
         mail.sendMail();
         Assert.assertEquals( mail.getMail(),"Aut Test Name: " + iphone.getName() + " price: " + iphone.getPrice()+"\r\n");
    }
}
