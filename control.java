package Bid.Control;

import Bid.DAO.Dao1;
import Bid.Model.Bidactive;

import Bid.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Controller
public class control {
    String name1=null;
    @Autowired
    ProductServices service;
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/Admin")
    public ModelAndView admin(ModelAndView model)
    {
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        List<Bidactive> bidinactives=service.showProduct1();
        model.addObject("bidinactives",bidinactives);
        model.setViewName("Admin");
        return model;
    }
    @RequestMapping("/User1")
    public ModelAndView User1(ModelAndView model)
    {
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        model.setViewName("User1");
        return model;
    }
    @RequestMapping("/User2")
    public ModelAndView User2(ModelAndView model)
    {
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        model.setViewName("User2");
        return model;
    }
    @RequestMapping("/User3")
    public ModelAndView User3(ModelAndView model)
    {
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        model.setViewName("User3");
        return model;
    }
    @RequestMapping("/User4")
    public ModelAndView User4(ModelAndView model)
    {
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        model.setViewName("User4");
        return model;
    }

    @RequestMapping("/Productadd")
    public String admin(Model model)
    {   Bidactive bidactive = new Bidactive();
        model.addAttribute("bidactive",bidactive);
        return "AddProduct";
    }

    @RequestMapping("/ADD")
    public ModelAndView add(@ModelAttribute("bidactive")Bidactive bidactive,ModelAndView model1)
    {
       service.addProduct(bidactive);
       List<Bidactive> bidactives = service.showProduct();
       model1.addObject("bidactives", bidactives);
       List<Bidactive> bidinactives=service.showProduct1();
       model1.addObject("bidinactives",bidinactives);
       model1.setViewName("Admin");
       return model1;
    }
    @ModelAttribute("CDate")
    public String  createDate()
    {

        LocalDate today = LocalDate.now();

        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        return formattedDate ;
    }
    @RequestMapping("/Bid")
    public String bid(@RequestParam("id") String pid,@RequestParam("name") String name, Model model )
    {
        Dao1 d = new Dao1();
        Bidactive b = d.getProduct(Integer.parseInt(pid));
        model.addAttribute("bid",b);
        name1=name;
        System.out.println(pid+name);
        return "Bid";
    }
    @RequestMapping(value="/bid-product")
    public ModelAndView updateCustomer(Bidactive bidactive,ModelAndView model)
    {
        service.updateProduct(bidactive.getProductId(),bidactive.getProductName(), bidactive.getProductPrice(), bidactive.getBidStartDate(),bidactive.getBidEndDate(),name1, bidactive.getBidAmount());
        System.out.println("Customer Updated");
        List<Bidactive> bidactives=service.showProduct();
        model.addObject("bidactives",bidactives);
        if(Objects.equals(name1, "User1"))
        {
            model.setViewName("User1");
        }
        else if(Objects.equals(name1, "User2"))
        {
            model.setViewName("User2");
        }
        else if(Objects.equals(name1, "User3"))
        {
            model.setViewName("User3");
        }
        else
        {
            model.setViewName("User4");
        }

        return model;
    }




}
