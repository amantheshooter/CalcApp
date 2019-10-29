package com.sample.mynewapplication

import android.annotation.SuppressLint
import android.view.View
import com.google.gson.JsonArray
import com.sample.mynewapplication.databinding.ActivityMainBinding
import com.sample.mynewapplication.model.ResultModel
import com.sample.mynewapplication.retrofit.APIClient
import com.sample.mynewapplication.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class EventHandler(var binding: ActivityMainBinding) {

    @SuppressLint("SetTextI18n")
    fun addition(v: View) {
        if (v.id == binding.textView.id) {
            if (!binding.editText.text.toString().contains('+'))
                binding.editText.setText(binding.editText.text.toString() + '+')
        } else if (v.id == binding.textView2.id) {
            binding.editText.setText(binding.editText.text.toString() + 0)
        } else if (v.id == binding.textView4.id) {
            binding.editText.setText("0")
        } else if (v.id == binding.textView7.id) {
            binding.editText.setText(binding.editText.text.toString() + 1)
        } else if (v.id == binding.textView8.id) {
            binding.editText.setText(binding.editText.text.toString() + 2)
        } else if (v.id == binding.textView9.id) {
            binding.editText.setText(binding.editText.text.toString() + 3)
        } else if (v.id == binding.textView11.id) {
            binding.editText.setText(binding.editText.text.toString() + 4)
        } else if (v.id == binding.textView12.id) {
            binding.editText.setText(binding.editText.text.toString() + 5)
        } else if (v.id == binding.textView13.id) {
            binding.editText.setText(binding.editText.text.toString() + 6)
        } else if (v.id == binding.textView14.id) {
            binding.editText.setText(binding.editText.text.toString() + 7)
        } else if (v.id == binding.textView15.id) {
            binding.editText.setText(binding.editText.text.toString() + 8)
        } else if (v.id == binding.textView16.id) {
            binding.editText.setText(binding.editText.text.toString() + 9)
        }
    }

    fun submit() {
        val list: List<String> = binding.editText.text.toString().split("+")
        val data = JsonArray()
        data.add(list.get(0).toInt())
        data.add(list.get(1).toInt())
        val service: ApiInterface = APIClient.client.create(ApiInterface::class.java)
        val call: Call<ResultModel> = service.add(data)
        call.enqueue(object : Callback<ResultModel> {
            override fun onResponse(
                call: Call<ResultModel>,
                response: Response<ResultModel>
            ) {
                if (response.body()?.result != null)
                    binding.editText.setText(response.body()?.result!!.toString())
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}