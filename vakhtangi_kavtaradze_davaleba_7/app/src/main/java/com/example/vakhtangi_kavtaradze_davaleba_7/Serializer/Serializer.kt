package com.example.vakhtangi_kavtaradze_davaleba_7.Serializer


import com.google.gson.annotations.SerializedName

data class Serializer(
    @SerializedName("titleEN")
    val title: String,
    @SerializedName("descriptionEN")
    val description: String,
    val cover: String
)