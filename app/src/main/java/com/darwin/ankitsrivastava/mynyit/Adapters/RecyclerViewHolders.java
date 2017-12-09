package com.darwin.ankitsrivastava.mynyit.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.darwin.ankitsrivastava.mynyit.R;

/**
 * Created by ankitsrivastava on 10/25/17.
 */


public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    private static final String TAG = RecyclerViewHolders.class.getSimpleName();

    public TextView profileHeader;

    public TextView profileContent;

    public RecyclerViewHolders(final View itemView) {
        super(itemView);
        profileHeader = (TextView)itemView.findViewById(R.id.heading);
        profileContent = (TextView) itemView.findViewById(R.id.profile_content);
    }
}