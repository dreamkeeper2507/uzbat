package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Company;

import uz.bat.service.CompanyService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CompanyController
{
    @Autowired
    CompanyService companyService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/company-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("companyList", companyService.all());
        return "company/company-view";
    }

    @RequestMapping(value = "/company-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Company company = new Company();

        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            company = companyService.findOne(id);
        }
        model.addAttribute("company", company);
        return "company/company-edit";
    }

    @RequestMapping(value = "/company-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String companyName = request.getParameter("companyName");
        String description = request.getParameter("description");



        Company company = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                company = companyService.findOne(id);
        } else
            company = new Company();

        company.setCompanyName(companyName);
        company.setDescription(description);



        companyService.create(company);
        logger.info(company.toString());
             return "redirect:/company-view";
    }

    @RequestMapping(value = "/company-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)

            companyService.remove(id);
        return "redirect:/company-view";
    }
}
