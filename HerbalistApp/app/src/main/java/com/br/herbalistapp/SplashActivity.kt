package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlin.concurrent.thread

class splash_Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var tv = findViewById<TextView>(R.id.text_splash)
        var iv = findViewById<ImageView>(R.id.image_splash)

        val myAnime = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        tv.startAnimation(myAnime)
        iv.startAnimation(myAnime)
        val intent = Intent(this,MainActivity::class.java)
        var timer = thread {
            kotlin.run {
                try {
                    Thread.sleep(5000)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
                finally {
                    startActivity(intent)
                    finish()

                }
            }
        }
        timer.start()
    }
}
