package com.example.trupti.myjsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String jsonstr = "{\"widget\": {\n" +
            "    \"debug\": \"on\",\n" +
            "    \"window\": {\n" +
            "        \"title\": \"Sample Konfabulator Widget\",\n" +
            "        \"name\": \"main_window\",\n" +
            "        \"width\": 500,\n" +
            "        \"height\": 500\n" +
            "    },\n" +
            "    \"image\": { \n" +
            "        \"src\": \"Images/Sun.png\",\n" +
            "        \"name\": \"sun1\",\n" +
            "        \"hOffset\": 250,\n" +
            "        \"vOffset\": 250,\n" +
            "        \"alignment\": \"center\"\n" +
            "    },\n" +
            "    \"text\": {\n" +
            "        \"data\": \"Click Here\",\n" +
            "        \"size\": 36,\n" +
            "        \"style\": \"bold\",\n" +
            "        \"name\": \"text1\",\n" +
            "        \"hOffset\": 250,\n" +
            "        \"vOffset\": 100,\n" +
            "        \"alignment\": \"center\",\n" +
            "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
            "    }\n" +
            "}}    ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        js();
    }

    private void js() {

try {


    JSONObject rootjobj = new JSONObject(jsonstr);
    JSONObject glossaryobj = rootjobj.getJSONObject("widget");
    Log.d("tag", "root" + glossaryobj);
    String widgetTitle = glossaryobj.getString("debug");
    Log.d("tag", "ttitle" + widgetTitle);


    JSONObject window = glossaryobj.getJSONObject("window");
    String tle = window.getString("title");
    Log.d("tag", "title" + tle);

    String nametitle = window.getString("name");
    String widthtitle = window.getString("width");
    String hightTitle = window.getString("height");


    JSONObject dataimg=glossaryobj.getJSONObject("image");
    String datasrc=dataimg.getString("src");
    String aname = dataimg.getString("name");
   String ahoppset = dataimg.getString("hOffset");
   String avoffset = dataimg.getString("vOffset");
   String aaligment = dataimg.getString("alignment");



    JSONObject datatext=glossaryobj.getJSONObject("text");
    String ddata=datatext.getString("data");
    String dsize=datatext.getString("size");
    String dstyle=datatext.getString("style");
    String dname=datatext.getString("name");
    String dhoff=datatext.getString("hOffset");
    String dvoff=datatext.getString("vOffset");
    String dalig=datatext.getString("alignment");
    String dmous=datatext.getString("onMouseUp");



    TextView tv = (TextView) findViewById(R.id.jsondata);
    tv.setText("data" +"\n" +tle +"\n"+ nametitle +"\n"+ widthtitle +"\n"+ hightTitle +"\n" + datasrc +"\n"+ aname+"\n" + ahoppset +"\n"+ avoffset
            +"\n"+ aaligment +"\n"+ddata+"\n"+dsize+"\n"+dstyle+"\n"+dname+"\n"+dhoff+"\n"+dvoff+"\n"+dalig+"\n"+dmous);

} catch (JSONException e) {
    e.printStackTrace();
}
    }
}
