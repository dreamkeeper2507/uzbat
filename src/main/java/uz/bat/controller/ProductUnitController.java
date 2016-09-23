package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.ProductUnit;
import uz.bat.service.ProductUnitService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProductUnitController
{
    @Autowired
    ProductUnitService productUnitService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/productUnit-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("productUnitList", productUnitService.all());
        return "productUnit/productUnit-view";
    }

    @RequestMapping(value = "/productUnit-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        ProductUnit productUnit = new ProductUnit();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            productUnit = productUnitService.findOne(id);
        }
        model.addAttribute("productUnit", productUnit);
        return "productUnit/productUnit-edit";
    }

    @RequestMapping(value = "/productUnit-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/productUnit-view";
    }

    @RequestMapping(value = "/productUnit-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        ProductUnit productUnit = new ProductUnit();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/productUnit-view";
    }
}
