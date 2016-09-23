package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.StoreStatus;
import uz.bat.service.StoreStatusService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StoreStatusController
{
    @Autowired
    StoreStatusService storeStatusService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/storeStatus-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("storeStatusList", storeStatusService.all());
        return "storeStatus/storeStatus-view";
    }

    @RequestMapping(value = "/storeStatus-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        StoreStatus storeStatus = new StoreStatus();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            storeStatus = storeStatusService.findOne(id);
        }
        model.addAttribute("storeStatus", storeStatus);
        return "storeStatus/storeStatus-edit";
    }

    @RequestMapping(value = "/storeStatus-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/storeStatus-view";
    }

    @RequestMapping(value = "/storeStatus-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        StoreStatus storeStatus = new StoreStatus();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/storeStatus-view";
    }
}
