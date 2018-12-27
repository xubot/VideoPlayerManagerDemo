package video_list_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.videoplayermanagerdemo.R;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

import java.util.List;

import video_list_demo.adapter.items.BaseVideoItem;

/**
 * Created by danylo.volokh on 9/20/2015.
 */
public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final VideoPlayerManager mVideoPlayerManager;
    private final List<BaseVideoItem> mList;
    private final Context mContext;

    public VideoRecyclerViewAdapter(VideoPlayerManager videoPlayerManager, Context context, List<BaseVideoItem> list){
        mVideoPlayerManager = videoPlayerManager;
        mContext = context;
        mList = list;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        BaseVideoItem videoItem = mList.get(position);
        View resultView = videoItem.createView(viewGroup, mContext.getResources().getDisplayMetrics().widthPixels);
        return new VideoViewHolder(resultView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseVideoItem videoItem = mList.get(position);
        videoItem.update(position, ((VideoViewHolder)holder), mVideoPlayerManager);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{

        public final VideoPlayerView mPlayer;
        public final TextView mTitle;
        public final ImageView mCover;
        public final TextView mVisibilityPercents;

        public VideoViewHolder(View view) {
            super(view);
            mPlayer = (VideoPlayerView) view.findViewById(R.id.player);
            mTitle = (TextView) view.findViewById(R.id.title);
            mCover = (ImageView) view.findViewById(R.id.cover);
            mVisibilityPercents = (TextView) view.findViewById(R.id.visibility_percents);
        }
    }

}
