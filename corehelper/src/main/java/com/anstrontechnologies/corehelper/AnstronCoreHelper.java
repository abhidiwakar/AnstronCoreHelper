package com.anstrontechnologies.corehelper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.text.format.DateFormat;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class AnstronCoreHelper {
    private Context context;

    public AnstronCoreHelper(Context context) {
        this.context = context;
    }

    /**
     * Generate random number between min and max given by user.
     *
     * @param min to define minimum number
     * @param max to define maximum number
     * @return Random number between min and max given by user.
     * @author Anstron Technologies
     *
     */
    public int getRandomNumber(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Creates alert box to notify user.
     *
     * @param title is the title of the alert box.
     * @param message is the message which will be shown to the user.
     * @param positiveText is the text of positive button in alert box.
     * @param negativeText is the text of negative button in alert box.
     * @param positiveListener is the click listener of positive button.
     * @param negativeListener is the click listener of negative button.
     * @param dismissListener is the dismiss listener of alert box.
     * @author Anstron Technologies
     *
     */
    public void createAlert(String title, String message, String positiveText, String negativeText, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener, DialogInterface.OnDismissListener dismissListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, positiveListener)
                .setNegativeButton(negativeText, negativeListener)
                .setOnDismissListener(dismissListener)
                .create().show();
    }

    /**
     * Creates alert box to notify user without dismiss listener.
     *
     * @param title is the title of the alert box.
     * @param message is the message which will be shown to the user.
     * @param positiveText is the text of positive button in alert box.
     * @param negativeText is the text of negative button in alert box.
     * @param positiveListener is the click listener of positive button.
     * @param negativeListener is the click listener of negative button.
     * @author Anstron Technologies
     *
     */
    public void createAlert(String title, String message, String positiveText, String negativeText, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, positiveListener)
                .setNegativeButton(negativeText, negativeListener)
                .create().show();
    }

    /**
     * Creates alert box to notify user without negative text, negative listener and dismiss listener.
     *
     * @param title is the title of the alert box.
     * @param message is the message which will be shown to the user.
     * @param positiveText is the text of positive button in alert box.
     * @param positiveListener is the click listener of positive button.
     * @author Anstron Technologies
     *
     */
    public void createAlert(String title, String message, String positiveText, DialogInterface.OnClickListener positiveListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, positiveListener)
                .create().show();
    }

    /**
     * Creates toast message with short length.
     *
     *  @param message will be shown to user.
     *  @author Anstron Technologies
     *
     */

    public void createToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Creates toast message with long length if "lengthLong" is true.
     *
     * @param message will be shown to user.
     * @param lengthLong will be used to shown toast with LENGTH_LONG if true else LENGTH_SHORT.
     * @author Anstron Technologies
     *
     */
    public void createToast(String message, boolean lengthLong){
        if (lengthLong)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets file name from uri.
     *
     * @param uri will be used to get file name.
     * @deprecated 10.0
     * @author Anstron Technologies
     * @return the file name.
     *
     */

    public String getFileNameFromUri(Uri uri) {
        String result = null;
        if (uri.getScheme() != null){
            if (uri.getScheme().equals("content")) {
                try (Cursor cursor = context.getContentResolver().query(uri, null, null, null, null)) {
                    if (cursor != null && cursor.moveToFirst()) {
                        result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    }
                }
            }
            if (result == null) {
                result = uri.getPath();
                int cut = result.lastIndexOf('/');
                if (cut != -1) {
                    result = result.substring(cut + 1);
                }
            }
        }
        return result;
    }

    /**
     * Get the file size in a readable string.
     *
     * @param size To get file size in readable form
     * @return file size in KB, MB or GB
     * @author Anstron Technologies
     */
    public static String getReadableFileSize(int size) {
        final int BYTES_IN_KILOBYTES = 1024;
        final DecimalFormat dec = new DecimalFormat("###.#");
        final String KILOBYTES = " KB";
        final String MEGABYTES = " MB";
        final String GIGABYTES = " GB";
        float fileSize = 0;
        String suffix = KILOBYTES;

        if (size > BYTES_IN_KILOBYTES) {
            fileSize = size / BYTES_IN_KILOBYTES;
            if (fileSize > BYTES_IN_KILOBYTES) {
                fileSize = fileSize / BYTES_IN_KILOBYTES;
                if (fileSize > BYTES_IN_KILOBYTES) {
                    fileSize = fileSize / BYTES_IN_KILOBYTES;
                    suffix = GIGABYTES;
                } else {
                    suffix = MEGABYTES;
                }
            }
        }
        return dec.format(fileSize) + suffix;
    }

    /**
     * Get timestamp
     * @return timestamp
     * @author Anstron Technologies
     *
     */
    public String getTimeStamp(){
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
    }

    /**
     * Get current date and time in 12 hrs format
     * @return current date and time
     * @author Anstron Technologies
     *
     */
    public String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault());
        return sdf.format(new Date());
    }

    /**
     * Get current date and time in 12 hr format
     * @param format if 24 then time will be returned in 24 hrs format.
     * @return current date and time
     * @author Anstron Technologies
     *
     */
    public String getDateTime(int format){
        if (format == 24){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            return sdf.format(new Date());
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault());
            return sdf.format(new Date());
        }
    }

    /**
     * Convert first letter from lower case to uppercase.
     * @param string to convert first letter from lower to upper case.
     * @return string
     * @author Anstron Technologies
     *
     */
    public String firstUpperCase(String string){
        String firstLetter = String.valueOf(string.charAt(0)).toUpperCase();
        String remainingLetters = string.substring(1);
        return firstLetter+remainingLetters;
    }

    /**
     * Get file size from uri
     * @param uri to get file size
     * @return file size
     * @deprecated 10.0
     * @author Anstron Technologies
     *
     */
    public String getFileSizeFromUri(Uri uri) {
        String result = null;
        if (uri.getScheme() != null){
            if (uri.getScheme().equals("content")) {
                try (Cursor cursor = context.getContentResolver().query(uri, null, null, null, null)) {
                    if (cursor != null && cursor.moveToFirst()) {
                        result = cursor.getString(cursor.getColumnIndex(OpenableColumns.SIZE));
                    }
                }
            }
            if (result == null) {
                result = uri.getPath();
                int cut = result.lastIndexOf('/');
                if (cut != -1) {
                    result = result.substring(cut + 1);
                }
            }
        }
        return result;
    }

    /**
     * Convert timestamp to human-readable date time in 12 hrs format.
     * @param time to convert timestamp
     * @return date and time in 12 hrs format.
     * @author Anstron Technologies
     *
     */
    public String timestampToDateTime(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        return DateFormat.format("yyyy-MM-dd HH:mm a", cal).toString();
    }
}
