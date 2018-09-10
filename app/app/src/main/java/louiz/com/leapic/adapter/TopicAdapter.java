package louiz.com.leapic.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;

import louiz.com.leapic.R;
import louiz.com.leapic.activity.LearnEngActivity;
import louiz.com.leapic.model.Topic;

public class TopicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Topic> topics;

    public TopicAdapter(Context context, int layout, ArrayList<Topic> topics) {
        this.context = context;
        this.layout = layout;
        this.topics = topics;
    }

    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int postition) {
        return topics.get(postition);
    }

    @Override
    public long getItemId(int postition) {
        return postition;
    }

    private class ViewHolder{
        ImageView imgTopic;
        TextView txtTopic;
    }

    @Override
    public View getView(int postition, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();
        if(row ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.txtTopic = row.findViewById(R.id.txtTopic);
            holder.imgTopic = row.findViewById(R.id.imageTopic);
            row.setTag(holder);

        }else{
            holder = (ViewHolder) row.getTag();

        }
        final Topic topic = topics.get(postition);
        holder.txtTopic.setText(topic.getName());
        byte[] imgTopic = topic.getPic();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgTopic,0,imgTopic.length);
        holder.imgTopic.setImageBitmap(bitmap);
        holder.imgTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LearnEngActivity.class);
                String topicId = Integer.toString(topic.getiD());
                intent.putExtra("categoryId",topicId);
                context.startActivity(intent);
            }
        });
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LearnEngActivity.class);
                String topicId = Integer.toString(topic.getiD());
                intent.putExtra("categoryId",topicId);
                context.startActivity(intent);
            }
        });
        return  row;

    }
}
