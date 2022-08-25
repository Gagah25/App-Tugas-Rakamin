package com.example.rakaminsubmission.model.response

import com.google.gson.annotations.SerializedName

data class DataResponse(

    @SerializedName("items")
    val items: ArrayList<ItemsItem>
)

data class ItemsItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,
)