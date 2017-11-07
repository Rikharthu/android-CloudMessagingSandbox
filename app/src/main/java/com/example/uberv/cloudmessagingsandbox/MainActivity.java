package com.example.uberv.cloudmessagingsandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.uberv.cloudmessagingsandbox.notifications.MyFirebaseMessagingService;
import com.google.firebase.iid.FirebaseInstanceId;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textview);

        String fcmToken = FirebaseInstanceId.getInstance().getToken();
        Timber.d("fcm token: " + fcmToken);

        printIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        printIntent(intent);
    }

    private void printIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Timber.d("%s : %s", key, extras.getString(key));
            }
            NotificationData data = intent.getParcelableExtra(MyFirebaseMessagingService.KEY_NOTIFICATION_DATA);
            if (data != null) {
                Timber.d(data.toString());
                mTextView.setText(data.toString());
            }
        }
    }
}
