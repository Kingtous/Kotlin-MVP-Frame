package cn.kingtous.mvp.base

import cn.droidlover.xdroidmvp.net.IModel

/**
 * Author: Kingtous
 * Since: 2019-10-24
 * Email: me@kingtous.cn
 */
open class BaseModel : IModel {

    /**
     * errcode : 0
     */

    var code: Int = 0

    var message: String? = null

    override fun isNull(): Boolean {
        return message != null
    }

    override fun isAuthError(): Boolean {
        return false
    }

    override fun isBizError(): Boolean {
        return false
    }

    override fun getErrorMsg(): String? {
        return message
    }
}
