package com.springapp.mvc.Controller;

import com.springapp.Service.ShopService;
import com.springapp.dao.ShopRepository;
import com.springapp.mvc.model.ShopForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    ShopService shopService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value="/{name}",method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public ShopForm getShopInJSON(@PathVariable String name,ModelMap model) {

        ShopForm shopForm = new ShopForm();
        shopForm.setName(name);
        shopForm.setStaffName("atif");

        return shopForm;

    }

    @RequestMapping("/add.htm")
    public ModelAndView add(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {


        return new ModelAndView("hello","message","me");

    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String student(ModelMap model) {
        model.addAttribute("shopForm", new ShopForm());
        //model.addAttribute("shops", shopService.findAllShops());
        //model.addAttribute("shops", shopService.findByName("gg"));
        model.addAttribute("shops", shopService.findByStaff("nn"));
        return "shop";
    }

    @RequestMapping(value = "/addShop", method = RequestMethod.POST)
    public String addShop(@Valid ShopForm shopForm, BindingResult result) {

        if (result.hasErrors()) {
            return "shop";
        }

        shopService.addShop(shopForm);

        return "redirect:/shop";
    }
}