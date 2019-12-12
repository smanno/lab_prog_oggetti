package Abstraction.WarehouseNew;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Inviatore {

    public static void invia(String url, String parametro) throws ClientProtocolException, IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://www.a-domain.com/foo/");

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(1);
        // TODO: 12/12/2019 map 
        
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        // Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                // do something useful
            }
        }
    }
}
