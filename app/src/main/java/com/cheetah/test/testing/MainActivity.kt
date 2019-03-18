package com.cheetah.test.testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //using the navigation architecture component, this will navigate to customerCartFragment
        setContentView(R.layout.activity_main)
    }
}
