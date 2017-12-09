package com.darwin.ankitsrivastava.mynyit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Acadamics extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acadamics);

        listView = (ListView) findViewById(R.id.listView);
        getJSON("http://10.0.3.2/sbjectsdata.php");
    }


    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] studentName = new String[jsonArray.length()];
        String[] studentNo = new String[jsonArray.length()];
        String[] subject = new String[jsonArray.length()];
        String[] classroom = new String[jsonArray.length()];
        String[] starting_time = new String[jsonArray.length()];
        String[] ending_time = new String[jsonArray.length()];
        String[] day = new String[jsonArray.length()];
        String[] date = new String[jsonArray.length()];
        String[] professor_name = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            studentName[i] = obj.getString("student_id");
           subject[i] = obj.getString("subject_no");
            Log.e("json",""+subject[i]);
            studentNo[i] = obj.getString("subject_no");
            classroom[i] = obj.getString("classroom");
            professor_name[i] = obj.getString("professor_name");
            starting_time[i] = obj.getString("starting_time");
            ending_time[i] = obj.getString("ending_time");
            date[i] = obj.getString("date");
            day[i] = obj.getString("day");
        }
        List<String> arrayString = new ArrayList<String>();
     //   arrayString.add(studentName);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subject);

        listView.setAdapter(arrayAdapter);
    }
}
