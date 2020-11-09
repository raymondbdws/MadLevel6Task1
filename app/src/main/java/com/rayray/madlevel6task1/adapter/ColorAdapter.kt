package com.rayray.madlevel6task1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rayray.madlevel6task1.R
import com.rayray.madlevel6task1.model.ColorItem
import kotlinx.android.synthetic.main.item_color.view.*

class ColorAdapter(private val colors: List<ColorItem>, private val onClick: (ColorItem) -> Unit):
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_color, parent, false)
        )
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener{
                onClick(colors[adapterPosition])
            }
        }

        fun bind(colorItem: ColorItem){
            Glide.with(context).load(colorItem.getImageUrl()).into(itemView.ivColor)
        }
    }

    override fun onBindViewHolder(holder: ColorAdapter.ViewHolder, position: Int) {
        return holder.bind(colors[position])
    }

    override fun getItemCount(): Int {
        return colors.size
    }



}