package lk.ijse.gdse.fxproject2.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDto {
    private String item_id;
    private String name;
    private int  quantity;
    private double price;
}
