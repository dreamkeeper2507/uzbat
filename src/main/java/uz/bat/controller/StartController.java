package uz.bat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StartController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startProcess(Model model, HttpServletRequest request)
    {

        return "redirect:address-view";
    }
}
