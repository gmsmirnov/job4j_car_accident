package ru.gsmirnov.police.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gsmirnov.police.service.AccidentService;

/**
 * The main-page controller. Accepts requests to the 'accidents'-page.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-14
 */
@Controller
public class IndexController {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(IndexController.class);

    /**
     * The service which provides business logic level for accidents.
     */
    private final AccidentService accidentService;

    /**
     * The IndexController constructor.
     *
     * @param accidentService the service which provides business logic level for accidents.
     */
    @Autowired
    public IndexController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    /**
     * Forms the list of all accidents for displaying on web page.
     * Also displays entered user name.
     *
     * @param model the model map which contains attributes with linked objects.
     * @return index-view.
     */
    @RequestMapping(value = "/accidents", method = RequestMethod.GET)
    public String showAccidents(ModelMap model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("index", this.accidentService.getAllAccidents());
        return "index";
    }
}