package org.cybersoft.capstone.util;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Utils {
    public static void navigate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        req.getRequestDispatcher(path + ".jsp")
                .forward(req, resp);
    }

    public static Integer getPathParameter(HttpServletRequest req) {
        String[] path = req.getPathInfo()
                .split("/");
        return Integer.parseInt(path[path.length - 1]);
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
}
