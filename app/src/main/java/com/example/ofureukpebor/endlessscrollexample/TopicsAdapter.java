package com.example.ofureukpebor.endlessscrollexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ofureukpebor on 2/25/17.
 */

public class TopicsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    ArrayList<Topic> myTopics = new ArrayList<>();

    // Store a member variable for the contacts

    // Pass in the contact array into the constructor
    public TopicsAdapter(ArrayList<Topic> topics) {
        myTopics = topics;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView postTitle;
        public TextView postBody;
        public TextView postDate;
        public TextView postAuthor;

        public ViewHolder(View itemView) {
            super(itemView);

            postTitle = (TextView) itemView.findViewById(R.id.post_title);
            postBody = (TextView) itemView.findViewById(R.id.post_body);
            postDate = (TextView) itemView.findViewById(R.id.post_date);
            postAuthor = (TextView) itemView.findViewById(R.id.post_author);
        }
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        Topic currentTopic = myTopics.get(holder.getAdapterPosition());

        holder.postTitle.setText(currentTopic.postTitle);
        holder.postBody.setText(currentTopic.postBody);
        holder.postAuthor.setText(currentTopic.postAuthorUsername);
        holder.postDate.setText(currentTopic.postDateCreated);
    }

}
