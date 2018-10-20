package com.android.utilities.util

import android.app.Activity
import android.content.Intent
import android.net.Uri


class IntentUtil {

    companion object {
        fun redirectToWebPage(activity: Activity, path: String) {
            val viewIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(path)
            )
            activity.startActivity(viewIntent)
        }
    }
}