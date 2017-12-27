package ink.frantic.readhub.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ink.frantic.readhub.Constants
import ink.frantic.readhub.NewsListFragment

/**
 * 新闻类型控制器
 * Created by fangxiaochao on 2017/12/27.
 */
class NewsTypeAdapter(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val mContext = context
    val mFragmentManager = fm
    val mTitleNames = Array(3, { "热门话题";"科技动态";"开发者资讯" })

    override fun getItem(position: Int): Fragment {
        when (position) {
            Constants().TYPE_DEV_INFO,
            Constants().TYPE_HOT_TOPIC,
            Constants().TYPE_TECH_NEWS -> return NewsListFragment().newInstance(position)
            else -> {
                return NewsListFragment().newInstance(Constants().TYPE_HOT_TOPIC)
            }
        }
    }

    override fun getCount(): Int {
        return mTitleNames.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "热门话题"
            1 -> return "科技动态"
            2 -> return "开发者资讯"
            else -> return "热门话题"
        }
    }
}