package com.example.fimaz.wsexample;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by fimaz on 26/05/15.
 */
public class ThreadWS extends AsyncTask<String,Integer,Boolean> {

    protected Boolean doInBackground(String... params) {

        boolean resul = false;

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new
                HttpPost("http://192.10.10.111/packetsWS/index.php");

        post.setHeader("content-type", "application/json");

        try
        {
            //Construimos el objeto cliente en formato JSON
            JSONObject dato = new JSONObject();

            dato.put("user", params[0]);
            dato.put("password", params[1]);

            StringEntity entity = new StringEntity(dato.toString());
            post.setEntity(entity);

            HttpResponse resp = httpClient.execute(post);
            String respStr = EntityUtils.toString(resp.getEntity());


            System.out.println(respStr);

            if(!respStr.equals("true"))
                resul = true;
            System.out.println("resul"+resul);
        }

        catch(Exception ex)
        {
            Log.e("ServicioRest", "Error!", ex);
            resul = false;
        }

        return resul;
    }

    protected void onPostExecute(Boolean result) {

        if (result == true)
        {
            Log.d("", "Correct.");
        }
    }

}
