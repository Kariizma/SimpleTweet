package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>
{
    // Pass in context and list of tweets
    private Context context;
    private List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets)
    {
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
       View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
       return new ViewHolder(view);
    }

    // bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        Tweet tweet = tweets.get(i);
        viewHolder.tvBody.setText(tweet.body);
        viewHolder.tvScreenName.setText(tweet.user.screenName);
        Glide.with(context).load(tweet.user.profileImageUrl).into(viewHolder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void clear()
    {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetsList)
    {
        tweets.addAll(tweetsList);
        notifyDataSetChanged();
    }

    //Define the ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView ivProfileImage;
        public TextView tvBody;
        public TextView tvScreenName;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
        }
    }
}
