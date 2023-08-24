package dev.joan.postapp.model

data class PostsDetails(
    var title:List<PostsModel>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
