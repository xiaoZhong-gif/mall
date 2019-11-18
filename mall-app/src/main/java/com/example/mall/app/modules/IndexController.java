package com.example.mall.app.modules;

import com.example.mall.app.configure.SystemProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    SystemProperties systemProperties;

    /**
     *
     */
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("version", systemProperties.getVersion());
        modelAndView.addObject("build", systemProperties.getBuild());
        modelAndView.setViewName("index/index");
        return modelAndView;
    }

    /**
     * @return
     */
    @GetMapping("/doc")
    public ModelAndView doc() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/swagger-ui.html");
        return modelAndView;
    }

}
