package dev.joan.postapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.joan.postapp.model.PostsModel
import dev.joan.postapp.repository.PostsRepo
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    val postRepo = PostsRepo()
    val postsLiveData = MutableLiveData<List<PostsModel>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchProducts(){
        viewModelScope.launch {
            val response = postRepo.getPosts()
            if(response.isSuccessful){
                postsLiveData.postValue(response.body()?.products)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }

        }

    }


}
