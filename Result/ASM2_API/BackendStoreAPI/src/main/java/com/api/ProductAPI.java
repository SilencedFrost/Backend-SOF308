package com.api;

import com.constants.ProductFields;
import com.dto.ProductDTO;
import com.dto.OutboundProductDTO;
import com.service.ProductService;
import com.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import static com.util.ServletUtil.getAction;

@WebServlet("/api/products/*")
public class ProductAPI extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductAPI.class.getName());
    private static final ProductService productService = new ProductService();
    private static final String requestUrl = "/products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Get request received");

        if(action.length() == requestUrl.length()) {
            JsonUtil.sendJsonResp(resp, productService.findAll(), HttpServletResponse.SC_OK);
        } else {
            List<String> actionPath = Arrays.stream(action.substring(requestUrl.length() + 1).split("/")).toList();

            switch (actionPath.size()) {
                case 1 -> {
                    try {
                        Integer productId = Integer.parseInt(actionPath.getFirst());
                        OutboundProductDTO productDTO = productService.findById(productId);
                        if(productDTO == null) {
                            JsonUtil.sendJsonResp(resp, new OutboundProductDTO(), HttpServletResponse.SC_NOT_FOUND);
                        } else {
                            JsonUtil.sendJsonResp(resp, productDTO, HttpServletResponse.SC_OK);
                        }
                    } catch (NumberFormatException e) {
                        JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
                    }
                }
                case 2 -> {
                    if(actionPath.getFirst().equals("search")) {
                        try {
                            Integer productId = Integer.parseInt(actionPath.get(1));
                        } catch (NumberFormatException e) {
                            JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
                        }
                    } else {
                        JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
                    }
                } default -> JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }

    /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Post request received");

        Map<String, String> errors = new HashMap<>();
        Map<String, Object> respMap = new HashMap<>();

        Map<String, String> reqMap = ServletUtil.basicFormCheck(req, resp, errors, respMap);

        if(reqMap != null) {
            String productId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                productId = action.substring(requestUrl.length() + 1);
            } else {
                productId = reqMap.get(ProductFields.USER_ID.getPropertyKey());
            }
            String password = reqMap.get(ProductFields.PASSWORD.getPropertyKey());
            String fullName = reqMap.get(ProductFields.FULL_NAME.getPropertyKey());
            String email = reqMap.get(ProductFields.EMAIL.getPropertyKey());
            String role = reqMap.get(ProductFields.ROLE.getPropertyKey());

            // Field validation
            ValidationUtil.validateProductId(productId, errors);
            ValidationUtil.validateFullName(fullName, errors);
            ValidationUtil.validateEmail(email, errors);
            ValidationUtil.validatePassword(password, errors);
            if(ValidationUtil.isNullOrBlank(role)) role = "Product";

            if (errors.isEmpty()) {
                if (productService.create(productId, PasswordHasher.hash(password), fullName, email, role)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed product creation
                    errors.put("specialError", "Product creation failed");
                }
            }
            // Reload CSRF token
            ServletUtil.refreshCsrfToken(req, respMap);

            // Send response back
            respMap.put("errors", errors);

            JsonUtil.sendJsonResp(resp, respMap, HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Put request received");

        Map<String, String> errors = new HashMap<>();
        Map<String, Object> respMap = new HashMap<>();

        Map<String, String> reqMap = ServletUtil.basicFormCheck(req, resp, errors, respMap);

        if(reqMap != null) {
            String productId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                productId = action.substring(requestUrl.length() + 1);
            } else {
                productId = reqMap.get(ProductFields.USER_ID.getPropertyKey());
            }
            String password = reqMap.get(ProductFields.PASSWORD.getPropertyKey());
            String fullName = reqMap.get(ProductFields.FULL_NAME.getPropertyKey());
            String email = reqMap.get(ProductFields.EMAIL.getPropertyKey());
            String role = reqMap.get(ProductFields.ROLE.getPropertyKey());

            // Field validation
            // Product Id
            if(ValidationUtil.isNullOrBlank(productId)) {
                errors.put(ProductFields.USER_ID.getErrorKey(), "Product Id cannot be empty!");
            } else if (productService.findById(productId) == null) {
                errors.put(ProductFields.USER_ID.getErrorKey(), "Product Id does not exist");
            }

            // Full name
            if(ValidationUtil.isNullOrBlank(fullName)) fullName = null;

            // Email
            if(ValidationUtil.isNullOrBlank(email)) {
                email = null;
            } else if (!ValidationUtil.isValidEmail(email)) {
                errors.put(ProductFields.EMAIL.getErrorKey(), "Email is invalid!");
            } else if (productService.findByEmail(email) != null) {
                errors.put(ProductFields.EMAIL.getErrorKey(), "Email already taken");
            }

            // Password
            if(ValidationUtil.isNullOrBlank(password)){
                password = null;
            } else if (!ValidationUtil.isValidPassword(password)) {
                errors.put(ProductFields.PASSWORD.getErrorKey(), "8-32 characters with uppercase, lowercase, number & special character");
            }

            // Role
            if(ValidationUtil.isNullOrBlank(role)) role = "Product";

            if (errors.isEmpty()) {
                if (productService.update(productId, PasswordHasher.hash(password), fullName, email, role)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed product creation
                    errors.put("specialError", "Product update failed");
                }
            }
            // Reload CSRF token
            ServletUtil.refreshCsrfToken(req, respMap);

            // Send response back
            respMap.put("errors", errors);

            JsonUtil.sendJsonResp(resp, respMap, HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Delete request received");

        Map<String, String> errors = new HashMap<>();
        Map<String, Object> respMap = new HashMap<>();

        Map<String, String> reqMap = ServletUtil.basicFormCheck(req, resp, errors, respMap);

        if(reqMap != null) {
            String productId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                productId = action.substring(requestUrl.length() + 1);
            } else {
                productId = reqMap.get(ProductFields.USER_ID.getPropertyKey());
            }

            // Field validation
            // Product Id
            if(ValidationUtil.isNullOrBlank(productId)) {
                errors.put(ProductFields.USER_ID.getErrorKey(), "Product Id cannot be empty!");
            } else if (productService.findById(productId) == null) {
                errors.put(ProductFields.USER_ID.getErrorKey(), "Product Id does not exist");
            }

            if (errors.isEmpty()) {
                if (productService.delete(productId)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed product deletion
                    errors.put("specialError", "Product deletion failed");
                }
            }
            // Reload CSRF token
            ServletUtil.refreshCsrfToken(req, respMap);

            // Send response back
            respMap.put("errors", errors);

            JsonUtil.sendJsonResp(resp, respMap, HttpServletResponse.SC_BAD_REQUEST);
        }
    } */
}
