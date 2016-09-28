package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Street;

import uz.bat.service.StreetService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StreetController
{
    @Autowired
    StreetService streetService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/street-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("streetList", streetService.all());
        return "street/street-view";
    }

    @RequestMapping(value = "/street-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Street street = new Street();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            street = streetService.findOne(id);
        }
        model.addAttribute("street", street);
        model.addAttribute("regionList", streetService.allRegions());
        return "street/street-edit";
    }

    @RequestMapping(value = "/street-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String name = request.getParameter("name");

        Long regionId = null;

        logger.info(name + ":");
        Street street = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                street = streetService.findOne(id);
        } else
            street = new Street();

        street.setName(name);
        if (request.getParameter("regionId") != null && !request.getParameter("regionId").equals(""))
        {
            regionId = Long.valueOf(request.getParameter("regionId"));

        }
        if (regionId != null && regionId > (long) 0)
            street.setRegion(streetService.findOneRegion(regionId));
        streetService.create(street);
        logger.info(street.toString());
        return "redirect:/street-view";
    }

    @RequestMapping(value = "/street-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)
            streetService.remove(id);


        return "redirect:/street-view";
    }
}
