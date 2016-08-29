package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String startProcess(Model model, HttpServletRequest request)
    {

        model.addAttribute("addressList", addressRepository.findAll());
        return "address/address-view";
    }

}
