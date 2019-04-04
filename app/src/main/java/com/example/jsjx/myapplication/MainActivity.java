package com.example.jsjx.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   Spinner spinner,spinner1;
   TextView tv_show;
String [] sheng=new String[]{"山西省","河南省"};
String [][] shi=new String[][]{{"太原市","运城市","大同市"},{"郑州市","洛阳市","开封市"}};
ArrayAdapter<String>adapter,shiadapter;
int shengposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sheng);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                shiadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,shi[position]);
                shengposition=position;
            }
        });
        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_show.setText(adapter.getItem(shengposition)+shiadapter.getItem(position));
            }
        });
        /*for (int i=0;i<sheng.length;i++){
            list.add(sheng[i]);
        }
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
    }

    private void initview() {
        spinner=findViewById(R.id.Spinner);
        spinner1=findViewById(R.id.Spinner1);
        tv_show=findViewById(R.id.tv_show);
    }
}
