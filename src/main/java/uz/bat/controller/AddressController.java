package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.common.ErrorText;
import uz.bat.model.entity.Address;
import uz.bat.service.AddressService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AddressController
{
    @Autowired
    AddressService addressService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/address-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {
        if (request.getSession().getAttribute("errorMessage") != null)
        {
            model.addAttribute("errorMessage", ErrorText.REMOVE_ERROR.getError());
            request.getSession().removeAttribute("errorMessage");
        }
        model.addAttribute("addressList", addressService.all());
        return "address/address-view";
    }

    @RequestMapping(value = "/address-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Address address = new Address();
        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            address = addressService.findOne(id);
        }
        model.addAttribute("address", address);
        model.addAttribute("streetList", addressService.allStreets());

        return "address/address-edit";
    }

    @RequestMapping(value = "/address-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {

        String addressStr = request.getParameter("address");
        Address address = null;
        Long streetId = null;
        if (request.getParameter("streetId") != null)
        {
            streetId = Long.valueOf(request.getParameter("streetId"));

        }
        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                address = addressService.findOne(id);
        } else
            address = new Address();
        if (streetId != null && streetId > (long) 0)
            address.setStreet(addressService.findStreetById(streetId));
        address.setAddress(addressStr);
        addressService.create(address);
        logger.info(address.toString());
        return "redirect:/address-view";
    }

    @RequestMapping(value = "/address-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {


        Long id = Long.valueOf(request.getParameter("id"));
        try
        {
            if (id != null)
                addressService.remove(id);
        } catch (Exception ex)
        {

            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/address-view";
    }
}
