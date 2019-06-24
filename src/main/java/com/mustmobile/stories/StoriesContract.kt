package com.mustmobile.stories

import android.content.Context
import android.support.v4.app.Fragment
import com.applicaster.plugin_manager.screen.PluginScreen
import java.io.Serializable
import java.util.HashMap

class StoriesContract : PluginScreen {
    override fun present(context: Context?, screenMap: HashMap<String, Any>?, dataSource: Serializable?, isActivity: Boolean) {

    }

    override fun generateFragment(screenMap: HashMap<String, Any>?, dataSource: Serializable?): Fragment {
        return Fragment()
    }
}
