package cn.kingtous.mvp.main.presenter

import android.widget.Toast
import cn.droidlover.xdroidmvp.mvp.XPresent
import cn.droidlover.xdroidmvp.net.ApiSubscriber
import cn.droidlover.xdroidmvp.net.NetError
import cn.droidlover.xdroidmvp.net.XApi
import cn.kingtous.mvp.main.MainActivity
import cn.kingtous.mvp.main.model.MomentsModel
import cn.kingtous.mvp.net.Api

/**
 * Author: Kingtous
 * Since: 2019-10-23
 * Email: me@kingtous.cn
 */

class MainPresenter : XPresent<MainActivity>() {

    fun loadData() {
        Api.getApiService().getMomentsData()
            .compose(XApi.getApiTransformer<MomentsModel>())
            .compose(XApi.getScheduler<MomentsModel>())
            .compose(v.bindToLifecycle<MomentsModel>())
            .subscribe(object : ApiSubscriber<MomentsModel>() {
                override fun onFail(error: NetError) {
                    Toast.makeText(v,"$error",Toast.LENGTH_LONG).show()
                }

                override fun onNext(gankResults: MomentsModel) {
                    Toast.makeText(v,"成功",Toast.LENGTH_LONG).show()
                }
            })

    }

}