package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.State;
import uz.bat.service.StateService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StateController
{
    @Autowired
    StateService stateService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/state-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("stateList", stateService.all());
        return "state/state-view";
    }

    @RequestMapping(value = "/state-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        State state = new State();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            state = stateService.findOne(id);
        }
        model.addAttribute("state", state);
        return "state/state-edit";
    }

    @RequestMapping(value = "/state-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/state-view";
    }

    @RequestMapping(value = "/state-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        State state = new State();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/state-view";
    }
}
