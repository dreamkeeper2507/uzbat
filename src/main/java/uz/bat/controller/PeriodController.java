package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Period;
import uz.bat.service.PeriodService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PeriodController
{
    @Autowired
    PeriodService periodService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/period-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("periodList", periodService.all());
        return "period/period-view";
    }

    @RequestMapping(value = "/period-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Period period = new Period();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            period = periodService.findOne(id);
        }
        model.addAttribute("period", period);
        return "period/period-edit";
    }

    @RequestMapping(value = "/period-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/period-view";
    }

    @RequestMapping(value = "/period-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Period period = new Period();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/period-view";
    }
}
