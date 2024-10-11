package lk.ijse.gdse.fxproject2.dto;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor

public class CustomerDto {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}
