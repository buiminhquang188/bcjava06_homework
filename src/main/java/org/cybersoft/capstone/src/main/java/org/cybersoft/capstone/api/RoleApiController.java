package org.cybersoft.capstone.api;

import org.cybersoft.capstone.constant.Role;
import org.cybersoft.capstone.mapper.ResponseMapper;
import org.cybersoft.capstone.payload.response.BaseResponse;
import org.cybersoft.capstone.service.RoleService;
import org.cybersoft.capstone.service.impl.RoleServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "roleApiController", urlPatterns = {"/api/role/*"})
public class RoleApiController extends HttpServlet {
    private final RoleService roleService = new RoleServiceImpl();
    private final ResponseMapper responseMapper = new ResponseMapper();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Utils.getPathParameter(req);
        Boolean data = null;
        String message = null;

        if (id != null && (id.intValue() == Role.ADMIN.getId() || id.intValue() == Role.LEADER.getId() || id.intValue() == Role.USER.getId())) {
            data = false;
            message = "NOT_ALLOWED";
        } else {
            data = this.roleService.deleteRole(id);
        }

        BaseResponse<Object> baseResponse = null;

        if (Boolean.TRUE.equals(data)) {
            baseResponse = this.responseMapper.jsonToSuccessResponse(data);
        } else {
            baseResponse = this.responseMapper.jsonToFailedResponse(data, message);
        }
        String jsonData = Utils.dataToJson(baseResponse);
        Utils.appendServletResponseWriter(resp, jsonData);
    }
}
