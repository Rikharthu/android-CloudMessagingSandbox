package com.example.uberv.cloudmessagingsandbox.notifications;

import com.example.uberv.cloudmessagingsandbox.Navigator;
import com.example.uberv.cloudmessagingsandbox.NotificationData;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import timber.log.Timber;

/*
{
   "to": "e2qT5Oqsf5s:APA91bHD6Khexs3jJxl_qwbeuCcT8KS31ga8MA0TUxKLdIXRrXhiy1qyq31VNdqhRFdHiIN4wiZCRjOMDcWvfwpcsWFChveLWR7YeuQSVwkgvWwWporMjPW0fWjqHkARMi-d3yxbxEbR",
   "data":{
     "action":"ACTION_PLAY",
     "url":"http://www.image-dragons.com/thunder",
     "data":"Image Dragons - Thunder"
   },
   "priority":10
 }
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String KEY_NOTIFICATION_DATA = "notification_data";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Timber.d("From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Timber.d("Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
            } else {
                // Handle message within 10 seconds
//                handleNow();
            }

        } else {
            Timber.d("Message doesn't contain any data payload");
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Timber.d("Message Notification Body: " + remoteMessage.getNotification().getBody());
        } else {
            Timber.d("Message Notification Body is null");
        }

        Navigator.handleNotification(new NotificationData(remoteMessage.getData()), this.getBaseContext());
    }
}
