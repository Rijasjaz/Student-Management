package com.project.storage.store;


import com.lowagie.text.DocumentException;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class StorageController {


    public StorageService storageService;


    //front view
    @RequestMapping(method = RequestMethod.GET,value = "/storage")
    public String register(){
        return "front";
    }

    //sending the entity to thymeleaf to fill the values in it
    @RequestMapping(method = RequestMethod.GET,value = "/getStudent")
    public String Request(Model model) {
        Storage storage=new Storage();
        model.addAttribute("store",storage);
        return "Second";
    }


    //storing the values in table
    @RequestMapping(method = RequestMethod.POST,value = "/post")
    public String post(@ModelAttribute("store") Storage storage){
       storageService.create(storage);
       return "redirect:/storage";
    }



    //displaying the values in table
    @RequestMapping(method = RequestMethod.GET,value = "/value")
    public String req(Model model){
        model.addAttribute("list",storageService.get());
        return "table";
    }

    //sending the entity to thymeleaf to fill the values in it
    @RequestMapping(method = RequestMethod.GET,value = "/getid")
    public String idfind(Model model) {
        Storage storage=new Storage();
        model.addAttribute("store",storage);
        return "find";
    }
    //sending the id value
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public String update(@ModelAttribute("store") Storage storage,Model model){
            model.addAttribute("idvalue",storageService.find(storage.getId()));
         return "editing";
    }

   // updating value
    @RequestMapping(method = RequestMethod.POST,value = "/updatevalue/{id}")
    public String updatevalue(@PathVariable Long id,@ModelAttribute("idvalue") Storage storage,Model model){
        storageService.update(id,storage);
        return "redirect:/storage";
    }
    //delete id
    @RequestMapping(method = RequestMethod.GET,value = "/deleteid")
    public String idfinddelete(Model model) {
        Storage storage=new Storage();
        model.addAttribute("store",storage);
        return "findid";
    }
    //delete
    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public String delete(@ModelAttribute("store") Storage storage,Model model){
      storageService.delete(storage.getId());
      return "redirect:/storage";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/download")
    public String download() throws DocumentException, IOException {
        storageService.download();
        return "redirect:/storage";
    }

}


