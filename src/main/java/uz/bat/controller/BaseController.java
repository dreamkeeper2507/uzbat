package uz.bat.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.bat.common.RemoveException;


import java.util.Locale;

@ControllerAdvice
public class BaseController
{

    @ExceptionHandler(RemoveException.class)
    public ModelAndView exception(RemoveException e) {

        ModelAndView mav = new ModelAndView("exception");

        mav.addObject("message", "Удаление не возможно! Проверьтие зависимости!");

        return mav;
    }
}
