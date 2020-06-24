package ru.gsmirnov.police.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Login controller.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-11
 */
@Controller
public class LoginController {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(LoginController.class);

    /**
     * Shows login form.
     *
     * @param error error indicator, for example incorrect login/password.
     * @param logout logout indicator.
     * @param model the model map which contains attributes with linked objects.
     * @return login view.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Имя пользователя или пароль некорректны!";
        }
        if (logout != null) {
            errorMessage = "Вы успешно вышли из системы";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    /**
     * Logout mapping.
     *
     * @param request http-request.
     * @param response http-response.
     * @return login view with logout message.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login.do?logout=true";
    }
}
