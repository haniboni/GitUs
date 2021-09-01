package com.haniprojects.gitus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.haniprojects.gitus.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showGetDataUser()
    }

    @SuppressLint("SetTextI18n")
    private fun showGetDataUser(){

        val getUsers = intent.getParcelableExtra<User>(Constant.KEY_USER) as User

        Glide.with(this)
            .load(getUsers.avatar)
            .into(binding.ivAvatar)

        binding.tvBigName.text = getUsers.name
        binding.tvName.text = getUsers.name
        binding.tvUsername.text ="@${getUsers.username}"
        binding.tvLives.text = getUsers.location
        binding.tvCompany.text = getUsers.company
        binding.btnRepo.text = getUsers.repository
        binding.btnFollower.text = getUsers.followers
        binding.btnFollowing.text = getUsers.following
    }
}