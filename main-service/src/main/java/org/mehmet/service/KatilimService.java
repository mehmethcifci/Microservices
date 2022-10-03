package org.mehmet.service;


import org.mehmet.repository.IKatilimRepository;
import org.mehmet.repository.entity.Katilim;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KatilimService extends ServiceManager<Katilim,Long> {
    private final IKatilimRepository katilimRepository;

    public KatilimService(IKatilimRepository katilimRepository) {
        super(katilimRepository);
        this.katilimRepository = katilimRepository;
    }
}
