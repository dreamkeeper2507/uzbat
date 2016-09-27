package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Store;

import uz.bat.service.StoreService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StoreController
{
    @Autowired
    StoreService storeService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/store-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("storeList", storeService.all());
        return "store/store-view";
    }

    @RequestMapping(value = "/store-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Store store = new Store();

        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            store = storeService.findOne(id);
        }
        model.addAttribute("store", store);
        model.addAttribute("personList", storeService.allPersons());
        model.addAttribute("storeTypeList", storeService.allStoreTypes());
        model.addAttribute("addressList", storeService.allAddress());
        return "store/store-edit";
    }

    @RequestMapping(value = "/store-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String storeName = request.getParameter("storeName");
        String location = request.getParameter("location");
        Store store = null;

        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                store = storeService.findOne(id);
        } else
            store = new Store();

        Long addressId = null;
        if (request.getParameter("addressId") != null)
        {
            addressId = Long.valueOf(request.getParameter("addressId"));

        }
        if (addressId != null && addressId > (long) 0)
            store.setAddressBean(storeService.findAddressById(addressId));

        Long personId = null;
        if (request.getParameter("personId") != null)
        {
            personId = Long.valueOf(request.getParameter("personId"));

        }
        if (personId != null && personId > (long) 0)
            store.setPerson(storeService.findPersonById(personId));

        Long storeTypeId = null;
        if (request.getParameter("storeTypeId") != null)
        {
            storeTypeId = Long.valueOf(request.getParameter("storeTypeId"));

        }
        if (storeTypeId != null && storeTypeId > (long) 0)
            store.setStoretype(storeService.findStoreTypeById(storeTypeId));

        store.setLocation(location);
        store.setStoreName(storeName);
        storeService.create(store);
        logger.info(store.toString());
        return "redirect:/store-view";
    }

    @RequestMapping(value = "/store-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)
            storeService.remove(id);


        return "redirect:/store-view";
    }
}
