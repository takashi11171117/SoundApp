package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class BoardCellAdapter: BaseAdapter {

    var context : Context? = null
    var boardCellList : ArrayList<BoardCell>

    constructor(context: Context, boardCellList: ArrayList<BoardCell>) : super() {
        this.context = context
        this.boardCellList = boardCellList
    }

    class ViewHolder(view: View){
        var imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun getCount(): Int {
        return boardCellList.size
    }

    override fun getItem(position: Int): Any {
        return boardCellList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder : ViewHolder
        var convertView = convertView

        if(convertView == null){
            /* if convertView is null, inflate custom view and use it as convert view */
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.board_cell, null)

            /* create a new viewHolder instance using convert view */
            viewHolder = ViewHolder(convertView)

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.imageView.setImageResource(boardCellList[position].image!!)

        return convertView!!
    }

}