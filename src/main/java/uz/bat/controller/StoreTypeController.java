package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.StoreType;
import uz.bat.service.StoreTypeService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StoreTypeController
{
    @Autowired
    StoreTypeService storeTypeService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/storeType-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("storeTypeList", storeTypeService.all());
        return "storeType/storeType-view";
    }

    @RequestMapping(value = "/storeType-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        StoreType storeType = new StoreType();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            storeType = storeTypeService.findOne(id);
        }
        model.addAttribute("storeType", storeType);
        return "storeType/storeType-edit";
    }

    @RequestMapping(value = "/storeType-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/storeType-view";
    }

    @RequestMapping(value = "/storeType-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        StoreType storeType = new StoreType();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/storeType-view";
    }
}
