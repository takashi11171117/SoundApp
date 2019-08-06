package com.example.myapplication

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class SoundGridController(private val context: Context) {
    private val boardMatrix = Array(3){arrayOfNulls<String>(3)}
    private val boardCellList : ArrayList<BoardCell> = arrayListOf()
    val adapter : BoardCellAdapter
    private val mpList = mutableListOf<MediaPlayer>()

    private val sounds = listOf(
        R.raw.oto1,
        R.raw.oto2,
        R.raw.oto3,
        R.raw.oto4,
        R.raw.oto5,
        R.raw.oto6,
        R.raw.oto7,
        R.raw.oto8,
        R.raw.oto9
    )

    private val pieceDict = mapOf(
        "empty"         to BoardCell(R.drawable.empty)
    )

    init {
        this.initPosition()
        for(i in 0..2){
            for(j in 0..2){
                boardCellList.add(pieceDict[boardMatrix[i][j]]!!)
            }
        }
        adapter = BoardCellAdapter(context, boardCellList)
    }

    fun onClickCell(clickedPos : Int){
        val nowMp = createMediaPlayer(sounds[clickedPos])
        mpList.add(nowMp);
        nowMp.start();
        Log.d("MainActivity", "click: cell $clickedPos")
    }

    fun stopAllMediaPlayer() {
        if (mpList.isNotEmpty()) {
            mpList.forEach{it.release()}
        }
    }

    private fun createMediaPlayer(sound : Int): MediaPlayer {
        val mp = MediaPlayer.create(context, sound)
        mp.setOnCompletionListener {MediaPlayer -> MediaPlayer.release()}

        return mp
    }

    private fun initPosition(){
        for(i in 0..2){
            for(j in 0..2){
                boardMatrix[i][j] = "empty"
            }
        }
    }
}