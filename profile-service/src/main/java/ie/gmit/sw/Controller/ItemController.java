package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.Item;
import ie.gmit.sw.Service.ItemService;
import ie.gmit.sw.domain.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping( path = "/item/new", method = RequestMethod.POST)
    public ProfileResponse newUserDetail(@RequestBody Item item) throws Throwable {
        return itemService.createItem(item);
    }

    @RequestMapping( path = "/item/delete", method = RequestMethod.POST)
    public ProfileResponse deleteUserDetail(@RequestParam("title") String title) throws Throwable {
        return itemService.deleteItem(title);
    }

    @RequestMapping( path = "/item", method = RequestMethod.GET)
    public List<Item> getUserDetail(@RequestParam("email") String email) throws Throwable {
        return itemService.getItemByEmail(email);
    }

    @RequestMapping( path = "/item/all", method = RequestMethod.GET)
    public List<Item> getUserDetail() throws Throwable {
        return itemService.getAllItems();
    }
}
