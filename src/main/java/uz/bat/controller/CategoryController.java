package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.common.ErrorText;
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
        if (request.getSession().getAttribute("errorMessage") != null)
        {
            model.addAttribute("errorMessage", ErrorText.REMOVE_ERROR.getError());
            request.getSession().removeAttribute("errorMessage");
        }
        model.addAttribute("categoryList", categoryService.all());
        return "category/category-view";
    }

    @RequestMapping(value = "/category-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Category category = new Category();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            category = categoryService.findOne(id);
        }
        model.addAttribute("category", category);
        model.addAttribute("categoryList", categoryService.all());
        return "category/category-edit";
    }

    @RequestMapping(value = "/category-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String categoryName = request.getParameter("categoryName");
        String categorydescription = request.getParameter("categorydescription");
        Long categoryId = null;
        if (request.getParameter("categoryId") != null && !request.getParameter("categoryId").equals(""))
        {
            categoryId = Long.valueOf(request.getParameter("categoryId"));

        }
        logger.info(categoryName + ":" + categorydescription);
        Category category = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                category = categoryService.findOne(id);
        } else
            category = new Category();

        category.setCategoryName(categoryName);
        category.setCategorydescription(categorydescription);
        if (categoryId != null && categoryId > (long) 0)
            category.setCategory(categoryService.findOne(categoryId));
        else
            category.setCategory(null);
        categoryService.create(category);
        logger.info(category.toString());
        return "redirect:/category-view";
    }

    @RequestMapping(value = "/category-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        try
        {
            Long id = Long.valueOf(request.getParameter("id"));
            try
            {
                if (id != null)
                    categoryService.remove(id);

            } catch (Exception e)
            {
                logger.info(e.getMessage());
            }
        } catch (Exception ex)
        {

            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/category-view";
    }
}
