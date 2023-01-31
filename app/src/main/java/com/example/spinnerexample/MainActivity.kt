package com.example.spinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        //If you want to use list of entries from code but not from strings.xml you should use:
        val spinnerList = listOf("a","b","c","d")
        val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerList)
        activityMainBinding.spinner.adapter = adapter



        //To make code below working just comment  3 lines above

        //That's enough for making spinner, but if you want a spinner with dynamical (changeable from code inputs) look above
        activityMainBinding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?){}
        }
    }
}