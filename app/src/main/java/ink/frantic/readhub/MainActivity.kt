package ink.frantic.readhub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ink.frantic.readhub.adapter.NewsTypeAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  readhub 主页面Activity
 *
 * Created by fangxiaochao on 2017/12/27.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

    }

    private fun initUI() {
        viewpager.adapter = NewsTypeAdapter(this,this.supportFragmentManager)
        viewpager.offscreenPageLimit = 0
        viewpager.currentItem = 0
        tablayout.setupWithViewPager(viewpager)
    }


}
