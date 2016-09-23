package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Store;
import uz.bat.service.StoreService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StoreController
{
    @Autowired
    StoreService storeService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/store-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("storeList", storeService.all());
        return "store/store-view";
    }

    @RequestMapping(value = "/store-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Store store = new Store();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            store = storeService.findOne(id);
        }
        model.addAttribute("store", store);
        return "store/store-edit";
    }

    @RequestMapping(value = "/store-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/store-view";
    }

    @RequestMapping(value = "/store-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Store store = new Store();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/store-view";
    }
}
