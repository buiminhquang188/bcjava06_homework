package org.cybersoft.capstone.util;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static void navigate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        req.getRequestDispatcher(path + ".jsp")
                .forward(req, resp);
    }

    public static Integer getPathParameter(HttpServletRequest req) {
        String path = req.getPathInfo();
        if (path == null) return null;

        try {
            String[] paths = null;
            paths = path.split("/");

            return Integer.parseInt(paths[paths.length - 1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <T> String dataToJson(T object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static void appendServletResponseWriter(HttpServletResponse resp, String jsonData) throws IOException {
        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();
        printWriter.append(jsonData);
        printWriter.close();
    }

    public static Timestamp parseStringToTimeStamp(String dateString, LocalTime time) {
        String date = LocalDate.parse(dateString)
                .atTime(time)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return Timestamp.valueOf(date);
    }

    public static Integer parseStringToInt(String input) {
        return input != null ? Integer.parseInt(input) : null;
    }
}
