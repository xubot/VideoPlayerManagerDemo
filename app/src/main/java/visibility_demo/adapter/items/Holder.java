package visibility_demo.adapter.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.videoplayermanagerdemo.R;
/**
 * Created by danylo.volokh on 09.01.2016.
 */
public class Holder extends RecyclerView.ViewHolder{

    public final TextView positionView;

    public Holder(View itemView) {
        super(itemView);
        positionView = (TextView) itemView.findViewById(R.id.position);
    }
}