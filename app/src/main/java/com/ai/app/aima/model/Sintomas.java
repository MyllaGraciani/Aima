package com.ai.app.aima.model;

import android.content.res.Resources;
import android.util.Log;

import com.ai.app.aima.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Sintomas {

    private static final String TAG = Sintomas.class.getSimpleName();

    public final String sintoma;

    public Sintomas(String sintoma) {
        this.sintoma = sintoma;
    }

    // Carrega o raw JSON chamado R.raw.sintomas e converte em uma lista de objetos SintomasEntry

    public static List<Sintomas> initSintomas(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.sintomas);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonSintomasString = writer.toString();
        Gson gson = new Gson();
        Type SintomasType = new TypeToken<ArrayList<Sintomas>>() {
        }.getType();
        return gson.fromJson(jsonSintomasString, SintomasType);
    }
}
