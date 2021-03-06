package com.haniprojects.gitus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haniprojects.gitus.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    fun initListener() {
        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this@GetStartedActivity, MainActivity::class.java))
            finishAffinity()
        }
    }
}