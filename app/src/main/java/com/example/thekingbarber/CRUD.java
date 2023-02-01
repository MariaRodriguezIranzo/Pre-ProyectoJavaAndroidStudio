package com.example.thekingbarber;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CRUD extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params)
    {
        HttpURLConnection conn = null;
        try
        {
            URL url = new URL(params[0]);
            conn = (HttpURLConnection)url.openConnection();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream is = conn.getInputStream();
            }
            else
            {
                InputStream err = conn.getErrorStream();
            }
            return "Done";
        }
        catch (MalformedURLException e)
        { }
        catch (IOException e)
        { }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
        return null;
    }

}
