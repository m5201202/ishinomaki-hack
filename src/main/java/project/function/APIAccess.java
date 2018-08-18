package project.function;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class APIAccess {

    APIAccess(){
        System.out.println("初期化");
    }

    public String post(String post) throws ClientProtocolException, IOException{
        System.out.println(post);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://labs.goo.ne.jp/api/morph");

        //headerをセットする。デフォルトだとISO-8859-1で送信するらしいので、文字コードも指定。
        httpPost.setHeader("Content-type", "application/json; charset=UTF-8");

        String json = "{\"app_id\":\"afd575c7bc2e9288d6d6bc2d878b820ded248e923449f245b235abc26713eeba\"," +
                " \"sentence\":\""+post+"\"}";
        //データをセットする。文字コードを指定しないと日本語が文字化けしたりする
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);

        //実行
        CloseableHttpResponse response = client.execute(httpPost);

        //HTTPステータスコードを表示
        System.out.println("code = " + response.getStatusLine().getStatusCode());
        //返ってきたデータを表示
        System.out.println(EntityUtils.toString(response.getEntity()));
        String result = EntityUtils.toString(response.getEntity());
        client.close();
        return result;
    }
    public static void main(String args[]){
        APIAccess test = new APIAccess();
        try {
        String testresult = test.post("今日の天気は晴れ");
        }catch (Exception e){}
    }
}
