package sanilk.com.userinterfaceandnavigation;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecyclerView extends AppCompatActivity {
    android.support.v7.widget.RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    android.support.v7.widget.RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (android.support.v7.widget.RecyclerView)findViewById(R.id.activity_recycler_view_recycler_view);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapter(new String[]{"Hello", "World", "This"});
        recyclerView.setAdapter(adapter);
    }

    private class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        String[] data;

        public class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
            TextView textView;

            public MyViewHolder(TextView textView){
                super(textView);
                this.textView = textView;
            }

        }

        public MyAdapter(String[] data){
            this.data = data;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.textView.setText(data[i]);
        }

        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.mytextview, viewGroup, false);

            MyViewHolder myViewHolder = new MyViewHolder(textView);

            return myViewHolder;
        }

        @Override
        public int getItemCount() {
            return data.length;
        }
    }
}
