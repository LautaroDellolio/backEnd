package Satra_JuanDellolio_Lautaro.clinica.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonPrinter {
    public static String toString(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        // Convertir el objeto a JSON y eliminar espacios en blanco y saltos de línea
        return gson.toJson(object).trim().replace("\n", "").replace("\t", "");
    }
}
