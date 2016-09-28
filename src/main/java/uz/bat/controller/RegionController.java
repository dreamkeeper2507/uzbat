package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uz.bat.model.entity.Region;

import uz.bat.service.RegionService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegionController
{
    @Autowired
    RegionService regionService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/region-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("regionList", regionService.all());
        return "region/region-view";
    }

    @RequestMapping(value = "/region-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Region region = new Region();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            region = regionService.findOne(id);
        }
        model.addAttribute("region", region);
        model.addAttribute("stateList", regionService.allStates());
        return "region/region-edit";
    }

    @RequestMapping(value = "/region-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        Long stateId = null;

        logger.info(name + ":" + code);
        Region region = null;
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                region = regionService.findOne(id);
        } else
            region = new Region();

        region.setName(name);
        region.setCode(code);
        if (request.getParameter("stateId") != null && !request.getParameter("stateId").equals(""))
        {
            stateId = Long.valueOf(request.getParameter("stateId"));

        }
        if (stateId != null && stateId > (long) 0)
            region.setState(regionService.findOneState(stateId));
        regionService.create(region);
        logger.info(region.toString());
        return "redirect:/region-view";
    }

    @RequestMapping(value = "/region-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)
            regionService.remove(id);

        return "redirect:/region-view";
    }
}
