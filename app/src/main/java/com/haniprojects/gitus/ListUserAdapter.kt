package com.haniprojects.gitus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haniprojects.gitus.databinding.ItemListUserBinding

class ListUserAdapter(private val listUserGithub: ArrayList<User>):
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int)= ListViewHolder (
        ItemListUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,
            false)
    )

    override fun getItemCount(): Int = listUserGithub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUserGithub[position])
    }

    inner class ListViewHolder(private val binding: ItemListUserBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User){
            Glide.with(binding.ivProfpict.context)
                .load(data.avatar)
                .placeholder(R.mipmap.user_circle)
                .into(binding.ivProfpict)

            binding.tvNameuser.text = data.name
            binding.tvUsername.text = StringBuilder("@" + data.username)
            binding.tvRepoValue.text = data.repository

            binding.btnMore.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}