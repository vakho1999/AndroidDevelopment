package com.example.vakhtangi_kavtaradze_shualeduri_1.DataLoader
import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

object Dataloader {
    var retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://covid-193.p.rapidapi.com/")
        .build()

    var service: ApiRetrofit = retrofit.create<ApiRetrofit>(ApiRetrofit::class.java)
    fun getRequest(path: String, CustomCallback: CustomCallback) {
        val call = service.getRequest(path)
        call.enqueue(Callback(CustomCallback))

    }
    private fun Callback(CustomCallback : CustomCallback) = object : Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            d("error","${t.message}")
        }
        override fun onResponse(call: Call<String>, response: Response<String>) {

            CustomCallback.onSuccess(response.body().toString())
        }

    }
}
interface ApiRetrofit {
    @Headers("x-rapidapi-host:covid-193.p.rapidapi.com",
        "x-rapidapi-key:bf7b1815b0msh70010a5125e84dep19c0fcjsnff47e9ecdd0a")
    @GET("{path}")
    fun getRequest(@Path("path") user: String?): Call<String>
}