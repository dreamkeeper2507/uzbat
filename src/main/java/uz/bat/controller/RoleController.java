package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Role;
import uz.bat.service.RoleService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RoleController
{
    @Autowired
    RoleService roleService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/role-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("roleList", roleService.all());
        return "role/role-view";
    }

    @RequestMapping(value = "/role-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Role role = new Role();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            role = roleService.findOne(id);
        }
        model.addAttribute("role", role);
        return "role/role-edit";
    }

    @RequestMapping(value = "/role-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/role-view";
    }

    @RequestMapping(value = "/role-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Role role = new Role();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/role-view";
    }
}
