package org.mehmet.repository.entity;


import org.mehmet.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblsorugrubu")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SoruGrubu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String grupadi;
    @Enumerated(EnumType.STRING)
    State state = State.ONAYLANMIS;
    @Embedded
    TableAdd tableAdd;
}
