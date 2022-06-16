package reqres.models.ozzi;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SuggestedTapTags {
    private Items suggestedTapTags;
}

@Data
 class CellTrackingInfo {
    private String id;
    private String type;
    private int index;
    private String suggestType;
    private String searchString;
    private String suggestValue;
}

@Data
 class Item {
    private String title;
    private CellTrackingInfo cellTrackingInfo;
}

@Data
class Items {
    private ArrayList<Item> items;
}

