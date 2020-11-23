package kr.hs.emirim.s2019w04.mirimvotetresure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"최현석", "박지훈", "요시", "김준규", "마시호", "윤재혁", "아사히", "방예담", "김도영"};
    int[] voteCount = new int[imgNames.length];
    int[] imgVIds = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};
    int index;

    ImageView[] imgVs = new ImageView[imgNames.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<voteCount.length; i++){
            voteCount[i] = 0;
        }

        for (int i=0; i<imgVs.length; i++){
            final int index;
            index = i;
            imgVs[index] = findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + ": 총" + voteCount[index] + "표", Toast.LENGTH_SHORT);
                }
            });
        }
    }
}
