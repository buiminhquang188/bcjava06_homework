package org.cybersoft.capstone.api;

import org.cybersoft.capstone.mapper.ResponseMapper;
import org.cybersoft.capstone.payload.response.BaseResponse;
import org.cybersoft.capstone.service.TaskService;
import org.cybersoft.capstone.service.impl.TaskServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "taskApiController", urlPatterns = {"/api/task/*"})
public class TaskApiController extends HttpServlet {
    private final TaskService taskService = new TaskServiceImpl();
    private final ResponseMapper responseMapper = new ResponseMapper();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Utils.getPathParameter(req);
        Boolean data = this.taskService.deleteTask(id);

        BaseResponse<Object> baseResponse = null;
        if (Boolean.TRUE.equals(data)) {
            baseResponse = this.responseMapper.jsonToSuccessResponse(data);
        } else {
            baseResponse = this.responseMapper.jsonToFailedResponse(data);
        }

        String jsonData = Utils.dataToJson(baseResponse);
        Utils.appendServletResponseWriter(resp, jsonData);
    }
}
