package com.api;

import static com.util.ServletUtil.*;

import com.constants.CategoryFields;
import com.dto.CategoryDTO;
import com.dto.OutboundCategoryDTO;
import com.service.CategoryService;
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

@WebServlet("/api/categories/*")
public class CategoryAPI extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CategoryAPI.class.getName());
    private static final CategoryService categoryService = new CategoryService();
    private static final ProductService productService = new ProductService();
    private static final String requestUrl = "/categories";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        logger.info("Get request received");

        if(action.length() == requestUrl.length()) {
            JsonUtil.sendJsonResp(resp, categoryService.findAll(), HttpServletResponse.SC_OK);
        } else {
            List<String> actionPath = Arrays.stream(action.substring(requestUrl.length() + 1).split("/")).toList();

            switch (actionPath.size()) {
                case 1 -> {
                    if(actionPath.getFirst().equals("products")) {
                        List<OutboundCategoryDTO> categoryList = categoryService.findAll();
                        List<Map<String, Object>> dataList = new ArrayList<>();
                        for(OutboundCategoryDTO categoryDTO : categoryList) {
                            Map<String, Object> dataMap = new HashMap<>();
                            dataMap.put(CategoryFields.CATEGORY_ID.getPropertyKey(), categoryDTO.getCategoryId());
                            dataMap.put(CategoryFields.CATEGORY_NAME.getPropertyKey(), categoryDTO.getCategoryName());
                            dataMap.put(CategoryFields.PRODUCT_COUNT.getPropertyKey(), categoryDTO.getProductCount());
                            dataMap.put("products", productService.findByCategory(categoryDTO.getCategoryId()));
                            dataList.add(dataMap);
                        }
                        JsonUtil.sendJsonResp(resp, dataList, HttpServletResponse.SC_OK);
                    } else {
                        try {
                            Integer categoryId = Integer.parseInt(actionPath.getFirst());
                            CategoryDTO categoryDTO = categoryService.findById(categoryId);
                            if(categoryDTO == null) {
                                JsonUtil.sendJsonResp(resp, new OutboundCategoryDTO(), HttpServletResponse.SC_NOT_FOUND);
                            } else {
                                JsonUtil.sendJsonResp(resp, categoryDTO, HttpServletResponse.SC_OK);
                            }
                        } catch (NumberFormatException e) {
                            JsonUtil.sendJsonResp(resp, Map.of("error", "Malformed url"), HttpServletResponse.SC_BAD_REQUEST);
                        }
                    }
                }
                case 2 -> {
                    if(actionPath.get(1).equals("products")) {
                        try {
                            Integer categoryId = Integer.parseInt(actionPath.getFirst());
                            OutboundCategoryDTO categoryDTO = categoryService.findById(categoryId);
                            if(categoryDTO == null) {
                                JsonUtil.sendJsonResp(resp, new OutboundCategoryDTO(), HttpServletResponse.SC_NOT_FOUND);
                            } else {
                                Map<String, Object> dataMap = new HashMap<>();
                                dataMap.put(CategoryFields.CATEGORY_ID.getPropertyKey(), categoryDTO.getCategoryId());
                                dataMap.put(CategoryFields.CATEGORY_NAME.getPropertyKey(), categoryDTO.getCategoryName());
                                dataMap.put(CategoryFields.PRODUCT_COUNT.getPropertyKey(), categoryDTO.getProductCount());
                                dataMap.put("products", productService.findByCategory(categoryDTO.getCategoryId()));
                                JsonUtil.sendJsonResp(resp, dataMap, HttpServletResponse.SC_OK);
                            }
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
            String categoryId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                categoryId = action.substring(requestUrl.length() + 1);
            } else {
                categoryId = reqMap.get(CategoryFields.USER_ID.getPropertyKey());
            }
            String password = reqMap.get(CategoryFields.PASSWORD.getPropertyKey());
            String fullName = reqMap.get(CategoryFields.FULL_NAME.getPropertyKey());
            String email = reqMap.get(CategoryFields.EMAIL.getPropertyKey());
            String role = reqMap.get(CategoryFields.ROLE.getPropertyKey());

            // Field validation
            ValidationUtil.validateCategoryId(categoryId, errors);
            ValidationUtil.validateFullName(fullName, errors);
            ValidationUtil.validateEmail(email, errors);
            ValidationUtil.validatePassword(password, errors);
            if(ValidationUtil.isNullOrBlank(role)) role = "Category";

            if (errors.isEmpty()) {
                if (categoryService.create(categoryId, PasswordHasher.hash(password), fullName, email, role)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed category creation
                    errors.put("specialError", "Category creation failed");
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
            String categoryId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                categoryId = action.substring(requestUrl.length() + 1);
            } else {
                categoryId = reqMap.get(CategoryFields.USER_ID.getPropertyKey());
            }
            String password = reqMap.get(CategoryFields.PASSWORD.getPropertyKey());
            String fullName = reqMap.get(CategoryFields.FULL_NAME.getPropertyKey());
            String email = reqMap.get(CategoryFields.EMAIL.getPropertyKey());
            String role = reqMap.get(CategoryFields.ROLE.getPropertyKey());

            // Field validation
            // Category Id
            if(ValidationUtil.isNullOrBlank(categoryId)) {
                errors.put(CategoryFields.USER_ID.getErrorKey(), "Category Id cannot be empty!");
            } else if (categoryService.findById(categoryId) == null) {
                errors.put(CategoryFields.USER_ID.getErrorKey(), "Category Id does not exist");
            }

            // Full name
            if(ValidationUtil.isNullOrBlank(fullName)) fullName = null;

            // Email
            if(ValidationUtil.isNullOrBlank(email)) {
                email = null;
            } else if (!ValidationUtil.isValidEmail(email)) {
                errors.put(CategoryFields.EMAIL.getErrorKey(), "Email is invalid!");
            } else if (categoryService.findByEmail(email) != null) {
                errors.put(CategoryFields.EMAIL.getErrorKey(), "Email already taken");
            }

            // Password
            if(ValidationUtil.isNullOrBlank(password)){
                password = null;
            } else if (!ValidationUtil.isValidPassword(password)) {
                errors.put(CategoryFields.PASSWORD.getErrorKey(), "8-32 characters with uppercase, lowercase, number & special character");
            }

            // Role
            if(ValidationUtil.isNullOrBlank(role)) role = "Category";

            if (errors.isEmpty()) {
                if (categoryService.update(categoryId, PasswordHasher.hash(password), fullName, email, role)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed category creation
                    errors.put("specialError", "Category update failed");
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
            String categoryId;
            if (action.length() != requestUrl.length()) {
                if(!action.startsWith(requestUrl + "/")) {
                    JsonUtil.sendJsonResp(resp, new HashMap<>(Map.of("forbiddenError", "Malformed url")), HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
                categoryId = action.substring(requestUrl.length() + 1);
            } else {
                categoryId = reqMap.get(CategoryFields.USER_ID.getPropertyKey());
            }

            // Field validation
            // Category Id
            if(ValidationUtil.isNullOrBlank(categoryId)) {
                errors.put(CategoryFields.USER_ID.getErrorKey(), "Category Id cannot be empty!");
            } else if (categoryService.findById(categoryId) == null) {
                errors.put(CategoryFields.USER_ID.getErrorKey(), "Category Id does not exist");
            }

            if (errors.isEmpty()) {
                if (categoryService.delete(categoryId)) {
                    JsonUtil.sendJsonRedirect(resp, "");
                    return;
                } else {
                    // If failed category deletion
                    errors.put("specialError", "Category deletion failed");
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
