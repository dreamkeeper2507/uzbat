package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Address;
import uz.bat.model.repository.AddressRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Malikov Kamil on 29.08.2016.
 */
@Controller
public class AddressController
{
    @Autowired
    AddressRepository addressRepository;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/address-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("addressList", addressRepository.findAll());
        return "address/address-view";
    }

    @RequestMapping(value = "/address-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Address address = new Address();

        Long id = Long.valueOf(request.getParameter("id"));
        logger.info("addres edit id:" + id);
        if (id != null && id > (long) 0)
        {
            address = addressRepository.findOne(id);
        }
        model.addAttribute("address", address);
        return "address/address-edit";
    }

    @RequestMapping(value = "/address-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
        logger.info("address save:" + id);

        return "redirect:/address-view";
    }

    @RequestMapping(value = "/address-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Address address = new Address();

        Long id = Long.valueOf(request.getParameter("id"));
        logger.info("address delete:" + id);

        return "redirect:/address-view";
    }
}
