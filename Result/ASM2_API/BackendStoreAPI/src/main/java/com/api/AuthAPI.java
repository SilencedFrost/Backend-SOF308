package com.api;

import com.constants.AuthFields;
import com.dto.OutboundUserDTO;
import com.security.PasswordHasher;
import com.service.UserService;
import com.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import static com.util.ServletUtil.getAction;

@WebServlet("/api/auth/*")
public class AuthAPI extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AuthAPI.class.getName());
    private static final UserService userService = new UserService();
    private static final String requestUrl = "/auth";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Get request received");

        if(action.length() == requestUrl.length()) {
            JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
        } else {
            switch(action.substring(requestUrl.length() + 1)) {
                case "login" -> {
                    Map<String, String> inputData = JsonUtil.readJsonAsMap(req);
                    String usernameOrEmail = inputData.get(AuthFields.USERNAME_OR_EMAIL.getPropertyKey());
                    String password = inputData.get(AuthFields.PASSWORD.getPropertyKey());

                    OutboundUserDTO userDTO = userService.findByUsernameOrEmail(usernameOrEmail);

                    if(userDTO != null && userService.validateUser(password, userDTO.getUserId())) {
                        JsonUtil.sendJsonResp(resp, userDTO, HttpServletResponse.SC_OK);
                    }
                    JsonUtil.sendJsonResp(resp, Map.of("error", "Incorrect credentials"), HttpServletResponse.SC_NOT_FOUND);
                }case "logout" -> {

                }case "signup" -> {

                }default -> JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }
}
