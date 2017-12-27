package ink.frantic.readhub

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_news_list.*

/**
 * Created by fangxiaochao on 2017/12/27.
 */
 class NewsListFragment : BaseFragment() {
    /**
     * 新闻类型的key
     */
    private val NEWS_TYPE = "newsType"

    private var mNewstype = 0

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
        tvTest.text = msg
    }

}
