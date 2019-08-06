package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.R.layout



class MainActivity : AppCompatActivity() {

    private val texts = arrayOf(
        // Globe Decade の楽曲リストより
        "Feel Like dance",
        "Joy to the love (globe)",
        "SWEET PAIN",
        "DEPARTURES (RADIO EDIT)",
        "FREEDOM (RADIO EDIT)",
        "Is this love",
        "Can't Stop Fallin' in Love",
        "FACE",
        "FACES PLACES",
        "Anytime smokin' cigarette",
        "Wanderin' Destiny",
        "Love again",
        "wanna Be A Dreammaker",
        "Sa Yo Na Ra",
        "sweet heart",
        "Perfume of love",
        "MISS YOUR BODY",
        "still growin' up",
        "biting her nails",
        "とにかく無性に…"
    )

    private val SoundGridController : SoundGridController = SoundGridController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1.text = "aaaaaaa";
        button1.setOnClickListener {
            Log.d("MainActivity", "click: btn_send")
            SoundGridController.stopAllMediaPlayer()
        }

//        val arrayAdapter = ArrayAdapter(this, R.layout.list, texts)
//        products.adapter = arrayAdapter

        shogi_board.adapter = SoundGridController.adapter
        shogi_board.setOnItemClickListener{ _, _, position, _ ->
            SoundGridController.onClickCell(position)
        }
    }
}
