package org.artificial.language.controller;

import org.artificial.language.model.Sentence;
import org.artificial.language.model.User;
import org.artificial.language.model.Word;
import org.artificial.language.service.SentenceService;
import org.artificial.language.service.UserService;
import org.artificial.language.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private WordService wordService;

    @Autowired
    private SentenceService sentenceService;


    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/askNick")
    public String askNick(@RequestParam("question") String question) {
        Word word = wordService.findByName(question);
        if(word != null){
            List<Sentence> list = sentenceService.listByWord(word);
            int index = ThreadLocalRandom.current().nextInt(list.size());
            return list.get(index).getName();
        }else
            return "Sorry I did not understand what you mean";
    }
}
