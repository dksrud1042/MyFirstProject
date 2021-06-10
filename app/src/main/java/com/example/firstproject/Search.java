package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //region검색하기 기능 클릭시 이벤트 발생
        Button Search_btn = findViewById(R.id.Search_btn);
        Search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //검색하기 클릭
                EditText CSEditText = findViewById(R.id.CSEditText);
                String message = CSEditText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SearchResult.class);
                intent.putExtra("텍스트인식",message);
                startActivityForResult(intent,MainActivity.SEARCHRESULT_CODE);
            }
        });
        //endregion
    }
}