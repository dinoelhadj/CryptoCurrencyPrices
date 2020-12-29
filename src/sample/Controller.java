package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;



public class Controller {
    //Get the Api key free from coinmarketcap
    String apikey = "a878445c-50ae-4d83-a9fa-1f66c4744dfa";
    int BTC,ETH,BCH;

    @FXML
    Label btc,eth,bch;


    public void scrap(){
        scrapBTC();
        scrapETH();
        scrapBCH();
    }
    public void scrapBTC(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/tools/price-conversion?CMC_PRO_API_KEY="+apikey+"&amount=1&symbol=BTC")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject jsObject = new JSONObject(response.body().string());
                JSONObject jAdata = jsObject.getJSONObject("data");
                JSONObject jAquote = jAdata.getJSONObject("quote");
                JSONObject jAusd = jAquote.getJSONObject("USD");
                BTC = jAusd.getInt("price");
                System.out.println("Bitcoin: $" + BTC);
                btc.setText("$"+BTC);
            } catch (JSONException es){
                es.printStackTrace();
            }
        } catch (Exception e ){
            e.printStackTrace();
        }

    }
    public void scrapETH(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/tools/price-conversion?CMC_PRO_API_KEY="+apikey+"&amount=1&symbol=ETH")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject jsObject = new JSONObject(response.body().string());
                JSONObject jAdata = jsObject.getJSONObject("data");
                JSONObject jAquote = jAdata.getJSONObject("quote");
                JSONObject jAusd = jAquote.getJSONObject("USD");
                ETH = jAusd.getInt("price");
                System.out.println("Ethereum: $" + ETH);
                eth.setText("$"+ETH);
            } catch (JSONException es){
                es.printStackTrace();
            }
        } catch (Exception e ){
            e.printStackTrace();
        }

    }
    public void scrapBCH(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/tools/price-conversion?CMC_PRO_API_KEY="+apikey+"&amount=1&symbol=BCH")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject jsObject = new JSONObject(response.body().string());
                JSONObject jAdata = jsObject.getJSONObject("data");
                JSONObject jAquote = jAdata.getJSONObject("quote");
                JSONObject jAusd = jAquote.getJSONObject("USD");
                BCH = jAusd.getInt("price");
                System.out.println("Bitcoin Cash: $" + BCH);
                bch.setText("$"+BCH);
            } catch (JSONException es){
                es.printStackTrace();
            }
        } catch (Exception e ){
            e.printStackTrace();
        }

    }

}
