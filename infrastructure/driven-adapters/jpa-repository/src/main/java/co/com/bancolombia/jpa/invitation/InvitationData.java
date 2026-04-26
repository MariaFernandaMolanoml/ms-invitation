package co.com.bancolombia.jpa.invitation;

import co.com.bancolombia.jpa.gift.GiftData;
import co.com.bancolombia.model.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invitation")
public class InvitationData {

    @Id
    private UUID id;

    @Column(name = "name_person")
    private String name_person;
    @Column(name = "number_cell")
    private String number_cell;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "confirm_date")
    private Date confirm_date;

    @ManyToOne
    @JoinColumn(name = "gift_id")
    private GiftData gift;
}