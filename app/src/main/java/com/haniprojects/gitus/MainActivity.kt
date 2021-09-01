package com.haniprojects.gitus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.haniprojects.gitus.Constant.KEY_USER
import com.haniprojects.gitus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: ListUserAdapter
    private val listUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listUser.addAll(getDataUser())
        setupRecyclerView()

    }

    private fun setupRecyclerView(){
        userAdapter = ListUserAdapter(listUser)
        binding.rvUsergithub.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
            setHasFixedSize(true)
        }

        userAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                val intentDataUser = User(
                    data.avatar,
                    data.name,
                    data.username,
                    data.location,
                    data.repository,
                    data.company,
                    data.followers,
                    data.following

                )
                val intentData = Intent(this@MainActivity, DetailActivity::class.java)
                intentData.putExtra(KEY_USER, intentDataUser)
                startActivity(intentData)
            }

        })
    }

    @SuppressLint("Recycle")
    fun getDataUser(): ArrayList<User>{
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataRepo = resources.getStringArray(R.array.repository)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        val listDataUser = ArrayList<User>()
        for (position in dataName.indices){
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataLocation[position],
                dataRepo[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]

            )
            listDataUser.add(user)
        }
        return listDataUser
    }

}