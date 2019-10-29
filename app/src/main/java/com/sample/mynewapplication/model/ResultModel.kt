package com.sample.mynewapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class ResultModel {

    @SerializedName("result")
    @Expose
    var result: Int? = null

}