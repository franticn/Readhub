package ink.frantic.readhub.model.api.service

import ink.frantic.readhub.model.entity.CommonNewsResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 新闻方法接口
 * Created by fangxiaochao on 2017/12/28.
 */
interface NewsService {

    @GET("topic")
    fun getHotTopicNews(@Query("lastCursor")lastCursor : String,@Query("pageSize") pageSize : Int ) : Call<CommonNewsResult>

}