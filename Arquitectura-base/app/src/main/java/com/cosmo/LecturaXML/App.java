package com.cosmo.LecturaXML;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by Superadmin1 on 07/11/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        settingOneSignal();


    }

    private void settingOneSignal(){
        OneSignal.startInit(this)
        .autoPromptLocation(false)
        .setNotificationReceivedHandler(new NotificationReceiverHandler())
        .setNotificationOpenedHandler(new NotificationOpenedHandler())
        .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
        .unsubscribeWhenNotificationsAreDisabled(true)
        .init();
    }

    private class NotificationReceiverHandler implements OneSignal.NotificationReceivedHandler {

        @Override
        public void notificationReceived(OSNotification notification) {
            JSONObject data = notification.payload.additionalData;
            String notifcationID = notification.payload.notificationID;
            String titile = notification.payload.title;

            Log.e("ONESIGNAL", "NotificationID" + notifcationID);

            if (data != null) {
                String customKey = data.optString("customKey", null);
                if (customKey != null) {
                    Log.i("ONESIGNAL","Token customKey"+customKey );

                }
            }
        }
    }

    private class NotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            OSNotificationAction.ActionType actionType = result.action.type;
            if (actionType == OSNotificationAction.ActionType.ActionTaken) {
                Log.i("ONESIGNAL","Botón presionado"+actionType );
                Toast.makeText(App.this, "Jasmany Exitoso !!!", Toast.LENGTH_LONG).show();
            }
        }
    }


}
