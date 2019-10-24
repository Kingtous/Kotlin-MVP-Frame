package cn.kingtous.mvp.main.model

import cn.kingtous.mvp.base.BaseModel

/**
 * Author: Kingtous
 * Since: 2019-10-24
 * Email: me@kingtous.cn
 */
class MomentsModel : BaseModel() {

    var data: DataBean? = null

    class DataBean {


        var user_id: Int = 0
        var phone: String? = null
        var avatar_url: String? = null
        var nickname: String? = null
        var height: String? = null
        var weight: String? = null
        var signature: String? = null
        var liked: Int = 0
        var age: Int = 0
        var followers: Int = 0
        var following: Int = 0
    }
}
