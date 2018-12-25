package sanilk.com.userinterfaceandnavigation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AdapterView extends AppCompatActivity{

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);

        MyAdapter myAdapter = new MyAdapter(context);

        ListView listView = (ListView)findViewById(R.id.adapter_view_list);
        listView.setOnItemClickListener(myAdapter);
        listView.setAdapter(myAdapter);
    }

    private class MyAdapter extends ArrayAdapter<MyObject> implements android.widget.AdapterView.OnItemClickListener {

        private Context context;

        private MyObject[] myObjects = {
                new MyObject("Object1", "sub1"),
                new MyObject("Object2", "sub2"),
                new MyObject("Object3", "sub3"),
                new MyObject("Object4", "sub4"),
                new MyObject("Object5", "sub5"),
                new MyObject("Object6", "sub6"),
                new MyObject("Object7", "sub7"),
                new MyObject("Object8", "sub8")
        };

        public MyAdapter(Context context) {
            super(context, R.layout.adapter_list_row);
            super.addAll(myObjects);

            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.adapter_list_row, parent, false);

            TextView heading = v.findViewById(R.id.adapter_view_heading);
            TextView subheading = v.findViewById(R.id.adapter_view_sub);

            heading.setText(myObjects[position].heading);
            subheading.setText(myObjects[position].subheading);

            return v;
        }

        @Override
        public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
        }
    }

    private class MyObject{
        public String heading;
        public String subheading;

        public MyObject(String heading, String subheading) {
            this.heading = heading;
            this.subheading = subheading;
        }
    }
}
