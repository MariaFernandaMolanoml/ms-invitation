package co.com.bancolombia.jpa.gift;

import co.com.bancolombia.model.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gift")
public class GiftData {
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;
}