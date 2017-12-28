package ink.frantic.readhub

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ink.frantic.readhub.model.api.Api
import ink.frantic.readhub.model.api.service.NewsService
import ink.frantic.readhub.model.entity.CommonNewsResult
import kotlinx.android.synthetic.main.fragment_news_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by fangxiaochao on 2017/12/27.
 */
 class NewsListFragment : BaseFragment() {
    /**
     * 新闻类型的key
     */
    private val NEWS_TYPE = "newsType"

    private var mNewstype = 0

    private val TAG = "NewsListFragment"

    /**
     * Fragment对象的实例化
     * @param type 新闻类型
     */
    fun newInstance(type: Int): NewsListFragment {
        val bundle  = Bundle()
        bundle.putInt(NEWS_TYPE, type)
        val fragment = NewsListFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNewstype = arguments!!.getInt(NEWS_TYPE,0)
    }

    private fun requestData(mNewstype: Int) {
        var retrofit :Retrofit = Retrofit.Builder()
                .baseUrl(Api().BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //TODO NewsService ::class.java unknown params
        var newsService : NewsService = retrofit.create(NewsService ::class.java)

        var call : Call<CommonNewsResult> = newsService.getHotTopicNews("",10)

        call.enqueue(object : Callback<CommonNewsResult> {
            override fun onResponse(call: Call<CommonNewsResult>?, response: Response<CommonNewsResult>?) {
                Log.d(TAG,"Success 接口返回的信息 ： " + response!!.body().toString())
            }

            override fun onFailure(call: Call<CommonNewsResult>?, t: Throwable?) {
                Log.d(TAG,"Error 接口返回的错误信息 ： " + t.toString())
            }
        })

    }


    override fun getLayoutResId(): Int {
        return R.layout.fragment_news_list
    }



    override fun initView(view : View , savedInstanceState: Bundle?) {
        val msg: String
        when (mNewstype) {
            0 -> msg = "hot"
            1 -> msg = "tech"
            2 -> msg = "dev"
            else -> msg = "hot"
        }
        btnTest.text = msg

        btnTest.setOnClickListener{
            requestData(mNewstype)
        }
    }

}

