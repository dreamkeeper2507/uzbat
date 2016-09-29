package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.common.ErrorText;
import uz.bat.model.entity.UserProfile;
import uz.bat.service.UserProfileService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserProfilerController
{
    @Autowired
    UserProfileService userProfileService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/userProfile-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {
        if (request.getSession().getAttribute("errorMessage") != null)
        {
            model.addAttribute("errorMessage", ErrorText.REMOVE_ERROR.getError());
            request.getSession().removeAttribute("errorMessage");
        }
        model.addAttribute("userProfileList", userProfileService.all());
        return "userProfile/userProfile-view";
    }

    @RequestMapping(value = "/userProfile-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        UserProfile userProfile = new UserProfile();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            userProfile = userProfileService.findOne(id);
        }
        model.addAttribute("userProfile", userProfile);
        return "userProfile/userProfile-edit";
    }

    @RequestMapping(value = "/userProfile-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
        return "redirect:/userProfile-view";
    }

    @RequestMapping(value = "/userProfile-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {
        try
        {


            UserProfile userProfile = new UserProfile();
            Long id = Long.valueOf(request.getParameter("id"));
        } catch (Exception ex)
        {

            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/userProfile-view";
    }
}
