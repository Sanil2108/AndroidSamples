package sanilk.com.userinterfaceandnavigation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

public class GridView extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        this.context = this;

        android.widget.GridView gridView = findViewById(R.id.activity_grid_view_grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ImageAdapter extends BaseAdapter {

        Integer[] data = {
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile
        };

        Context context;

        public ImageAdapter(Context context){
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if(convertView==null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));

            }else{
                imageView=(ImageView) convertView;
            }

            imageView.setImageResource(data[position]);

            return imageView;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
    }
}
