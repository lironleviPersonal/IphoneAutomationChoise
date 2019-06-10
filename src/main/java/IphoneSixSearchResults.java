import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;


public class IphoneSixSearchResults {
    private ArrayList <IphoneSix> iphoneSixResults;
    private IphoneSix firstResult;
    private IphoneSix secondResult;
    private IphoneSix thirdResult;


    public IphoneSixSearchResults(){
        iphoneSixResults = new ArrayList<IphoneSix>();
    }

    final String firstIphoneName =  "div[data-cel-widget=\"search_result_0\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String secondIphoneName =  "div[data-cel-widget=\"search_result_1\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String thirdIphoneName =  "div[data-cel-widget=\"search_result_2\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";

    final String firstPrice ="div[data-cel-widget=\"search_result_0\"] span[class=\"a-price-whole\"]";
    final String secondPrice ="div[data-cel-widget=\"search_result_1\"] span[class=\"a-price-whole\"]";
    final String thirdPrice ="div[data-cel-widget=\"search_result_2\"] span[class=\"a-price-whole\"]";



    @FindBy(how = How.CSS , using = firstIphoneName) private WebElement firstLinkNameResult;
    @FindBy(how = How.CSS , using = firstPrice) private WebElement firstPriceResult;

    @FindBy(how = How.CSS , using = secondIphoneName) private WebElement secondLinkNameResult;
    @FindBy(how = How.CSS , using = secondPrice) private WebElement secondPriceResult;

    @FindBy(how = How.CSS , using = thirdIphoneName) private WebElement thirdLinkNameResult;
    @FindBy(how = How.CSS , using = thirdPrice) private WebElement thirdPriceResult;


    public IphoneSix returnBestIphoneChoise(){
        CreateIphoneSix();
        return returnCheapeastResult();
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
    private void  CreateIphoneSix(){

        firstResult = new IphoneSix(firstLinkNameResult.getText(),(converDollarToILS(firstPriceResult)));
        secondResult = new IphoneSix(secondLinkNameResult.getText(),(converDollarToILS(secondPriceResult)));
        thirdResult = new IphoneSix(thirdLinkNameResult.getText(),(converDollarToILS(thirdPriceResult)));

        iphoneSixResults.add(firstResult);
        iphoneSixResults.add(secondResult);
        iphoneSixResults.add(thirdResult);

    }

    private double converDollarToILS(WebElement price){
        double priceInILS;
        priceInILS = Integer.parseInt(price.getText()) * 3.6;
         return priceInILS;
    }
}
