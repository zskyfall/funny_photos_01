package com.example.ginz.funnyphoto.screen.profile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class PhotoGarellyAdapter extends RecyclerView.Adapter<PhotoGarellyAdapter.ViewHolder> {
    private static final int SAMPLE_SIZE = 4;
    private Context mContext;
    private List<Photo> mPhotos;
    private IGarelly mIGarelly;

    public PhotoGarellyAdapter(Context context, List<Photo> photos, IGarelly iGarelly) {
        this.mContext = context;
        this.mPhotos = photos;
        this.mIGarelly = iGarelly;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_garelly_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Photo photo = mPhotos.get(position);

        holder.bindView(photo, position);
    }

    @Override
    public int getItemCount() {
        return mPhotos != null ? mPhotos.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private ImageView mImageChecked;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_choose);
            mImageChecked = itemView.findViewById(R.id.image_checked);
        }

        public void bindView(Photo photo, final int position) {
            Picasso.with(mContext)
                    .load(new File(photo.getPath()))
                    .placeholder(R.drawable.background_button_login)
                    .into(mImage);

            if(photo.isChecked()){
                mImageChecked.setVisibility(View.VISIBLE);
            } else {
                mImageChecked.setVisibility(View.GONE);
            }
            mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIGarelly.onChooserPhoto(position);
                }
            });
        }
    }
}
