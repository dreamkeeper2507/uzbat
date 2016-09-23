package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Person;
import uz.bat.service.PersonService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PersonController
{
    @Autowired
    PersonService personService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/person-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("personList", personService.all());
        return "person/person-view";
    }

    @RequestMapping(value = "/person-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Person person = new Person();

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            person = personService.findOne(id);
        }
        model.addAttribute("person", person);
        return "person/person-edit";
    }

    @RequestMapping(value = "/person-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("idObject"));
             return "redirect:/person-view";
    }

    @RequestMapping(value = "/person-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Person person = new Person();

        Long id = Long.valueOf(request.getParameter("id"));


        return "redirect:/person-view";
    }
}
