package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.common.ErrorText;
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
    public String view(Model model, HttpServletRequest request, String errorMessage)
    {
        if (request.getSession().getAttribute("errorMessage") != null)
        {
            model.addAttribute("errorMessage", request.getSession().getAttribute("errorMessage"));
            request.getSession().removeAttribute("errorMessage");
        }
        model.addAttribute("productUnitList", productUnitService.all());
        return "productUnit/productUnit-view";
    }

    @RequestMapping(value = "/productUnit-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        ProductUnit productUnit = new ProductUnit();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
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
        String unitName = request.getParameter("unitName");


        ProductUnit productUnit = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                productUnit = productUnitService.findOne(id);
        } else
            productUnit = new ProductUnit();

        productUnit.setUnitName(unitName);

        productUnitService.create(productUnit);
        logger.info(productUnit.toString());
        return "redirect:/productUnit-view";
    }

    @RequestMapping(value = "/productUnit-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)

    {
        try
        {
            Long id = Long.valueOf(request.getParameter("id"));
            if (id != null)
                productUnitService.remove(id);

        } catch (Exception e)
        {
            logger.info(e.getMessage());
            request.getSession().setAttribute("errorMessage", ErrorText.REMOVE_ERROR.getError());
        }
        return "redirect:/productUnit-view";
    }
}
