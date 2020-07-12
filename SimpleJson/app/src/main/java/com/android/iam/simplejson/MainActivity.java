package com.android.iam.simplejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String jsonPlanetas="{\"planetas\": " +
            " [" +
            " { \"nome\": \"Mercurio\"," +
            " \"posicao\":1," +
            " \"habitavel\":false" +
            " }," +
            " { \"nome\": \"Venus\"," +
            " \"posicao\":2," +
            " \"habitavel\":false" +
            " }," +
            " { \"nome\": \"Terra\"," +
            " \"posicao\":3," +
            " \"habitavel\":true" +
            " }" +
            " ]" +
            "}";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            JSONObject planetas = new JSONObject(jsonPlanetas);
            JSONArray arrayPlanetas = planetas.getJSONArray("planetas");
            for (int i= 0; i < arrayPlanetas.length();i++) {
                JSONObject planeta = arrayPlanetas.getJSONObject(i);
                Log.d("MainActivity",planeta.getString("nome"));
                Log.d("MainActivity", Integer.toString(planeta.getInt("posicao")));
                Log.d("MainActivity", Boolean.toString(planeta.getBoolean("habitavel")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }










    }

