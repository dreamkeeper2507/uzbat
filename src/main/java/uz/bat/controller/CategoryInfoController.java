package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.CategoryInfo;
import uz.bat.service.CategoryInfoService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CategoryInfoController
{
    @Autowired
    CategoryInfoService categoryInfoService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/categoryInfo-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("categoryInfoList", categoryInfoService.all());
        return "categoryInfo/categoryInfo-view";
    }

    @RequestMapping(value = "/categoryInfo-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        CategoryInfo categoryInfo = new CategoryInfo();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            categoryInfo = categoryInfoService.findOne(id);
        }
        model.addAttribute("categoryInfo", categoryInfo);
        return "categoryInfo/categoryInfo-edit";
    }

    @RequestMapping(value = "/categoryInfo-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/categoryInfo-view";
    }

    @RequestMapping(value = "/categoryInfo-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        CategoryInfo categoryInfo = new CategoryInfo();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/categoryInfo-view";
    }
}
