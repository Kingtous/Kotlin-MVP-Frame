package cn.kingtous.mvp.net

import cn.droidlover.xdroidmvp.cache.SharedPref
import cn.droidlover.xdroidmvp.net.LogInterceptor
import cn.droidlover.xdroidmvp.net.NetError
import cn.droidlover.xdroidmvp.net.NetProvider
import cn.droidlover.xdroidmvp.net.RequestHandler
import cn.kingtous.mvp.App
import cn.kingtous.mvp.common.Config
import okhttp3.*

/**
 * Author: Kingtous
 * Since: 2019-10-24
 * Email: me@kingtous.cn
 */

class NetworkProvider : NetProvider{

    override fun configInterceptors(): Array<Interceptor> {
        val interceptor = Interceptor { chain ->
            val sToken = SharedPref.getInstance(App.getInstance()).getString("token", Config.TOKEN_VALUE)
            val request = chain.request().newBuilder()
                .header(Config.TOKEN_KEY, sToken)
                .header(
                    Config.CONTENT_TYPE_KEY,
                    Config.CONTENT_TYPE_VALUE)
                .build()
            chain.proceed(request)
        }
        return arrayOf(interceptor, LogInterceptor())
    }

    override fun configHttps(builder: OkHttpClient.Builder?) {

    }

    override fun configCookie(): CookieJar {
        return object : CookieJar {
            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                // 保留使用
            }
            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                return emptyList()
            }
        }

    }

    override fun configHandler(): RequestHandler {
        return object :RequestHandler{
            override fun onBeforeRequest(request: Request?, chain: Interceptor.Chain?): Request {
                return request!!
            }

            override fun onAfterRequest(response: Response?, chain: Interceptor.Chain?): Response {
                return response!!
            }
        }
    }

    override fun configConnectTimeoutMills(): Long {
        return Config.CONNECT_TIME_OUT.toLong()
    }

    override fun configReadTimeoutMills(): Long {
        return Config.CONNECT_TIME_OUT.toLong()
    }

    override fun configLogEnable(): Boolean {
        return true
    }

    override fun handleError(error: NetError?): Boolean {
        return false
    }

    override fun dispatchProgressEnable(): Boolean {
        return false
    }

}