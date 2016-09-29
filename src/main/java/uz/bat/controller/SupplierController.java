package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.common.ErrorText;
import uz.bat.common.RemoveException;
import uz.bat.model.entity.Supplier;
import uz.bat.service.SupplierService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class SupplierController
{
    @Autowired
    SupplierService supplierService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/supplier-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {
        if (request.getSession().getAttribute("errorMessage") != null)
        {
            model.addAttribute("errorMessage", ErrorText.REMOVE_ERROR.getError());
            request.getSession().removeAttribute("errorMessage");
        }
        model.addAttribute("supplierList", supplierService.all());
        return "supplier/supplier-view";
    }

    @RequestMapping(value = "/supplier-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Supplier supplier = new Supplier();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            supplier = supplierService.findOne(id);
        }
        model.addAttribute("supplier", supplier);
        return "supplier/supplier-edit";
    }

    @RequestMapping(value = "/supplier-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String name = request.getParameter("name");


        Supplier supplier = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                supplier = supplierService.findOne(id);
        } else
            supplier = new Supplier();

        supplier.setName(name);

        supplierService.create(supplier);
        logger.info(supplier.toString());
        return "redirect:/supplier-view";
    }

    @RequestMapping(value = "/supplier-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {
        try
        {
            Long id = Long.valueOf(request.getParameter("id"));
            if (id != null)
                supplierService.remove(id);

        } catch (Exception ex)
        {

            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/supplier-view";
    }
}
