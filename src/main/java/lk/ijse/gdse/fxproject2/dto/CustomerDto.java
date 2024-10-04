package lk.ijse.gdse.fxproject2.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDto {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}
