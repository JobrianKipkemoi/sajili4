package com.example.sajili3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.sajili3.adapters.CourseUnitAdapter
import com.example.sajili3.models.CourseUnit
import org.json.JSONArray

class Registration : AppCompatActivity() {
    private val TAG = "RGISTRATION_ACTIVITY_TAG"
    private lateinit var requestQueue: RequestQueue
    private val courseUnits = mutableListOf<CourseUnit>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseUnitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        requestQueue = Volley.newRequestQueue(this)
        val url = "http://localhost:8080/allunits"

        recyclerView = findViewById(R.id.mainRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CourseUnitAdapter(courseUnits)
        recyclerView.adapter = adapter

        fetchAvailableUnits(url)

    }

    private fun fetchAvailableUnits(url: String) {
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response: JSONArray ->

                courseUnits.clear()

                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)

                    val unitCode = jsonObject.getString("UnitCode")
                    val unitTitle = jsonObject.getString("UnitTitle")
                    val lecturer = jsonObject.getString("Lecturer")
                    val isAvailable = jsonObject.getBoolean("IsAvailable")

                    val courseUnit = CourseUnit(unitCode, unitTitle, lecturer, isAvailable)
                    courseUnits.add(courseUnit)
//                    adapter.notifyItemInserted(i)
                }

                adapter.notifyDataSetChanged()
            },
            { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.i(TAG, "fetchAvailableUnits Error: ${error.message}" )
            }
        )

        // Optionally set a timeout and disable caching
        jsonArrayRequest.setShouldCache(false)
        jsonArrayRequest.retryPolicy = com.android.volley.DefaultRetryPolicy(
            5000,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )

        requestQueue.add(jsonArrayRequest)
    }
}