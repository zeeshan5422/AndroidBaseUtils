package com.zues.baseutils.Utils

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/* ---  Created by akhtarz on 7/30/2019. ---*/
object FileUtils {

    fun getDatabaseFolder(application: Application): File {
        val path =
            "/data/data/" + application.packageName + "/databases"
        val folder = File(path)
        if (!folder.exists()) {
            folder.mkdirs()
        }
        return folder
    }

    fun getImagesFolder(appName: String): File {
        val folder = getAppDirectory(appName = appName)
        val imagesFolder = File(folder, "Images")
        if (!imagesFolder.exists()) {
            imagesFolder.mkdirs()
        }
        return imagesFolder
    }

    fun getAppDirectory(appName: String): File {
        val appDir = File(Environment.getExternalStorageDirectory(), appName)
        if (!appDir.exists()) {
            appDir.mkdirs()
        }
        return appDir
    }

    fun getRealPathFromURI(context: Context, contentUri: Uri): String {
        var cursor: Cursor? = null
        try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = context.contentResolver.query(contentUri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            return cursor.getString(column_index)
        } finally {
            cursor?.close()
        }
    }


    fun createTempFile(prefix: String, ext: String, appName: String): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = prefix + timeStamp + "_"
        val storageDir = getImagesFolder(appName)
        return File(storageDir, imageFileName + ext)
    }

    fun createTempFile(name: String, appName: String): File {
        val storageDir = getImagesFolder(appName)
        return File(storageDir, name)
    }


    fun fileSize(filePath: String): Long {
        val file = File(filePath)
        return file.length()
    }

}