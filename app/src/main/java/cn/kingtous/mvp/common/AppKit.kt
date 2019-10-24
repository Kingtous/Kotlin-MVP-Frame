package cn.kingtous.mvp.common

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

import java.io.IOException

import okhttp3.MediaType
import okhttp3.Request
import okio.Buffer

/**
 * Created by wanglei on 2016/12/11.
 */

object AppKit {

    fun copyToClipBoard(context: Context, text: String) {
        val cm = context.getSystemService(
            Context.CLIPBOARD_SERVICE
        ) as ClipboardManager
        cm.primaryClip = ClipData.newPlainText("xdroid_copy", text)
        Toast.makeText(context, "复制成功", Toast.LENGTH_SHORT).show()
    }

    fun openInBrowser(context: Context, url: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        val uri = Uri.parse(url)
        intent.data = uri
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "打开失败了，没有可打开的应用", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareText(context: Context, shareText: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享")
        intent.putExtra(Intent.EXTRA_TEXT, shareText)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(Intent.createChooser(intent, "分享"))
    }

    fun shareImage(context: Context, uri: Uri) {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        shareIntent.type = "image/jpeg"
        context.startActivity(Intent.createChooser(shareIntent, "分享图片"))
    }

    fun isText(mediaType: MediaType): Boolean {
        if (mediaType.type() != null && mediaType.type() == "text") {
            return true
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype() == "json" ||
                mediaType.subtype() == "xml" ||
                mediaType.subtype() == "html" ||
                mediaType.subtype() == "webviewhtml"
            )
                return true
        }
        return false
    }

    fun bodyToString(request: Request): String {
        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body().writeTo(buffer)
            return buffer.readUtf8()
        } catch (e: IOException) {
            return "something error when show requestBody."
        }

    }
}
