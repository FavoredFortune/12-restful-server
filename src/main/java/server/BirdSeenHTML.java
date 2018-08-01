package server;

import models.BirdSeen;
import models.BirdsStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/birds")
public class BirdSeenHTML {

    //list all birds seen page
    @GetMapping
    public String showAllBirdsSeen(Model model){
        Collection<BirdSeen> birds = BirdsStorage.birds.values();
        List<BirdSeen> listBirds = new ArrayList<>(birds);

        model.addAttribute("birds", birds);

        return "allBirds";
    }

    // create/add bird HTML form
    @GetMapping("/new")
    public String createBirdSeenForm(){
        return "createBird";
    }

    // update/change bird HTML form
    @GetMapping("/{id}/edit")
    public String editBirdForm(
            @PathVariable("id") int id,
            Model model
    ) {
        BirdSeen birdUpdate = BirdsStorage.birds.get(id);

        model.addAttribute("speciesName", birdUpdate.speciesName);
        model.addAttribute("locationSeen", birdUpdate.locationSeen);
        model.addAttribute("dateSeen", birdUpdate.dateSeen);

        System.out.println("TWEET TWEET");
        return "editBird";
    }
}
