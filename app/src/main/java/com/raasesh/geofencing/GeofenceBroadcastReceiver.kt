package com.raasesh.geofencing

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent


class GeofenceBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Geofence triggered", Toast.LENGTH_SHORT).show();
        val notificationHelper = NotificationHelper(context)
        val geofencingEvent = GeofencingEvent.fromIntent(intent)
        if (geofencingEvent?.hasError() == true) {
            Log.d(TAG, "onReceive: Error receiving geofence event...")
            return
        }
        val geofenceList = geofencingEvent?.triggeringGeofences
        if (geofenceList != null) {
            for (geofence in geofenceList) {
                Log.d(TAG, "onReceive: " + geofence.requestId)
            }
        }
        val transitionType = geofencingEvent?.geofenceTransition
        var body = geofenceList?.get(0).toString()
        when (transitionType) {
            Geofence.GEOFENCE_TRANSITION_ENTER -> {
                Toast.makeText(context, "GEOFENCE_TRANSITION_ENTER", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_ENTER", body,
                    GeoFencingMapsActivity::class.java
                )
            }
            Geofence.GEOFENCE_TRANSITION_DWELL -> {
                Toast.makeText(context, "GEOFENCE_TRANSITION_DWELL", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_DWELL", body,
                    GeoFencingMapsActivity::class.java
                )
            }
            Geofence.GEOFENCE_TRANSITION_EXIT -> {
                Toast.makeText(context, "GEOFENCE_TRANSITION_EXIT", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_EXIT", body,
                    GeoFencingMapsActivity::class.java
                )
            }
        }
    }

    companion object {
        private const val TAG = "GeofenceBroadcastReceiver"
    }
}