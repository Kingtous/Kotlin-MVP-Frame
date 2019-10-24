package cn.kingtous.mvp.net

import cn.kingtous.mvp.main.model.MomentsModel
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Author: Kingtous
 * Since: 2019-10-24
 * Email: me@kingtous.cn
 */
interface ApiService {


    @GET("moment/moment")
    abstract fun getMomentsData(): Flowable<MomentsModel>

}