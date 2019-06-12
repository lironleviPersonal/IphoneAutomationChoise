import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;


public class IphoneSixSearchResults extends CommonPom{



    private ArrayList <IphoneSix> iphoneSixResults;
    private IphoneSix firstResult;
    private IphoneSix secondResult;
    private IphoneSix thirdResult;

    public IphoneSixSearchResults(WebDriver driver){
        super(driver);
        iphoneSixResults = new ArrayList<IphoneSix>();

    }

    final String firstIphoneName =  "div[data-cel-widget=\"search_result_0\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String secondIphoneName =  "div[data-cel-widget=\"search_result_1\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String thirdIphoneName =  "div[data-cel-widget=\"search_result_2\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";

    final String firstPrice ="div[data-cel-widget=\"search_result_0\"] span[class=\"a-price-whole\"]";
    final String secondPrice ="div[data-cel-widget=\"search_result_1\"] span[class=\"a-price-whole\"]";
    final String thirdPrice ="div[data-cel-widget=\"search_result_2\"] span[class=\"a-price-whole\"]";


    @FindBy(css = firstIphoneName) private WebElement firstLinkNameResult;
    @FindBy(css = firstPrice) private WebElement firstPriceResult;

    @FindBy(css = secondIphoneName) private WebElement secondLinkNameResult;
    @FindBy(css = secondPrice) private WebElement secondPriceResult;

    @FindBy(css = thirdIphoneName) private WebElement thirdLinkNameResult;
    @FindBy(css = thirdPrice) private WebElement thirdPriceResult;


    public IphoneSix returnBestIphoneChoise(WebDriver driver){
        CreateIphoneSix(driver);
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
    private void  CreateIphoneSix(WebDriver driver){

        firstResult = new IphoneSix(getTextElement(driver,firstLinkNameResult,firstIphoneName),(converDollarToILS(driver,firstPriceResult,firstPrice)));
        secondResult = new IphoneSix(getTextElement(driver, secondLinkNameResult,secondIphoneName),(converDollarToILS(driver,secondPriceResult,secondPrice)));
        thirdResult = new IphoneSix(getTextElement(driver,thirdLinkNameResult,thirdIphoneName),(converDollarToILS(driver, thirdPriceResult,thirdPrice)));

        iphoneSixResults.add(firstResult);
        iphoneSixResults.add(secondResult);
        iphoneSixResults.add(thirdResult);
    }

    private double converDollarToILS(WebDriver driver, WebElement price, String selector){
        double priceInILS;
        priceInILS = Integer.parseInt(getTextElement(driver, price,selector)) * 3.6;
         return priceInILS;
    }
}
