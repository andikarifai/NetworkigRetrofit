package com.and.networkigretrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.and.networkigretrofit.model.DataNews
import com.and.networkigretrofit.model.ResponseAddDataNews
import com.and.networkigretrofit.model.ResponseDataNewsItem
import com.and.networkigretrofit.model.ResponseUpdateDataNews
import com.and.networkigretrofit.restApi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    lateinit var liveDataNews: MutableLiveData<List<ResponseDataNewsItem>>
    lateinit var postDataNews: MutableLiveData<ResponseAddDataNews>
    lateinit var updateDataNews: MutableLiveData<List<ResponseUpdateDataNews>>

    init {
        liveDataNews = MutableLiveData()
        postDataNews = MutableLiveData()
        updateDataNews = MutableLiveData()
    }
//
//    fun getliveDataNews():MutableLiveData<List<ResponseDataNewsItem>>{
//        return liveDataNews
//    }
    fun postNews() : MutableLiveData<ResponseAddDataNews> {
    return postDataNews
    }

    fun callApiNews(){
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    liveDataNews.postValue(response.body())
                } else {
                    liveDataNews.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                liveDataNews.postValue(null)
            }
        })
    }
    fun addDataNews(title: String, image: String, author: String, description: String){
        RetrofitClient.instance.postDataNews(DataNews(title,image, author, description))
            .enqueue(object : Callback<ResponseAddDataNews>{
                override fun onResponse(
                    call: Call<ResponseAddDataNews>,
                    response: Response<ResponseAddDataNews>
                ) {
                    if (response.isSuccessful){
                        postDataNews.postValue(response.body())
                    }else{
                        postDataNews.postValue(null)
                    }
                }
                override fun onFailure(call: Call<ResponseAddDataNews>, t: Throwable) {
                    postDataNews.postValue(null)
                }
        })
    }
    fun callUpdateNews(id : Int,title: String, image: String, author: String, description: String){
        RetrofitClient.instance.updateDataNews(id, DataNews(title,image, author, description))
            .enqueue(object : Callback<List<ResponseUpdateDataNews>>{
                override fun onResponse(
                    call: Call<List<ResponseUpdateDataNews>>,
                    response: Response<List<ResponseUpdateDataNews>>
                ) {
                    if (response.isSuccessful){
                        updateDataNews.postValue(response.body())
                    }else{
                        updateDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseUpdateDataNews>>, t: Throwable) {
                    updateDataNews.postValue(null)
                }

            })
    }
}
