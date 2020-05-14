package ru.gsmirnov.police.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gsmirnov.police.model.Accident;
import ru.gsmirnov.police.service.AccidentService;

/**
 * Accident controller. Operates with create accident page.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-05-15
 */
@Controller
public class AccidentController {
    /**
     * The logger.
     */
    private static final Logger LOG = LogManager.getLogger(AccidentController.class);

    /**
     * The service which provides business logic level for accidents.
     */
    private final AccidentService accidentService;

    /**
     * The AccidentController constructor.
     *
     * @param accidentService the service which provides business logic level for accidents.
     */
    @Autowired
    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    /**
     * Shows create accident form.
     *
     * @return create accident view.
     */
    @RequestMapping(value = "/add_accident", method = RequestMethod.GET)
    public String create() {
        return "create";
    }

    /**
     * Accepts request with a new accident. Transfers it to the logic level.
     *
     * @param accident a new accident.
     * @param model updated model with the added accident.
     * @return index view with the added accident.
     */
    @RequestMapping(value = "/add_accident", method = RequestMethod.POST)
    public String addAccident(@ModelAttribute Accident accident,
                              ModelMap model) {
        this.accidentService.add(accident);
        model.addAttribute("index", this.accidentService.getAllAccidents());
        return "index";
    }
}