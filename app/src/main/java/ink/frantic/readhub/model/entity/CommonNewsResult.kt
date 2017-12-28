package ink.frantic.readhub.model.entity

import com.google.gson.annotations.SerializedName

/**
 * 返回的通用新闻 数据类
 * 注意kotlin当中数据类的搭建方式 通过入参构建
 * Created by fangxiaochao on 2017/12/28.
 */
data class CommonNewsResult (
    @field:SerializedName("pageSize")
    val pageSize: Int? = null,

    @field:SerializedName("totalItems")
    val totalItems: Int? = null,

    @field:SerializedName("totalPages")
    val totalPages: Int? = null,

    @field:SerializedName("data")
    val data : List<NewsItem?>? = null

)