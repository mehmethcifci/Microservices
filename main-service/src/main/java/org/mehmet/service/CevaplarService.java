package org.mehmet.service;


import org.mehmet.dto.request.CevaplarRequestDto;
import org.mehmet.repository.ICevaplarRepository;
import org.mehmet.repository.entity.Cevaplar;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CevaplarService extends ServiceManager<Cevaplar,Long> {
    private final ICevaplarRepository cevaplarRepository;

    public CevaplarService(ICevaplarRepository cevaplarRepository) {
        super(cevaplarRepository);
        this.cevaplarRepository = cevaplarRepository;
    }

    public void soruCevaplariniEkle(List<CevaplarRequestDto> dto, Long soruId){
        dto.forEach(cevap->{
            save(Cevaplar.builder()
                    .soru_id(soruId)
                    .istrue(cevap.isDogrucevapmi())
                    .cevap(cevap.getCevapicerigi())
                    .build());
        });
    }
}