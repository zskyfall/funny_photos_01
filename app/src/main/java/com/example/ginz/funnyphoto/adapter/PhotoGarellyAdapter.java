package com.example.ginz.funnyphoto.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ginz.funnyphoto.R;
import com.example.ginz.funnyphoto.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class PhotoGarellyAdapter extends RecyclerView.Adapter<PhotoGarellyAdapter.ViewHolder> {

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
//        Bitmap bitmap = decodeSampledBitmapFromPath(new File(photo.getmPath()), 100, 100);
//        holder.mImage.setImageBitmap(bitmap);
        Picasso.with(mContext)
                .load(new File(mPhotos.get(position).getmPath()))
                .placeholder(R.drawable.background_button_login)
                .into(holder.mImage);

        if(photo.ismChecked()){
            holder.mImageChecked.setVisibility(View.VISIBLE);
        } else {
            holder.mImageChecked.setVisibility(View.GONE);
        }
        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIGarelly.onChooserPhoto(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mPhotos != null) {
            return 10;
        }
        return 0;

    }

    private Bitmap decodeFile(String path){
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 4;
            return BitmapFactory.decodeStream(fis, null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



//    private Bitmap decodeFile(String path){
//        File file = new File(path);
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inSampleSize = 4;
//            return BitmapFactory.decodeStream(fis, null, options);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private ImageView mImageChecked;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_choose);
            mImageChecked = itemView.findViewById(R.id.image_checked);
        }
    }

    public static Bitmap decodeSampledBitmapFromPath(File f, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(new FileInputStream(f), null, options);

            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}
