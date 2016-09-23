package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Country;
import uz.bat.service.CountryService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CountryController
{
    @Autowired
    CountryService countryService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/country-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("countryList", countryService.all());
        return "country/country-view";
    }

    @RequestMapping(value = "/country-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Country country = new Country();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            country = countryService.findOne(id);
        }
        model.addAttribute("country", country);
        return "country/country-edit";
    }

    @RequestMapping(value = "/country-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/country-view";
    }

    @RequestMapping(value = "/country-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Country country = new Country();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/country-view";
    }
}
