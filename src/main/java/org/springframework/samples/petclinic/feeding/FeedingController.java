package org.springframework.samples.petclinic.feeding;

import javax.validation.Valid;

import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

    private FeedingService feedingService;
    private PetService petService;

    public FeedingController(FeedingService feedingService, PetService petService){
        this.feedingService = feedingService;
        this.petService = petService;
    }

    public static final String VIEW_FEEDING_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";

    @GetMapping("/create")
    public String initCreationForm(ModelMap modelMap){

        String view = VIEW_FEEDING_CREATE_OR_UPDATE_FORM;
        modelMap.addAttribute("feeding", new Feeding());
        modelMap.addAttribute("feedingType", this.feedingService.getAllFeedingTypes());
        modelMap.addAttribute("pet", this.petService.getAllPets());
        return view;

    }

    

    
}
