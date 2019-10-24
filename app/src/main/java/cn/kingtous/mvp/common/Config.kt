package cn.kingtous.mvp.common

/**
 * @author DuLong
 * @since 2019/7/30
 * email 798382030@qq.com
 */

object Config {
    /**
     * 设置BASE_URI
     */
    val BASE_URI = ""
    /**
     * 设置网络请求连接超时时间。单位秒
     */
    val CONNECT_TIME_OUT = 15000
    /**
     * 返回正确码
     */
    val NET_CORRECT_CODE = intArrayOf(0)
    /**
     * token
     */
    val TOKEN_KEY = "token"

    val TOKEN_VALUE = ""

    /**
     * Header Content-Type ,请求的与实体对应的MIME信息
     */
    val CONTENT_TYPE_KEY = "Content-Type"

    val CONTENT_TYPE_VALUE = "application/json"

}
