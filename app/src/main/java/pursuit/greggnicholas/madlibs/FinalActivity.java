package pursuit.greggnicholas.madlibs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class FinalActivity extends AppCompatActivity {

   // private EditText inWord1, inWord2, inWord3, inWord4, inWord5, inWord6, inWord7, inWord8;
private TextView storyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
//
//        Intent intent = getIntent();
//        String word1 = intent.getStringExtra(Main2Activity.)
//        setRandomBackgroundColor();

    //    inWord1 = (EditText) findViewById(R.id.word1);
//        inWord2 = (EditText) findViewById(word2);
//        inWord3 = (EditText) findViewById(word3);
//        inWord4 = (EditText) findViewById(word4);
//        inWord5 = (EditText) findViewById(word5);
//        inWord6 = (EditText) findViewById(word6);
//        inWord7 = (EditText) findViewById(word7);
//        inWord8 = (EditText) findViewById(word8);



    }

    private void setRandomBackgroundColor() {
        Random rand = new Random();
        int cl = rand.nextInt();
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(cl);
    }

    class OrientationUtils {
        private OrientationUtils() {}

        /** Locks the device window in landscape mode. */
        public void lockOrientationLandscape(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        /** Locks the device window in portrait mode. */
        public void lockOrientationPortrait(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        /** Locks the device window in actual screen mode. */
        public void lockOrientation(Activity activity) {
            final int orientation = activity.getResources().getConfiguration().orientation;
            final int rotation = ((WindowManager) activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();

            // Copied from Android docs, since we don't have these values in Froyo 2.2
            int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
            int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;

            // Build.VERSION.SDK_INT <= Build.VERSION_CODES.FROYO

            if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90){
                if (orientation == Configuration.ORIENTATION_PORTRAIT){
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
            else if (rotation == Surface.ROTATION_180 || rotation == Surface.ROTATION_270)
            {
                if (orientation == Configuration.ORIENTATION_PORTRAIT){
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                }
                else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                }
            }
        }

        /** Unlocks the device window in user defined screen mode. */
        public void unlockOrientation(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        }

    }
}
