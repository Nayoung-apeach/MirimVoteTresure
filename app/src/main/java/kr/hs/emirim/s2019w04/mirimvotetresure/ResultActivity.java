package kr.hs.emirim.s2019w04.mirimvotetresure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");
        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");
        TextView[] textVs = new TextView[imgNames.length];
        RatingBar[] ratingBars = new RatingBar[imgNames.length];
        int[] textIds = {R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6, R.id.text7, R.id.text8, R.id.text9};
        int[] ratingIds = {R.id.rating_bar1, R.id.rating_bar2, R.id.rating_bar3, R.id.rating_bar4, R.id.rating_bar5, R.id.rating_bar6, R.id.rating_bar7, R.id.rating_bar8, R.id.rating_bar9};

        TextView winner = (TextView) findViewById(R.id.winner);
        ImageView winnerImage = (ImageView) findViewById(R.id.winnerImage);
        for(int i= 1; i<voteCount.length; i++){
            if(voteCount[max] < voteCount[i])
                max = i;
        }
        winner.setText(imgNames[max]);
        winnerImage.setImageResource(voteCount[max]);

        for(int i=0; i<imgNames.length; i++){
            textVs[i] = findViewById(textIds[i]);
            ratingBars[i] = findViewById(ratingIds[i]);

            textVs[i].setText(imgNames[i]);
            ratingBars[i].setRating((float)voteCount[i]);
        }
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}