package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        //제품 이름 받기
        TextView textView = findViewById(R.id.Name1);
        Intent intent = getIntent();
        String message = intent.getStringExtra("제품명");
        String all_ingre = intent.getStringExtra("모든성분");
        textView.setText(message);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        //세로 레이아웃 활용
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        MaindataAdapter adapter = new MaindataAdapter();

        List<String> all_ingre_list = Arrays.asList(all_ingre.split(","));

        //RecyclerView안에 data 넣기(사진,이름)
        try {

            InputStreamReader is = new InputStreamReader(getResources().openRawResource(R.raw.result));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            CSVReader read = new CSVReader(reader);
            String[] record = null;
            while ((record = read.readNext()) != null) {
                // all_ingre_list안에 성분의 이름이 있으면 출력
                if (all_ingre_list.contains(record[1])) {
                    switch (record[3]) {
                        case "1":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade1));
                            break;
                        case "2":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade2));
                            break;
                        case "3":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade3));
                            break;
                        case "4":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade4));
                            break;
                        case "5":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade5));
                            break;
                        case "6":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade6));
                            break;
                        case "7":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade7));
                            break;
                        case "8":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade8));
                            break;
                        case "9":
                            adapter.addItem(new Maindata(record[1], R.drawable.grade9));
                            break;
                    }
                }
            }
//            for(int i = 0; i <record.length;i++)
//            {
//                adapter.addItem(new CSdata(record[i]));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }

        recyclerView2.setAdapter(adapter);

    }


}