package server;


import com.google.gson.Gson;
import models.BirdSeen;
import models.BirdsStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/birds")
public class BirdSeenAPI {

    //create
    @PostMapping
    @ResponseBody
    public ModelAndView createBirdSeen(
            @RequestParam("speciesName") String speciesName, @RequestParam("locationSeen") String locationSeen, @RequestParam("id") String dateSeen)
    {
        BirdSeen birdSeen = new BirdSeen(speciesName, locationSeen,dateSeen);
        BirdsStorage.birds.put(birdSeen.id, birdSeen);

        //user explanation of method
        System.out.println("This is an example of the create method of CRUD and post method of REST");

        return new ModelAndView( "redirect:/birds");
    }

    //read all
    @GetMapping
    @ResponseBody
    public List<BirdSeen> getAllBirdsSeen(){
        Collection<BirdSeen> birds = BirdsStorage.birds.values();

        //user explanation of method
        System.out.println("This is an example of the read method of CRUD and get method of REST");

        return new ArrayList<>(birds);
    }

    //read one
    @GetMapping("/id")
    @ResponseBody
    public BirdSeen getOneBirdSeen(@PathVariable("id") int id){
        BirdSeen result = BirdsStorage.birds.get(id);

        //user explanation of method
        System.out.println("This is an example of the read method of CRUD and get method of REST");

        return  result;
    }

    //update
    @PutMapping("/{id}")
    @ResponseBody
    public BirdSeen updateBirdSeen(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        BirdSeen newBirdSeen = gson.fromJson(body, BirdSeen.class);

        BirdSeen birdSeen = BirdsStorage.birds.get(id);
        birdSeen.speciesName = newBirdSeen.speciesName;
        birdSeen.locationSeen = newBirdSeen.locationSeen;
        birdSeen.dateSeen = newBirdSeen.dateSeen;

        //user explanation of method
        System.out.println("This is an example of the update method of CRUD and put method of REST");
        System.out.println("The bird you've entered has been added to storage." +
                "as noted below");

        return birdSeen;
    }

    //destroy
    @DeleteMapping("/{id}")
    @ResponseBody
    public BirdSeen deleteBirdSeen(@PathVariable("id") int id){
        BirdSeen birdSeen = BirdsStorage.birds.get(id);
        BirdsStorage.birds.remove(id);

        //user explanation of method
        System.out.println("This is an example of the delete method of CRUD and destroy method of REST");
        System.out.println("The bird seen below is now removed from storage");

        return birdSeen;
    }


}
