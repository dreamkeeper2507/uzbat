package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Street;
import uz.bat.service.StreetService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StreetController
{
    @Autowired
    StreetService streetService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/street-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("streetList", streetService.all());
        return "street/street-view";
    }

    @RequestMapping(value = "/street-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Street street = new Street();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            street = streetService.findOne(id);
        }
        model.addAttribute("street", street);
        return "street/street-edit";
    }

    @RequestMapping(value = "/street-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/street-view";
    }

    @RequestMapping(value = "/street-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Street street = new Street();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/street-view";
    }
}
