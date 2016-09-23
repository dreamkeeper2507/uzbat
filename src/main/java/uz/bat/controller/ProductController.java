package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Product;
import uz.bat.service.ProductService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProductController
{
    @Autowired
    ProductService productService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/product-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("productList", productService.all());
        return "product/product-view";
    }

    @RequestMapping(value = "/product-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Product product = new Product();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            product = productService.findOne(id);
        }
        model.addAttribute("product", product);
        return "product/product-edit";
    }

    @RequestMapping(value = "/product-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/product-view";
    }

    @RequestMapping(value = "/product-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Product product = new Product();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/product-view";
    }
}
