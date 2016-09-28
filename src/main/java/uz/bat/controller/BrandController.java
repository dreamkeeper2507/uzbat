package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Brand;
import uz.bat.model.entity.Brand;
import uz.bat.service.BrandService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BrandController
{
    @Autowired
    BrandService brandService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/brand-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("brandList", brandService.all());
        return "brand/brand-view";
    }

    @RequestMapping(value = "/brand-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Brand brand = new Brand();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            brand = brandService.findOne(id);
        }
        model.addAttribute("brand", brand);
        model.addAttribute("companyList", brandService.allCompanys());
        return "brand/brand-edit";
    }

    @RequestMapping(value = "/brand-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String brandName = request.getParameter("brandName");
        String description = request.getParameter("description");
        Long companyId = null;
        if (request.getParameter("companyId") != null&& !request.getParameter("companyId").equals(""))
        {
            companyId = Long.valueOf(request.getParameter("companyId"));

        }
        logger.info(brandName + ":" + description);
        Brand brand = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                brand = brandService.findOne(id);
        } else
            brand = new Brand();

        brand.setBrandName(brandName);
        brand.setDescription(description);
        if (companyId != null && companyId > (long) 0)
            brand.setCompanyBean(brandService.findOneCompany(companyId));
        brandService.create(brand);
        logger.info(brand.toString());
             return "redirect:/brand-view";
    }

    @RequestMapping(value = "/brand-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)
            brandService.remove(id);


        return "redirect:/brand-view";
    }
}
