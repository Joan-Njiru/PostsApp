package dev.joan.postapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import dev.joan.postapp.databinding.PostresponseBinding
import dev.joan.postapp.model.PostsModel


class Adapter (var postResponse:List<PostsModel>,var context: Context):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostresponseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var posts = postResponse.get(position)
        var binding = holder.binding
        binding.tvUserId.text=posts.toString()
        binding.tvTitle.text = posts.title
        binding.tvBody.text = posts.body

        holder.binding.tvUserId.setOnClickListener {
            val intent = Intent(context,PostsModel::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return postResponse.size
    }
}
 class PostViewHolder(var binding: PostresponseBinding):RecyclerView.ViewHolder(binding.root)