package org.mehmet.service;


import org.mehmet.repository.IDereceYapanlarRepository;
import org.mehmet.repository.entity.DereceYapanlar;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DereceYapanlarService extends ServiceManager<DereceYapanlar,Long> {
    private final IDereceYapanlarRepository dereceYapanlarRepository;

    public DereceYapanlarService(IDereceYapanlarRepository dereceYapanlarRepository) {
        super(dereceYapanlarRepository);
        this.dereceYapanlarRepository = dereceYapanlarRepository;
    }
}
