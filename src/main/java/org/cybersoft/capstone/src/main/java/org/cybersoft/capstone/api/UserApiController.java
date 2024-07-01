package org.cybersoft.capstone.api;

import com.google.gson.Gson;
import org.cybersoft.capstone.constant.Status;
import org.cybersoft.capstone.payload.response.BaseResponse;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userApiController", urlPatterns = {"/api/user/*"})
public class UserApiController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] path = req.getPathInfo()
                .split("/");
        Integer id = Integer.parseInt(path[1]);

        Boolean data = this.userService.deleteUser(id);
        BaseResponse<Object> baseResponse = new BaseResponse<>(200, Status.SUCCESS.getValue(), data);

        Gson gson = new Gson();
        String jsonData = gson.toJson(baseResponse);

        resp.setContentType("application/json");

        PrintWriter printWriter = resp.getWriter();
        printWriter.append(jsonData);
        printWriter.close();
    }
}
