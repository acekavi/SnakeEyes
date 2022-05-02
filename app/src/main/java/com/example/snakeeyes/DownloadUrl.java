package com.example.snakeeyes;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DownloadUrl {
    @NotNull
    public final String readUrl(@Nullable String myurl) throws IOException {
        String data = "";
        InputStream inputStream = (InputStream)null;
        HttpURLConnection httpURLConnection = (HttpURLConnection)null;
        boolean var15 = false;

        label89: {
            label90: {
                try {
                    var15 = true;
                    URL url = new URL(myurl);
                    URLConnection var10000 = url.openConnection();
                    if (var10000 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    }

                    httpURLConnection = (HttpURLConnection)var10000;
                    httpURLConnection.connect();
                    Intrinsics.checkNotNull(httpURLConnection);
                    inputStream = httpURLConnection.getInputStream();
                    BufferedReader br = new BufferedReader((Reader)(new InputStreamReader(inputStream)));
                    StringBuffer sb = new StringBuffer();
                    String var8 = "";

                    while(true) {
                        String var9 = br.readLine();
                        boolean var11 = false;
                        if (var9 == null) {
                            String var19 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(var19, "sb.toString()");
                            data = var19;
                            br.close();
                            var15 = false;
                            break label89;
                        }

                        sb.append(var9);
                    }
                } catch (MalformedURLException var16) {
                    Log.i("DownloadUrl", "readUrl: " + var16.getMessage());
                    var15 = false;
                    break label90;
                } catch (IOException var17) {
                    var17.printStackTrace();
                    var15 = false;
                } finally {
                    if (var15) {
                        Intrinsics.checkNotNull(inputStream);
                        inputStream.close();
                        Intrinsics.checkNotNull(httpURLConnection);
                        httpURLConnection.disconnect();
                    }
                }

                Intrinsics.checkNotNull(inputStream);
                inputStream.close();
                Intrinsics.checkNotNull(httpURLConnection);
                httpURLConnection.disconnect();
                return data;
            }

            Intrinsics.checkNotNull(inputStream);
            inputStream.close();
            Intrinsics.checkNotNull(httpURLConnection);
            httpURLConnection.disconnect();
            return data;
        }

        Intrinsics.checkNotNull(inputStream);
        inputStream.close();
        httpURLConnection.disconnect();
        return data;
    }
}
