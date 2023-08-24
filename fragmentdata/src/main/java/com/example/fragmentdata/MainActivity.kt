package com.example.fragmentdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding

   private val fragmentA = FragmentA()
   private val fragmentB = FragmentB()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().replace(
            R.id.frameA, fragmentA
        ).commit()

        supportFragmentManager.beginTransaction().replace(
            R.id.frameB, fragmentB
        ).commit()




    }



}