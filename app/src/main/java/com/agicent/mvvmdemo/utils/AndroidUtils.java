package com.agicent.mvvmdemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;

import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.agicent.mvvmdemo.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidUtils {

    public static String BY_TAG ="";
    public static String SelectedCollection="";
    public static String SelectedCategor="";
    public static String SelectedItem="";

    public static void getHashKey(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("MY_KEY_HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static Toast toast;

    public static void showLongToast(Context context, String message) {
        if (toast != null) // this will cancel the toast on the screen if one
            // exists
            toast.cancel();

        toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void showToast(Context context, String msg) {
        if (toast != null) // this will cancel the toast on the screen if one
            // exists
            toast.cancel();
        toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);

        toast.show();
    }

    public static void SnackBar(View view, String snackMessage) {

        Snackbar snackbar = Snackbar
                .make(view, snackMessage, 2000);

        snackbar.show();
    }

    public void showCustomSnackBar(View view, String initialMsg, String actionTxt, final String finalMsg) {

        Snackbar snackbar = Snackbar
                .make(view, initialMsg, Snackbar.LENGTH_LONG)
                .setAction(actionTxt, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(view, finalMsg, Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();
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


    public static void showCustomizedSnackBar(View view, String message) {

        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);

        View snackbarLayout = snackbar.getView();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
// Layout must match parent layout type
        lp.setMargins(50, 0, 0, 0);
// Margins relative to the parent view.
// This would be 50 from the top left.
        snackbarLayout.setLayoutParams(lp);
        snackbar.show();
    }

    public static void showSnackBar(View view, String message) {

        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_SHORT);

        snackbar.show();
    }

    /*customized snackBar
        edited by nishu
     */
    public static void showErrorSnackBar(View view, Context context) {

       /* int color = Color.RED;

        Snackbar snackbar = Snackbar.make(view, context.getResources().getString(R.string.no_internet_connection), Snackbar.LENGTH_LONG);

        //.....customization code
        View snView = snackbar.getView();
        TextView textView = snView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();*/
    }


    private static final String TAG = AndroidUtils.class.getSimpleName();

    public static void hideKeyBoard(Context context) {
        InputMethodManager manager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (((Activity) context).getCurrentFocus() != null && ((Activity) context).getCurrentFocus().getWindowToken() != null) {
            manager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showKeyBoard(Context context, EditText editText) {

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

   /* public static void getHashKey(Context context) {

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("MY KEY HASH:",
                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Error :" + e.getMessage() + " at line number : " + e.getStackTrace()[2].getLineNumber());


        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Error :" + e.getMessage() + " at line number : " + e.getStackTrace()[2].getLineNumber());

        }
    }*/

    public static void openPlayStoreLink(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

    public static boolean isValidEmailAddress(String email) {
        Pattern emailPattern = Pattern
                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }


    public static boolean isValidGstNumber(String gst) {
        Pattern gstPattern = Pattern
                .compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$");
        Matcher m = gstPattern.matcher(gst);
        return m.matches();
    }



    public static boolean isValidPhoneno(String phone) {

        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(phone);
        return (m.find() && m.group().equals(phone));
//        Pattern emailPattern = Pattern
//                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
//        Matcher m = emailPattern.matcher(email);
//        return m.matches();
    }

//    public static void openWebView(Context context, WebView webView, String url, final ProgressBar progressBar) {
//        webView.getSettings().setJavaScriptEnabled(true);
//
//        webView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_blakeish));
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(false);
//        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        webView.setWebViewClient(new WebViewClient() {
//
//            public void onPageFinished(WebView webview, String url) {
//                progressBar.setVisibility(View.GONE);
//
//            }
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
//            }
//        });
//        webView.loadUrl(url);
//    }

    public static String convertStringDateFormat(String date, SimpleDateFormat inputFormat, SimpleDateFormat outputFormat) {

        try {

            Date inputDate = inputFormat.parse(date);
            return outputFormat.format(inputDate);

        } catch (ParseException e) {
            Log.e(TAG, "Error :" + e.getMessage() + " at line number : " + e.getStackTrace()[2].getLineNumber());

        }
        return null;
    }

    public static Toast customToast;

    public static double convertKmToMiles(double kilometers) {
        // Assume there are 0.621 miles in a kilometer.
        double miles = kilometers * 0.621;
        return miles;
    }

    public static int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return resources.getDimensionPixelSize(resourceId);
        else
            return (int) Math.ceil((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? 24 : 25) * resources.getDisplayMetrics().density);
    }

    public static int getNavigationBarHeight(Context context, int orientation) {
        Resources resources = context.getResources();

        int id = resources.getIdentifier(
                orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_height_landscape",
                "dimen", "android");
        if (id > 0) {
            return resources.getDimensionPixelSize(id);
        }
        return 0;
    }

    public static boolean isNavigationBarAvailable(Context context) {//this is soft navigation bar which appear at the bottom.

  /*      boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        boolean hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);*/
        boolean hasSoftKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        return (hasSoftKey);
    }

    public static String getTimeZoneId() {
        TimeZone timeZone = TimeZone.getDefault();
        return timeZone.getID();
    }

    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (String activeProcess : processInfo.pkgList) {
                    if (activeProcess.equals(context.getPackageName())) {
                        isInBackground = false;
                    }
                }
            }
        }

        return isInBackground;
    }

    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

//    public static void shareCustomContent(Context context, String message, Bitmap bitmap) {
//
//        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//
//        try {
//            Uri imageUri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(),
//                    bitmap, null, null));
//
//            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.app_name));
//            sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
//            sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
//            sharingIntent.setType("image/*");
//            sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            context.startActivity(Intent.createChooser(sharingIntent, "Share Via!"));
//
//        } catch (NullPointerException e) {
//            Log.e(TAG, "Error :" + e.getMessage() + " at line number : " + e.getStackTrace()[2].getLineNumber());
//
//        }
//
//    }

    private static boolean hasImmersive;
    private static boolean cached = false;

    @SuppressLint("NewApi")
    public static boolean hasImmersive(Context ctx) {

        if (!cached) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                hasImmersive = false;
                cached = true;
                return false;
            }
            Display d = ((WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

            DisplayMetrics realDisplayMetrics = new DisplayMetrics();
            d.getRealMetrics(realDisplayMetrics);

            int realHeight = realDisplayMetrics.heightPixels;
            int realWidth = realDisplayMetrics.widthPixels;

            DisplayMetrics displayMetrics = new DisplayMetrics();
            d.getMetrics(displayMetrics);

            int displayHeight = displayMetrics.heightPixels;
            int displayWidth = displayMetrics.widthPixels;

            hasImmersive = (realWidth > displayWidth) || (realHeight > displayHeight);
            cached = true;
        }

        return hasImmersive;
    }

    public static void shareApp(Context context, String subject, String extraText, String playStoreLink) {

        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            String sAux = "\n" + extraText + "\n\n";
            sAux = sAux + playStoreLink + "\n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            context.startActivity(Intent.createChooser(i, "Choose one"));
        } catch (Exception e) {
            e.toString();
        }
    }

    @SuppressLint("MissingPermission")
    public static Location getLocation(Context context) {
        boolean gps_enabled = false;
        boolean network_enabled = false;
        LocationManager locationManager = null;
        Location gpsLocation = null;
        Location netLocation = null;
        locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        gps_enabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        network_enabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (gps_enabled)
            gpsLocation = locationManager
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (network_enabled)
            netLocation = locationManager
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (gpsLocation != null && netLocation != null) {

            if (gpsLocation.getAccuracy() >= netLocation.getAccuracy())
                return gpsLocation;
            else
                return netLocation;
        } else {
            if (gpsLocation != null) {
                return gpsLocation;
            } else if (netLocation != null) {
                return netLocation;
            }
        }
        return null;
    }

    public static void applyFontsToTextInputLayout(Context context, TextInputLayout[] textInputLayouts) {

        for (TextInputLayout textInputLayout : textInputLayouts) {
            textInputLayout.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/WorkSans-Medium.ttf"));
        }

    }

    public static String getMimeType(String url) {
        String type = null;
        String extension = url.substring(url.lastIndexOf(".") + 1); /*MimeTypeMap.getFileExtensionFromUrl(url);*/

        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }

    public static String sharePostUrl(Context context, String postUrl) {

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        //share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.app_name));
        share.putExtra(Intent.EXTRA_TEXT, postUrl);
        context.startActivity(Intent.createChooser(share, "Share link!"));
        return null;
    }

    public static void OpenEmailClient(Context context, String email,
                                       String subject, String body) throws UnsupportedEncodingException {
        if (subject == null) {
            subject = "";
        }

        if (body == null) {
            body = "";
        }
        String uriText = "mailto:" + email + "?subject="
                + URLEncoder.encode(subject, "UTF-8") + "&body="
                + URLEncoder.encode(body, "UTF-8");

        Uri uri = Uri.parse(uriText);

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        context.startActivity(Intent.createChooser(sendIntent, "Send email"));
    }

    public static void showAlertDialog(){

    }


}
