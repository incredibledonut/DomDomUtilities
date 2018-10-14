package com.android.utilities.util;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ying on 8/15/2016.
 */
public class FileUtil {

    public static void saveBytesToInternalStorage(
            String fileDir, String fileName, byte[] bytes, boolean keepOldDirFolder) {
        String fullPath = fileDir + File.separator + fileName;
        File file;

        if (keepOldDirFolder) {
            file = new File(fileDir);
        } else {
            file = new File(fullPath);
        }

        // Delete old data
        if (file.exists()) {
            file.delete();
        }

        // Open dir sub folders
        new File(fileDir).mkdirs();

        // Write to local
        FileOutputStream outputStream = null;
        try {
            File fullPathFile = new File(fullPath);
            fullPathFile.createNewFile();

            outputStream = new FileOutputStream(fullPathFile);
            outputStream.write(bytes);
            outputStream.close();
            LogUtil.d("FileUtil >> saveBytesToInternalStorage: " + fullPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    public static void createNoMediaFileToRoot(Application application, String folderPath) throws IOException {
        new File(folderPath).mkdir();

        String noMediaPath = folderPath + File.separator + ".nomedia";
        File noMediaFile = new File(noMediaPath);
        if (!noMediaFile.exists()) {
            noMediaFile.createNewFile();
            scanMedia(application, noMediaPath);
        }
    }

    public static void downloadFileToLocal(String fileURL, String folderPath, String fileName)
            throws IOException {

        File rootFile = new File(folderPath);
        rootFile.mkdirs();

        URL u = new URL(fileURL);
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.connect();

        InputStream in = null;
        FileOutputStream f = null;
        try {
            in = c.getInputStream();
            f = new FileOutputStream(new File(rootFile, fileName));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                f.write(buffer, 0, len);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (f != null) {
                f.flush();
                f.close();
            }
        }
    }

    /**
     * Sends a broadcast to have the media scanner scan a file
     *
     * @param path the file to scan
     */
    public static void scanMedia(Application application, String path) {
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        application.sendBroadcast(new Intent(Intent
                .ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
    }
}
