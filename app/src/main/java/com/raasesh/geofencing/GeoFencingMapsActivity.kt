package com.raasesh.geofencing

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.raasesh.geofencing.databinding.ActivityGeoFencingMapsBinding


class GeoFencingMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityGeoFencingMapsBinding
    private lateinit var geofencingClient: GeofencingClient
    private lateinit var locationDetailsList: ArrayList<LocationDetails>
    private val GEOFENCE_RADIUS_IN_METERS: Float = 100F
    private var geofenceHelper: GeofenceHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGeoFencingMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        geofencingClient = LocationServices.getGeofencingClient(this)
        geofenceHelper =  GeofenceHelper(this);

        enableUserLocation()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingPermission")
    fun enableUserLocation() {
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    false
                ) -> {
                    // Precise location access granted.
                    mMap.isMyLocationEnabled = true
                    addLocations()
                }
                permissions.getOrDefault(
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    false
                ) -> {
                    // Only approximate location access granted.
                    mMap.isMyLocationEnabled = true
                    addLocations()

                }
                else -> {
                    // No location access granted.
                    mMap.isMyLocationEnabled = false
                }
            }
        }

        /*Checking whether your app already has the permissions, and whether your app needs to show a permission rationale dialog.*/
        locationPermissionRequest.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    private fun addLocations() {
        locationDetailsList = ArrayList()
        locationDetailsList.add(
            LocationDetails(
                12.953013054035946,
                77.5417514266668,
                "1",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.95428866232216,
                77.5438757362066,
                "2",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.95558517552543,
                77.54565672299249,
                "3",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.956442543452548,
                77.54752354046686,
                "4",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.95675621390793,
                77.54919723889215,
                "5",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.957069883968225,
                77.55112842938287,
                "6",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.957711349517467,
                77.55308710458465,
                "7",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.958464154110917,
                77.55514704110809,
                "8",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.959656090062529,
                77.5559409749765,
                "9",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.960814324441305,
                77.5574167738546,
                "10",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.961253455257907,
                77.5592192183126,
                "11",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.96156308861349,
                77.56126500049922,
                "12",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.961814019848779,
                77.56308890262935,
                "13",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.962775920574138,
                77.56592131534907,
                "14",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.963340512746937,
                77.5676379291186,
                "15",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.96411114676894,
                77.56951526792183,
                "16",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.964382986146292,
                77.5717254081501,
                "17",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.964584624077109,
                77.57370388966811,
                "18",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.964542802687657,
                77.57591402989638,
                "19",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.963795326167373,
                77.57798997552734,
                "20",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.96358621848664,
                77.58015720041138,
                "21",
                GEOFENCE_RADIUS_IN_METERS
            )
        )
        locationDetailsList.add(
            LocationDetails(
                12.963481664580394,
                77.58189527185303,
                "22",
                GEOFENCE_RADIUS_IN_METERS
            )
        )

        addGeoFencesList(locationDetailsList)

    }

    private fun addGeoFencesList(locationDetailsList: ArrayList<LocationDetails>) {
        for (location in locationDetailsList) {
            addGeofence(location)
            addMarker(location);
            addCircle(location);
        }

    }

    @SuppressLint("MissingPermission")
    private fun addGeofence(location: LocationDetails) {
        var latLng = LatLng(location.latitude, location.longitude)
        val geofence = geofenceHelper?.getGeofence(
            location.key,
            latLng,
            location.radius,
            Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_DWELL or Geofence.GEOFENCE_TRANSITION_EXIT
        )
        val geofencingRequest = geofenceHelper?.getGeofencingRequest(geofence)
        val pendingIntent = geofenceHelper?.getPendingIntentVal()
        geofencingRequest?.let {
            geofencingClient.addGeofences(it, pendingIntent!!).addOnSuccessListener {
                Log.d(
                    TAG,
                    "onSuccess: Added..."
                )
            }.addOnFailureListener { e ->
                val errorMessage = geofenceHelper?.getErrorString(e)
                Log.d(TAG, "onFailure: $e")
            }
        }
    }

    private fun addMarker(location: LocationDetails) {
        var latLng = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions().position(latLng)
        mMap.addMarker(markerOptions)
    }

    private fun addCircle(location: LocationDetails) {
        var latLng = LatLng(location.latitude, location.longitude)
        val circleOptions = CircleOptions()
        circleOptions.center(latLng)
        circleOptions.radius(location.radius.toDouble())
        circleOptions.strokeColor(Color.argb(255, 0, 255, 0))
        circleOptions.fillColor(Color.argb(64, 0, 255, 0))
        circleOptions.strokeWidth(4f)
        mMap.addCircle(circleOptions)
    }

    companion object {
        private const val TAG = "GeoFencingMapsActivity"
    }
}