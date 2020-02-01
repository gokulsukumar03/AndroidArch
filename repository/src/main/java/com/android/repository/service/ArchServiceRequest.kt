package com.android.repository.service

import retrofit2.Call
import retrofit2.http.GET
import java.util.*

//  https://api.myjson.com/bins/aany2
// https://api.myjson.com/bins/1b7jga
interface ArchServiceRequest {
    @GET("")
    fun getBatsman() : Call<Objects>
}