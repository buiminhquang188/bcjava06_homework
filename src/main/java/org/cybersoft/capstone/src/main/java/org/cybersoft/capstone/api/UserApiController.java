package org.cybersoft.capstone.api;

import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.mapper.ResponseMapper;
import org.cybersoft.capstone.payload.response.BaseResponse;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userApiController", urlPatterns = {"/api/user/*"})
public class UserApiController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final ResponseMapper responseMapper = new ResponseMapper();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Utils.getPathParameter(req);
        Integer userId = Utils.getUserSessionId(req);

        String message = null;
        Boolean data = null;
        Boolean isValid = this.isValid(req, id, userId);

        if (isValid) {
            data = this.userService.deleteUser(id);
        } else {
            data = false;
            message = "NOT_ALLOWED";
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

    private Boolean isValid(HttpServletRequest req, Integer pathParameter, Integer userId) {

        if (pathParameter == null || userId == null) return false;
        if (pathParameter.intValue() != userId.intValue()) return false;

        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");
        UserEntity user = this.userService.getUserWithRole(pathParameter);

        return !roleDetailDTO.getName()
                .equals(user.getRole()
                        .getName());
    }

    private void getAuthorizationAction() {

    }
}
