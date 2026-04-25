package co.com.bancolombia.model.invitations;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invitation {
    private UUID id;
    private String name_person;
    private Long number_cell;
    private Status status;
    private Date create_date;
    private Date confirm_date;
    private Gift gift;
}
