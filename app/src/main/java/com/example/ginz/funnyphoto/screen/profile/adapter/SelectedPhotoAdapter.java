package com.example.ginz.funnyphoto.screen.profile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ginz.funnyphoto.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class SelectedPhotoAdapter extends RecyclerView.Adapter<SelectedPhotoAdapter.ViewHolder> {
    private static Context mContext;
    private static List<String> mSelectedPhoto;
    private static IGarelly mIGarelly;

    public SelectedPhotoAdapter(Context montext, List<String> selectedPhoto, IGarelly iGarelly) {
        this.mContext = montext;
        this.mSelectedPhoto = selectedPhoto;
        this.mIGarelly = iGarelly;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_selected_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return mSelectedPhoto != null ? mSelectedPhoto.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageSelectedPhoto;
        private ImageView mImageDelete;
        public ViewHolder(View itemView) {
            super(itemView);

            mImageSelectedPhoto = itemView.findViewById(R.id.image_selected_photo);
            mImageDelete = itemView.findViewById(R.id.image_delete);
        }

        public void bindView(final int position) {
            Picasso.with(mContext).load(new File(mSelectedPhoto.get(position)))
                    .into(mImageSelectedPhoto);
            mImageDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIGarelly.onDeletePhoto(position);
                }
            });
        }
    }
}
