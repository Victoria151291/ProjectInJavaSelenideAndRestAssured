package resourcesClasses;

public class BodiesForShoppingList {

    public static String getBodyFroNewList() {
        return "{\"name\":\"New list\"}";
    }

    public static String getBodyForItem() {
        return "{\"items\":[{\"name\":\"Bread\",\"imageUrl\":\"https://whisk-res.cloudinary.com/image/upload/v1550764815/graph/fooddb/3de2656e1d6ee9afcdcd28f4429d2caa.jpg\"," +
                "\"isNew\":true,\"addToRecent\":true,\"localId\":\"operation_237a53c2-a7d3-4288-bccf-f2b2792847a1\"}],\"sync\":1587069564168}";
    }

    public static String getBodyToDeleteItem(String item) {
        return "{\"items\":[{\"id\":\"" + item + "\",\"deleted\":true}],\"sync\":1587070131488}";
    }

}