package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Phone;
import uz.bat.service.PhoneService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PhoneController
{
    @Autowired
    PhoneService phoneService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/phone-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("phoneList", phoneService.all());
        return "phone/phone-view";
    }

    @RequestMapping(value = "/phone-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Phone phone = new Phone();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            phone = phoneService.findOne(id);
        }
        model.addAttribute("phone", phone);
        return "phone/phone-edit";
    }

    @RequestMapping(value = "/phone-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/phone-view";
    }

    @RequestMapping(value = "/phone-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Phone phone = new Phone();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/phone-view";
    }
}
