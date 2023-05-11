package com.example.lovecalculator.on_board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardBinding

class OnBoardAdapter(private val onStartClick: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        onBoard(
            "Have a good time",
            "You should take the \n time to help those who need you",
            R.drawable.img_5
        ),
        onBoard(
            "Cherishing love",
            "It is now no longer possible \n for you to cherish love",
            R.drawable.wedding
        ),
        onBoard(
            "Have a break up?",
            "We have made the correction for you don't worry.\n Maybe someone is waiting for you",
            R.drawable.img_4
        ),
        onBoard(
            "It's Funs and Many more", "",
            R.drawable.img_2
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: onBoard) {
            binding.apply {
                onBoard.image?.let { image.setImageResource(it) }
                tvTittle.text = onBoard.tittle
                tvDescription.text = onBoard.desc
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}