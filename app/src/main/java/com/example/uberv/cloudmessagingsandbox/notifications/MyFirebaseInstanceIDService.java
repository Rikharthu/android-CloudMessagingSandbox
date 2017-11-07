package com.example.uberv.cloudmessagingsandbox.notifications;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import timber.log.Timber;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    /**
     * The onTokenRefresh callback fires whenever a new token is generated,
     * so calling getToken in its context ensures that you are accessing a current,
     * available registration token. FirebaseInstanceID.getToken() returns null if
     * the token has not yet been generated.
     */
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Timber.d("Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        Timber.d("Sending refresh token");
    }
}
