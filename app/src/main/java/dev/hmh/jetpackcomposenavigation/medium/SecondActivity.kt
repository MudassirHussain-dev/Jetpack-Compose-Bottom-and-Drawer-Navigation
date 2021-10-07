package dev.hmh.jetpackcomposenavigation.medium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import dev.hmh.jetpackcomposenavigation.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, PrimerFragment()).commit()
        }
    }
}