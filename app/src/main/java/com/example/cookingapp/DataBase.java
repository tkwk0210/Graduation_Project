package com.example.cookingapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase extends Activity {
    private static String ip = "172.30.1.5";                                   //접속할 서버측의 IP, 현재는 로컬에서 진행하니 이 컴퓨터의 IP주소를 할당하면 된다.
    private static String port = "49670";                                       //SQL 구성 관리자에서 TCP/IP 구성 중 모든 IP포트를 설정하는 구간에서 동적 포트를 적으면 된다.
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "MyDataBase";                              //접속할 데이터베이스 이름
    private static String username = "tkwk0210";                                 //서버접속용 ID PW
    private static String password = "tkwk0210";
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;

    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //인터넷 퍼미션을 요구하도록 함
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        //레이아웃의 에디트텍스트를 가져옴
        //etSql = (EditText)findViewById(R.id.sql_et);

        try {
            //연결시도
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);

            //연결성공 후 SUCCESS문자 표시
            //etSql.setText("SUCCESS");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            //실패시 에러 표시
            //etSql.setText("ERROR");
        }
    }

    public void sqlButton(View view) {

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();

                //미리 준비한 쿼리문을 사용하여 값을 가져와 resultSet 변수에 담아두도록한다.
                //ResultSet은 C#의 DataSet과 성능은 떨어지지만 기능적으로는 흡사함.
                ResultSet resultSet = statement.executeQuery("SELECT userName FROM userTbl WHERE userID = 'tkwk0210'");

                while (resultSet.next()) {
                    //가져온 모든 값들을 next()메소드로 모두 순회하여 띄우도록 한다.
                    //etSql.setText(resultSet.getString(1)); //resultSet에서는 첫번째 필드가 1부터 시작한다.
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            //etSql.setText("Connection is null");
        }
    }
}

    class URLConnector extends Thread {

        private String result;
        private String URL;

        public URLConnector(String url){
            URL = url;
        }

        @Override
        public void run() {
            final String output = request(URL);
            result = output;
        }

        public String getResult(){
            return result;
        }

        private String request(String urlStr) {
            StringBuilder output = new StringBuilder();
            try {
                java.net.URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    int resCode = conn.getResponseCode();
                    if (resCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())) ;
                        String line = null;
                        while(true) {
                            line = reader.readLine();
                            if (line == null) {
                                break;
                            }
                            output.append(line + "\n");
                        }

                        reader.close();
                        conn.disconnect();
                    }
                }
            } catch(Exception ex) {
                Log.e("SampleHTTP", "Exception in processing response.", ex);
                ex.printStackTrace();
            }

            return output.toString();
        }
}


