package uca.edu.simpsonsquotes.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuoteNetworkEntity(
    @Expose
    var id: String,

    @SerializedName("quote")
    @Expose
    var quote: String,

    @SerializedName("character")
    @Expose
    var character: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("characterDirection")
    @Expose
    var characterDirection: String
)