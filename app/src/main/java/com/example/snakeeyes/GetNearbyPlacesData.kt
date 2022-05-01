package com.example.snakeeyes

import android.os.AsyncTask
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class GetNearbyPlacesData : AsyncTask<Any?, String?, String?>() {
    var googlePlacesData: String? = null
    var googleMap: GoogleMap? = null
    var url: String? = null
    protected override fun doInBackground(vararg p0: Any?): String? {
        googleMap = p0[0] as GoogleMap
        url = p0[1] as String
        val downloadUrl = DownloadUrl()
        try {
            googlePlacesData = downloadUrl.readUrl(url)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return googlePlacesData
    }

    override fun onPostExecute(s: String?) {
        try {
            val parentObject = JSONObject(s)
            val resultArray = parentObject.getJSONArray("results")
            for (i in 0 until resultArray.length()) {
                val jsonObject = resultArray.getJSONObject(i)
                val locationObj = jsonObject.getJSONObject("geometry").getJSONObject("location")
                val latitude = locationObj.getString("lat")
                val longitude = locationObj.getString("lng")
                val nameObject = resultArray.getJSONObject(i)
                val name = nameObject.getString("name")
                val latLng = LatLng(latitude.toDouble(), longitude.toDouble())
                val markerOptions = MarkerOptions()
                markerOptions.title(name)
                markerOptions.position(latLng)
                googleMap!!.addMarker(markerOptions)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}