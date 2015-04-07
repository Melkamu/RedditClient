package com.melkam.redditclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.melkam.redditclient.R;
import com.melkam.redditclient.model.Topic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Adapts list of Topics
 *
 * @author Melkamu A.
 */
public class TopTopicsAdapter extends RecyclerView.Adapter<TopTopicsAdapter.TopTopicsViewHolder> {

    private Context mContext;
    private List<Topic> mTopics;
    private ItemClickListener mItemClickListener;

    protected static class TopTopicsViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.topic_img_iv)
        ImageView mTopicImgIv;
        @InjectView(R.id.topic_author_tv)
        TextView mTopicAuthorTv;
        @InjectView(R.id.topic_score_tv)
        TextView mTopicScoreTv;
        @InjectView(R.id.topic_title_tv)
        TextView mTopicTitleTv;

        public TopTopicsViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

    public interface ItemClickListener {
        public void onItemClick(int position);
    }

    public TopTopicsAdapter(Context context) {
        mContext = context;
        mTopics = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    @Override
    public TopTopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topics_list_item,
                parent, false);
        TopTopicsViewHolder messagesViewHolder = new TopTopicsViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(TopTopicsViewHolder holder, final int position) {
        Topic topic = mTopics.get(position);

        String thumbnail = topic.getThumbnail();

        if (thumbnail != null && thumbnail != "") {
            Picasso.with(mContext).load(topic.getThumbnail())
                    .into(holder.mTopicImgIv);
        }

        holder.mTopicAuthorTv.setText(topic.getAuthor());
        holder.mTopicScoreTv.setText(String.valueOf(topic.getScore()));
        holder.mTopicTitleTv.setText(topic.getTitle());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setTopics(List<Topic> topics) {
        mTopics = topics;
        notifyDataSetChanged();
    }

}