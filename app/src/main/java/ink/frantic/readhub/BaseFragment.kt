package ink.frantic.readhub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Fragment基类
 * Created by fangxiaochao on 2017/12/27.
 */
abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(getLayoutResId(),container,false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //由于init中需要对view进行操作，所以需要等xml完全加载完，即上句方法体执行之后 才能执行initView
        initView(view, savedInstanceState)
    }
    /**
     * 获取布局文件的id
     */
    abstract fun getLayoutResId() : Int

    /**
     * 初始化view
     */
    open fun initView(view : View , savedInstanceState: Bundle?){

    }
}