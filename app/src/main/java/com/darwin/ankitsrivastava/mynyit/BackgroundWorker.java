package com.darwin.ankitsrivastava.mynyit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog.Builder alertDialog;
    Intent intent;

    //Context tag = getActivity();
    BackgroundWorker(Context ctx) {

        context = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://10.0.3.2/login.php";
        String register_url = "http://10.0.3.2/register.php";
        String subject_url = "http://10.0.3.2/subjectsdata.php";

        if (type.equals("Login")) {
            try {
                String username = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("Register")) {
            try {
                String fullname = params[1];
                String username = params[2];
                String password = params[3];
                String studentid = params[4];
                String phoneno = params[5];
                String email = params[6];
                String confirmemail = params[7];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("fullname", "UTF-8") + "=" + URLEncoder.encode(fullname, "UTF-8") + "&"
                        + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                        + URLEncoder.encode("studentid", "UTF-8") + "=" + URLEncoder.encode(studentid, "UTF-8") + "&"
                        + URLEncoder.encode("phoneno", "UTF-8") + "=" + URLEncoder.encode(phoneno, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("confirmpassword", "UTF-8") + "=" + URLEncoder.encode(confirmemail, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        } else if (type.equals("showSubject")) {
//            try {
//                //creating a URL
//                URL url = new URL(subject_url);
//
//                //Opening the URL using HttpURLConnection
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//                //StringBuilder object to read the string from the service
//                StringBuilder sb = new StringBuilder();
//
//                //We will use a buffered reader to read the string from service
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//                //A simple string to read values from each line
//                String json;
//
//                //reading until we don't find null
//                while ((json = bufferedReader.readLine()) != null) {
//
//                    //appending it to string builder
//                    sb.append(json + "\n");
//                }
//
//                //finally returning the read string
//                return sb.toString().trim();
//            } catch (Exception e) {
//                return null;
//            }
//
//
//        }
        return null;
        }








    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(context);
    }
    @Override
    protected void onPostExecute(String result) {

        if (result.equals("login successful!!! Welcome")) {

            intent=new Intent(context,HomeScreenActivity.class);
            context.startActivity(intent);

        } else if (result.equals("login not successful"))
        {

        alertDialog.setTitle("Login Status");
            alertDialog.setMessage(result);
            alertDialog.setPositiveButton("New User",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                           // dialog.dismiss();
                            intent=new Intent(context,SignUpActivity.class);
                            context.startActivity(intent);
                        }
                    });
            alertDialog.setNegativeButton("Try Again",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();
                        }
                    });
alertDialog.create();
        alertDialog.show();
        }else {
            alertDialog.setTitle("Register Status");
            alertDialog.create();
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }



    @Override
    protected void onProgressUpdate(Void... values) {


    }
}
