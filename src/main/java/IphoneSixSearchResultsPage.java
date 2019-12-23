import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class IphoneSixSearchResultsPage extends CommonPom{

    private ArrayList <IphoneSix> iphoneSixResults;
    private IphoneSix firstResult;
    private IphoneSix secondResult;
    private IphoneSix thirdResult;

    final String firstIphoneName =  "div[data-cel-widget=\"search_result_0\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String secondIphoneName =  "div[data-cel-widget=\"search_result_1\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";
    final String thirdIphoneName =  "div[data-cel-widget=\"search_result_2\"] span[class=\"a-size-medium a-color-base a-text-normal\"]";

    final String firstPrice ="div[data-cel-widget=\"search_result_0\"] span[class=\"a-color-base\"]";
    final String secondPrice ="div[data-cel-widget=\"search_result_1\"] span[class=\"a-color-base\"]";
    final String thirdPrice ="div[data-cel-widget=\"search_result_2\"] span[class=\"a-price-whole\"]";

    @FindBy(css = firstIphoneName)
    private WebElement firstLinkNameResult;

    @FindBy(css = firstPrice)
    private WebElement firstPriceResult;

    @FindBy(css = secondIphoneName)
    private WebElement secondLinkNameResult;
    @FindBy(css = secondPrice)
    private WebElement secondPriceResult;

    @FindBy(css = thirdIphoneName)
    private WebElement thirdLinkNameResult;

    @FindBy(css = thirdPrice)
    private WebElement thirdPriceResult;

    public IphoneSixSearchResultsPage(){
        super();
        iphoneSixResults = new ArrayList<IphoneSix>();
    }


    public ArrayList <IphoneSix>  CreateIphoneSix(){

        firstResult = new IphoneSix(getTextElement(firstLinkNameResult,firstIphoneName),
                (converDollarToILS(firstPriceResult,firstPrice)));
        secondResult = new IphoneSix(getTextElement(secondLinkNameResult,secondIphoneName),
                (converDollarToILS(secondPriceResult,secondPrice)));
        thirdResult = new IphoneSix(getTextElement(thirdLinkNameResult,thirdIphoneName),
                (converDollarToILS(thirdPriceResult,thirdPrice)));

        iphoneSixResults.add(firstResult);
        iphoneSixResults.add(secondResult);
        iphoneSixResults.add(thirdResult);

        return iphoneSixResults;
    }

    private double converDollarToILS(WebElement price, String selector){
        double priceInILS;
        String element = getTextElement(price,selector);
        element = element.replace("$","");
        priceInILS = Double.parseDouble(element) * 3.6;
         return priceInILS;
    }
}
