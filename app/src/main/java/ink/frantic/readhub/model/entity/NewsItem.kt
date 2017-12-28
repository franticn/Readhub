package ink.frantic.readhub.model.entity

/**
 *  新闻item的 数据类
 * @author fangxiaochao
 * @date   2017/12/28
 */
data class NewsItem(
        val id: String? = null,

        val title: String? = null,

        val summary: String? = null,

        val summaryAuto: String? = null,

        val url: String? = null,

        val mobileUrl: String? = null,

        val siteName: String? = null,

        val language: String? = null,

        val authorName: String? = null,

        val publishDare: String? = null
)

