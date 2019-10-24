package cn.kingtous.mvp.common

import com.google.gson.annotations.SerializedName

import java.io.IOException

/**
 * 异常响应体
 *
 * @author FanHongyu.
 * @since 18/1/17 23:54.
 * email fanhongyu@hrsoft.net.
 */

class ApiException : IOException {
    /**
     * 错误码
     */
    @SerializedName("errcode")
    var code: Int = 0

    /**
     * 错误信息
     */
    @SerializedName("errmsg")
    var msg: String? = null

    constructor(code: Int, msg: String) {
        this.code = code
        this.msg = msg
    }

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }
}
