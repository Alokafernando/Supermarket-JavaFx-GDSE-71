package lk.ijse.gdse.fxproject2.dto.tm;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemTM {
    private String item_id;
    private String name;
    private int  quantity;
    private double price;
}
