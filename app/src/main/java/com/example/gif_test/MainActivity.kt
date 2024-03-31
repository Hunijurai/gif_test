package com.example.gif_test

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    lateinit var mAnimation: AnimationDrawable
    lateinit var mImage: ImageView
    val drawbleList = listOf(R.drawable.hady, R.drawable.bullet, R.drawable.afk)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x = 0 //)
        var y = 0
        val asb = findViewById<SeekBar>(R.id.setAlpha)
        mImage = findViewById(R.id.ivAnimator)
        mImage.setBackgroundResource(R.drawable.hady)
        mAnimation = mImage.background as AnimationDrawable

        findViewById<Button>(R.id.btnStartAnimation).setOnClickListener {
            mAnimation.start()
        }

        findViewById<Button>(R.id.btnStopAnimation).setOnClickListener {
            mAnimation.stop()
        }

        findViewById<Button>(R.id.btnNextAnimation).setOnClickListener {
            x++
            mImage.setBackgroundResource(drawbleList[x % drawbleList.size])
            mAnimation = mImage.background as AnimationDrawable
            mAnimation.alpha = y
            mAnimation.start()
        }

        asb.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mAnimation.alpha = progress
                y = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }
}