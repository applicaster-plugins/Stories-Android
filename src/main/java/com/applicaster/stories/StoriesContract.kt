package com.applicaster.stories

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.util.Log
import com.applicaster.atom.model.APAtomError
import com.applicaster.atom.model.APAtomFeed
import com.applicaster.jspipes.JSManager
import com.applicaster.plugin_manager.screen.PluginScreen
import com.applicaster.util.serialization.SerializationUtils
import com.google.gson.internal.LinkedTreeMap
import java.io.Serializable
import java.util.HashMap

class StoriesContract : PluginScreen {
    override fun present(context: Context?, screenMap: HashMap<String, Any>?, dataSource: Serializable?, isActivity: Boolean) {
        Log.d(this.javaClass.simpleName, "stories contract present")
    }

    override fun generateFragment(screenMap: HashMap<String, Any>?, dataSource: Serializable?): Fragment {
        val data = screenMap?.get("data")
        if (data is LinkedTreeMap<*, *>) {
            val source = data["source"].toString()
            Handler(Looper.getMainLooper()).post {
                JSManager.getInstance().get(source, object : JSManager.JSManagerCallback {
                    override fun onResult(atom: Any) {
                        Log.d(this.javaClass.simpleName, "onResult")
                    }

                    override fun onError(error: APAtomError) {
                        Log.d(this.javaClass.simpleName, "onError")
                    }
                })
            }
        }

        return Fragment()
    }
}
