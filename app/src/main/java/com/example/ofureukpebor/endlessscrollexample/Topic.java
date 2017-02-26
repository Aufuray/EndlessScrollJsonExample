package com.example.ofureukpebor.endlessscrollexample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ofureukpebor on 2/25/17.
 */
public class Topic {

        public String postId;
        public String postTitle;
        public String postBody;
        public String postDateCreated;
        public String postAuthorUsername;

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        public String getPostBody() {
            return postBody;
        }

        public void setPostBody(String postBody) {
            this.postBody = postBody;
        }


        public String getPostDateCreated() {
            return postDateCreated;
        }

        public void setPostDateCreated(String postDateCreated) {
            this.postDateCreated = postDateCreated;
        }

        public String getPostAuthorUsername() {
            return postAuthorUsername;
        }

        public void setPostAuthorUsername(String postAuthorUsername) {
            this.postAuthorUsername = postAuthorUsername;
        }


        public static ArrayList<Topic> fetchTopicsList(int number, int offset) {
            ArrayList<Topic> topics = new ArrayList<Topic>();

            return topics;
        }

//        public JSONArray jsonTopics(){
//            JSONArray arrayTopics = new JSONArray();
//            JSONObject objTopics;
//
//        }
    }


