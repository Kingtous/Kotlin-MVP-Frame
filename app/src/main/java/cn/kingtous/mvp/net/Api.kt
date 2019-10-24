package cn.kingtous.mvp.net

import cn.droidlover.xdroidmvp.net.XApi
import cn.kingtous.mvp.common.Config

/**
 * Author: Kingtous
 * Since: 2019-10-24
 * Email: me@kingtous.cn
 */


class Api{

    companion object {

        private var apiService: ApiService? = null

        fun getApiService(): ApiService {
            if (apiService == null) {
                synchronized(Api::class.java) {
                    if (apiService == null) {
                        apiService = XApi.getInstance()
                            .getRetrofit(Config.BASE_URI, true)
                            .create(ApiService::class.java)
                    }
                }
            }
            return apiService!!
        }
    }
}