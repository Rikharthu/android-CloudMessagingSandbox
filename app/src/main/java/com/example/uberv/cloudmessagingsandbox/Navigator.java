package com.example.uberv.cloudmessagingsandbox;

import android.content.Context;
import android.content.Intent;

import static com.example.uberv.cloudmessagingsandbox.notifications.MyFirebaseMessagingService.KEY_NOTIFICATION_DATA;

public abstract class Navigator {

    public static void handleNotification(NotificationData data, Context context) {
        switch (data.getAction()) {
            case "ACTION_PLAY":
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra(KEY_NOTIFICATION_DATA, data);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
                        Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
                break;
            default:

        }
    }
}
