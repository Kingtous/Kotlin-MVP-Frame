package cn.kingtous.mvp.main

import android.os.Bundle
import com.neuqer.mydream.R
import cn.kingtous.mvp.base.BaseActivity
import cn.kingtous.mvp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity: BaseActivity<MainPresenter?>(){

    override fun initData(savedInstanceState: Bundle?) {
        initTopBar("主页面")
        p?.loadData()
        txt_hello.onClick { getvDelegate().toastLong("Hello World.") }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun newP(): MainPresenter? {
        return MainPresenter()
    }

}
