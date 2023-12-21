package com.coursework.eshop.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Rest {

    public static String sendGet(String getUrl) throws IOException {
        HttpURLConnection httpURLConnection = setupConnection(getUrl, "GET");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(httpURLConnection);
            } else {
                return "Error: " + responseCode;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static String sendPost(String postUrl, String jsonInfo) throws IOException {
        HttpURLConnection httpURLConnection = setupConnection(postUrl, "POST");
        try {
            writeRequest(httpURLConnection, jsonInfo);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(httpURLConnection);
            } else {
                return "Error: " + responseCode;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static String sendPut(String putUrl, String jsonInfo) throws IOException {
        HttpURLConnection httpURLConnection = setupConnection(putUrl, "PUT");
        try {
            writeRequest(httpURLConnection, jsonInfo);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(httpURLConnection);
            } else {
                return "Error: " + responseCode;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static String sendDelete(String deleteUrl) throws IOException {
        HttpURLConnection httpURLConnection = setupConnection(deleteUrl, "DELETE");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(httpURLConnection);
            } else {
                return "Error: " + responseCode;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static HttpURLConnection setupConnection(String url, String method) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlObj.openConnection();
        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        if (!method.equals("GET")) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private static void writeRequest(HttpURLConnection connection, String jsonInfo) throws IOException {
        try (OutputStream outputStream = connection.getOutputStream();
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {
            bufferedWriter.write(jsonInfo);
        }
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }
}


