package ie.gmit.sw.Service;

import ie.gmit.sw.Model.Item;
import ie.gmit.sw.domain.ProfileResponse;

import java.util.List;

public interface ItemService {
    public ProfileResponse createItem(Item item) throws Exception;
    //public ProfileResponse updateItem(Item item);
    public ProfileResponse deleteItem(String title);
    public List<Item> getAllItems();
    public List<Item> getItemByEmail(String email);
    public Item getItemByTitle(String title);
}
