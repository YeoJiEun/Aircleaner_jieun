package com.bignerdranch.android.DustApp;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.widget.Toast;
import android.content.ContentValues;
import android.os.AsyncTask;
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TEST", "...onCreate - try connect...");

        setContentView(R.layout.activity_main);
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
    
    public void onButton1Clicked(View view){
        String url = "http://ec2-15-164-129-17.ap-northeast-2.compute.amazonaws.com/aircleaner/raspberryPi/on.php";
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();
    }
    public void onButton2Clicked(View view)
    {
        String url = "http://ec2-15-164-129-17.ap-northeast-2.compute.amazonaws.com/aircleaner/raspberryPi/off.php";
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();
    }
    public void onButton3Clicked(View view)
    {
        String url = "http://ec2-15-164-129-17.ap-northeast-2.compute.amazonaws.com/aircleaner/rasp_sjm/on.php";
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();
    }
    public void onButton4Clicked(View view)
    {
        String url = "http://ec2-15-164-129-17.ap-northeast-2.compute.amazonaws.com/aircleaner/rasp_sjm/off.php";
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();
    }

}


