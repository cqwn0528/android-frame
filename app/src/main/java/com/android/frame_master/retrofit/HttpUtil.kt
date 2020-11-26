package com.android.frame_master.retrofit

class HttpUtil {

    companion object {
        private var httpConfig: HttpConfig? = null
        private var instance: HttpUtil? = null
            get() {
                if (field == null) {
                    field = HttpUtil()
                    httpConfig = HttpConfig()
                }
                return field
            }

        fun get(): HttpUtil {
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }
    fun getApiService(): ApiService = httpConfig!!.getApiService()
}