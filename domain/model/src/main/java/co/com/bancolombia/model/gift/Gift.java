package co.com.bancolombia.model.gift;

import co.com.bancolombia.model.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {
    private UUID id;
    private String name;
    private Status status;
}
