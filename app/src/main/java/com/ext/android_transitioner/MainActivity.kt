package com.ext.android_transitioner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.ext.transitioner.utils.transition
import androidx.core.view.WindowInsetsCompat
import com.ext.android_transitioner.databinding.ActivityMainBinding
import com.ext.transitioner.ActivityTransition
import com.ext.transitioner.TransitionConfig
import com.ext.transitioner.TransitionType
import com.ext.transitioner.Transitioner

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.fadeBtn.setOnClickListener {
            binding.titleText.transition(TransitionType.FADE)
        }
        binding.slideBtn.setOnClickListener {
            binding.titleText.transition(
                TransitionType.SLIDE,
                TransitionConfig(duration = 500)
            )
        }

        binding.scaleBtn.setOnClickListener {
            binding.titleText.transition(TransitionType.SCALE)
        }

        binding.newact.setOnClickListener {
            Transitioner.startActivity(
                from = this,
                intent = Intent(this, SecondActivity::class.java),
                transition = ActivityTransition.SLIDE_RIGHT
            )
        }
    }
}