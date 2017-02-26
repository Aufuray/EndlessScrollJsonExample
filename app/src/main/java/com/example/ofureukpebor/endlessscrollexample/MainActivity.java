package com.example.ofureukpebor.endlessscrollexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int size;

    ArrayList<Topic> communityTopics = new ArrayList<>();
    ArrayList<Topic> moreCommunityTopics = new ArrayList<>();

    String postId;
    String postTitle;
    String postBody;
    String postAuthor;
    String postDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_topics);
        final ArrayList<Topic> allTopics = Topic.fetchTopicsList(15, 0);
        final TopicsAdapter topicsAdapter = new TopicsAdapter(allTopics);

        recyclerView.setAdapter(topicsAdapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                ArrayList<Topic> moreContacts = Topic.fetchTopicsList(10, page);

                size = topicsAdapter.getItemCount();
                allTopics.addAll(moreContacts);

                view.post(new Runnable() {
                    @Override
                    public void run() {
                        topicsAdapter.notifyItemRangeInserted(size, allTopics.size() - 1);
                    }
                });
            }
        };

        recyclerView.addOnScrollListener(scrollListener);
    }

    //parse and format posts
    private ArrayList<Topic> parseCommunityPostJson(JSONArray response){
        // response holds the communityPosts
        ArrayList<Topic> communityTopics = new ArrayList<>();
        if (response != null && response.length() > 0) {

            for (int i = 0; i < response.length(); i++) { //loop through all posts
                try {
                    JSONObject currentPost = response.getJSONObject(i);

                    postId = currentPost.getString("id");
                    postTitle = currentPost.getString("title");
                    postBody = currentPost.getString("body");
                    postAuthor = currentPost.getString("topic_by");
                    postDate = currentPost.getString("date_created");

                    Topic topic = new Topic();
                    topic.setPostId(postId);
                    topic.setPostTitle(postTitle);
                    topic.setPostBody(postBody);
                    topic.setPostDateCreated(postDate);
                    topic.setPostAuthorUsername(postAuthor);

                    communityTopics.add(topic);
                } catch (JSONException e) {
                }
            }
        }
        return communityTopics;
    }

}
