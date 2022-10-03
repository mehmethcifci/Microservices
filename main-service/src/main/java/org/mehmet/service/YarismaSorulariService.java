package org.mehmet.service;


import org.mehmet.repository.IYarismaSorulariRepository;
import org.mehmet.repository.entity.YarismaSorulari;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class YarismaSorulariService extends ServiceManager<YarismaSorulari,Long> {
    private final IYarismaSorulariRepository yarismaSorulariRepository;

    public YarismaSorulariService(IYarismaSorulariRepository yarismaSorulariRepository) {
        super(yarismaSorulariRepository);
        this.yarismaSorulariRepository = yarismaSorulariRepository;
    }
}
