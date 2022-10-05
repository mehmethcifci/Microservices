package org.mehmet.repository.entity;

import org.mehmet.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblyarismasorulari")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class YarismaSorulari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long soru_id;
    Long yarisma_id;
    Long sure;
    int sirano;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.ONAYLANMIS;
    @Embedded
    TableAdd tableAdd;

}
