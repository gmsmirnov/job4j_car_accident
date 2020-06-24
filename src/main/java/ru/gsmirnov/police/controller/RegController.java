package ru.gsmirnov.police.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gsmirnov.police.model.User;
import ru.gsmirnov.police.repository.AuthorityRepository;
import ru.gsmirnov.police.repository.UserRepository;

/**
 * The controller which accepts requests to user-registry page.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-21
 */
@Controller
public class RegController {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(RegController.class);

    /**
     * The users repository.
     */
    private final UserRepository userRepository;

    /**
     * The authorities repository.
     */
    private final AuthorityRepository authorityRepository;

    /**
     * The password encoder service.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * The controller's constructor. Injects repositories.
     *
     * @param userRepository users repository.
     * @param authorityRepository authorities repository.
     */
    @Autowired
    public RegController(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Accepts GET requests to registration page.
     *
     * @return registration view.
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "reg";
    }

    /**
     * Accepts requests for registration of new users.
     *
     * @param user a new user.
     * @return login page view.
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regUser(@ModelAttribute User user) {
        User newUser = new User(
                user.getName(),
                this.passwordEncoder.encode(user.getPassword()),
                true,
                this.authorityRepository.findByAuthorityName("ROLE_USER"));
        LOG.info(String.format("Регистрируем нового пользователя: %s", newUser));
        this.userRepository.save(newUser);
        return "redirect:/login.do";
    }
}
