package dev.joan.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.joan.postapp.api.ApiClient
import dev.joan.postapp.api.ApiInterface
import dev.joan.postapp.databinding.ActivityMainBinding
import dev.joan.postapp.model.PostsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        getResponse()
    }

    fun getResponse(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()
        request.enqueue(object : Callback<List<PostsModel>> {
            override fun onResponse(call: Call<List<PostsModel>>, response: Response<List<PostsModel>>) {
                if (response.isSuccessful){
                    var postings = response.body()
                    Toast.makeText(baseContext,"${postings!!.size}postings",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<PostsModel>>, t: Throwable) {
            }
        })
    }
}