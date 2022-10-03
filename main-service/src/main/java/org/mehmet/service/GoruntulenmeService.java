package org.mehmet.service;


import org.mehmet.repository.IGoruntulenmeRepository;
import org.mehmet.repository.entity.Goruntulenme;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class GoruntulenmeService extends ServiceManager<Goruntulenme,Long> {
    private final IGoruntulenmeRepository goruntulenmeRepository;

    public GoruntulenmeService(IGoruntulenmeRepository goruntulenmeRepository) {
        super(goruntulenmeRepository);
        this.goruntulenmeRepository = goruntulenmeRepository;
    }

}
