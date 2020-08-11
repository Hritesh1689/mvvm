package com.agicent.mvvmdemo.utils;

/**
 * Created by nishuSingh 12-09-2018
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class AppUtils {

    public static final String TAG = AppUtils.class.getName();

    public static boolean isCartCountNeedToShow=false;


    // Toolbar with both button with custom icon

    // Toolbar with both button with custom icon For Fragment

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void launchActivity(Context context,Class<?> classes){
        context.startActivity(new Intent(context,classes));
    }

    //edited by nishu
    /*public static String getSqliteFormattedDateTime(Context context, Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                context.getResources().getString(R.string.sqlite_date_time_format)
                , Locale.ENGLISH);

        return simpleDateFormat.format(date.getTime());
    }*/

    /**
     * Checking is connected to Internet
     */
    public static boolean isNetworkAvailable(Context context){

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();

            if(networkInfo!=null && networkInfo.isConnected()){
                return true;
            }

        }catch (Exception e){
            Log.e(TAG,"unable to check is internet Available",e);
        }
        return false;
    }


    public static File getParentDirectory(Context context) {
        return context.getExternalFilesDir(null);

    }




    /*public static String getAlbumFolderPath() {

        return ConstantUtils.ALBUM_FOLDER;
    }*/


    /*public static String getImagesPath(String movieName) {

        return ConstantUtils.ALBUM_FOLDER
                + File.separator + movieName + ConstantUtils.IMAGE_FORMAT;
    }*/


  /*  public static String getSqliteFormattedDate(Context context, Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                context.getResources().getString(R.string.sqlite_date_format)
                , Locale.ENGLISH);

        return simpleDateFormat.format(date.getTime());
    }*/

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap centerCropBitmap(Bitmap srcBmp){

       Bitmap dstBmp;

        if (srcBmp.getWidth() >= srcBmp.getHeight()){

            dstBmp = Bitmap.createBitmap(
                    srcBmp,
                    srcBmp.getWidth()/2 - srcBmp.getHeight()/2,
                    0,
                    srcBmp.getHeight(),
                    srcBmp.getHeight()
            );

        }else{

            dstBmp = Bitmap.createBitmap(
                    srcBmp,
                    0,
                    srcBmp.getHeight()/2 - srcBmp.getWidth()/2,
                    srcBmp.getWidth(),
                    srcBmp.getWidth()
            );
        }

        return dstBmp;
    }

    public static int getWeekNo(String startDate, String imgDate){
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int daysBetween = 0;
        try {
            Date dateBefore = simpleDateFormat.parse(startDate);
            Date dateAfter = simpleDateFormat.parse(imgDate);
            long difference = dateAfter.getTime() - dateBefore.getTime();
             daysBetween = (int)(difference / (1000*60*60*24));
             daysBetween=daysBetween/7;
             daysBetween=daysBetween+1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return daysBetween;
    }

    public static File compressFile(File file) {
        try {

            // BitmapFactory options to downsize the image
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.close();
            inputStream = null;

            int originalWidth = options.outWidth;
            int originalHeight = options.outHeight;

            if (originalWidth > 0) {

                int reqWidth = 720;
                int reqHeight = (reqWidth * originalHeight) / originalWidth;
                if (reqHeight >= 1280)
                    reqHeight = 1280;
                Log.d("new image ", "getDropboxIMGSize: " + reqHeight + "    " + reqWidth);
                // decode full image pre-resized
                inputStream = new FileInputStream(file);
                options = new BitmapFactory.Options();

                // calc rought re-size (this is no exact resize)
                options.inSampleSize = Math.max(originalWidth / reqWidth, originalHeight / reqHeight);
                // decode full image
                Bitmap roughBitmap = BitmapFactory.decodeStream(inputStream, null, options);

                // calc exact destination size
                Matrix m = new Matrix();
                RectF inRect = new RectF(0, 0, roughBitmap.getWidth(), roughBitmap.getHeight());
                RectF outRect = new RectF(0, 0, reqWidth, reqHeight);
                m.setRectToRect(inRect, outRect, Matrix.ScaleToFit.CENTER);
                float[] values = new float[9];
                m.getValues(values);

                // resize bitmap
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(roughBitmap,
                        (int) (roughBitmap.getWidth() * values[0]), (int) (roughBitmap.getHeight() * values[4]),
                        true);

                file.createNewFile();

                FileOutputStream out = new FileOutputStream(file);
                resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 70, out);

            }

            return file;

        } catch (IOException e) {
            Log.e("Image", e.getMessage(), e);
            return null;
        }
    }

    public static void action_delete_1(String path) {
        try {
            File dir = new File(path);
            DeleteRecursive(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles()) {
                DeleteRecursive(child);
            }
        boolean i = fileOrDirectory.delete();
        Log.e("ddd","sdd");
    }

    //edited by nishu
   /* public static String getSqliteFormattedDateTime(Context context, Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                context.getResources().getString(R.string.sqlite_date_time_format)
                , Locale.ENGLISH);

        return simpleDateFormat.format(date.getTime());
    }*/
public static String getTimeZoneId(){
  TimeZone timeZone= TimeZone.getDefault();
        return timeZone.getID();
}

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Error :" + e.getMessage() + " at line number : " + e.getStackTrace()[2].getLineNumber());

        }

        return "";
    }


}
