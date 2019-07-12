import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class FindCheapIphone {

    private ArrayList<IphoneSix> iphoneSixResults;
    private IphoneSix cheapestIphone;

    @Test
    public void findcheaperIphoneFromAmazone() {

        LandingPage landingPage = new LandingPage();
        landingPage.navigateToAmazonWebsite();
        landingPage.typeSerchResults();
        landingPage.submitSearch();

        IphoneSixSearchResultsPage iphoneSixSearchResultsPage = new IphoneSixSearchResultsPage();
        iphoneSixResults = iphoneSixSearchResultsPage.CreateIphoneSix();
        cheapestIphone = returnCheapeastResult();

        EMailUtility.sendMail(cheapestIphone.getName(),Double.toString(cheapestIphone.getPrice()));
        Assert.assertEquals( EMailUtility.getMail(),"Aut Test Name: " + cheapestIphone.getName() + " price: " + cheapestIphone.getPrice()+"\r\n");
    }

    private IphoneSix returnCheapeastResult(){
        IphoneSix cheapestIphone =iphoneSixResults.get(0);
        for(IphoneSix iphone : iphoneSixResults){
            if(iphone.getPrice() <  cheapestIphone.getPrice()){
                cheapestIphone = iphone;
            }
        }
        return cheapestIphone;
    }
}
