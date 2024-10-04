package lk.ijse.gdse.fxproject2.dto.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class CustomerTM {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}
