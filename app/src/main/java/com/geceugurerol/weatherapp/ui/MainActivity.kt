package com.geceugurerol.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast
import com.geceugurerol.weatherapp.R
import com.geceugurerol.weatherapp.databinding.ActivityMainBinding

import org.koin.android.viewmodel.ext.android.viewModel
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel by viewModel()

        val txtWeatherDegree = findViewById<TextView>(R.id.txtWeatherDegree)
        val txtWeatherCity = findViewById<TextView>(R.id.txtWeatherCity)
        val txtCloudsAll = findViewById<TextView>(R.id.txtCloudsAll)


        with(mainViewModel){
            feelLike.observe(this@MainActivity, {
                txtWeatherDegree.text = it
            })
           windspeed.observe(this@MainActivity, {
                txtWeatherCity.text = it

            })

            cloudsAll.observe(this@MainActivity,{
                txtCloudsAll.text = it
            })
        }

        mainViewModel.errorWeatherByCityNameResponse.observe(this, {
            Toast.makeText(
                this@MainActivity,
                "Keko $it",
                Toast.LENGTH_SHORT
            ).show()
        })

        txtWeatherDegree.setOnClickListener {
            mainViewModel.getWeatherByCityName("Moscow", "metric")


        }


    }
}