package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.User;
import uz.bat.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController
{
    @Autowired
    UserService userService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/user-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("userList", userService.all());
        return "user/user-view";
    }

    @RequestMapping(value = "/user-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        User user = new User();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            user = userService.findOne(id);
        }
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    @RequestMapping(value = "/user-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/user-view";
    }

    @RequestMapping(value = "/user-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        User user = new User();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/user-view";
    }
}
