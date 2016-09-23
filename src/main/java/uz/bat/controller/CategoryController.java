package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Category;
import uz.bat.service.CategoryService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/category-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("categoryList", categoryService.all());
        return "category/category-view";
    }

    @RequestMapping(value = "/category-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Category category = new Category();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            category = categoryService.findOne(id);
        }
        model.addAttribute("category", category);
        return "category/category-edit";
    }

    @RequestMapping(value = "/category-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/category-view";
    }

    @RequestMapping(value = "/category-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Category category = new Category();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/category-view";
    }
}
