package kr.hs.emirim.s2019w04.mirimvotetresure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("르노와르의 선호 작품 투표");

        gridView=findViewById(R.id.grid1);
        adapter=new GridAdapter(this);
        gridView.setAdapter(adapter);



        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
    }


    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", adapter.voteCount);
            intent.putExtra("imgNames", adapter.imgNames);
            startActivity(intent);
        }
    };

}