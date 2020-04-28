package com.eduk8s.hub.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.service.WorkshopService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class WebController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private WorkshopService service;


    @GetMapping("/")
    public ModelAndView mainsite(Map<String, Object> model) {
        model.put("workshops", service.getWorkshops());
        return new ModelAndView("index", model);
    }

    @GetMapping("/pages/install")
    public ModelAndView install(Map<String, Object> model) {
        return new ModelAndView("install", model);
    }
    
    @GetMapping("/pages/contact")
    public ModelAndView contact(Map<String, Object> model) {
        return new ModelAndView("contact", model);
    }

    @GetMapping("/pages/about")
    public ModelAndView about(Map<String, Object> model) {
        return new ModelAndView("about", model);
    }

    @GetMapping("/workshops/{workshop}/launch/")
    public ModelAndView launchWorkshop(@PathVariable(name="workshop") String workshopUID, HttpServletRequest request, Map<String, Object> model) {
        logger.info("Requesting {} workshop", workshopUID);
        final String callbackUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String url = service.startWorkshop(workshopUID, callbackUrl);
        if (url != null){
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
            return new ModelAndView("redirect:" + url);
        }else{
            // There's been an error and no workshop got started
            // TODO: Maybe show this in a different way
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/workshops/{workshop}/")
    public ModelAndView workshopInfo(@PathVariable(name="workshop") String workshopUID, HttpServletRequest request, Map<String, Object> model) {
        logger.info("Requesting info for workshop {}", workshopUID);
        WorkshopDefinition workshopDef = service.getWorkshop(workshopUID);
        model.put("workshop", workshopDef);
        model.put("no-search", "true");
        return new ModelAndView("/workshop");
    }

    // TODO: Remember to delete
    @GetMapping("/workshops-cv2")
    public ModelAndView workshopCV2( Map<String, Object> model) {
        model.put("no-search", "true");
        return new ModelAndView("/workshop");
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
        
            if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return "401";
            }
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}