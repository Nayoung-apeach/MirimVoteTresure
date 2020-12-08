package kr.hs.emirim.s2019w04.mirimvotetresure;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i};
    String[] imgNames = {"최현석", "박지훈", "요시", "김준규", "마시호", "윤재혁", "아사히", "방예담", "김도영"};
    int[] voteCount = new int[imgNames.length];

    public GridAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ImageView imgv=new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(250,320));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(10,10,10,10);
        imgv.setImageResource(imgRes[position]);
        final int pos=position;

        for (int i=0; i< voteCount.length; i++){
            voteCount[i] = 0;
        }

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCount[pos]++;
                Toast.makeText(context, imgNames[pos] + ": 총 " + voteCount[pos] + "표", Toast.LENGTH_SHORT).show();
            }
        });

        return imgv;
    }
}