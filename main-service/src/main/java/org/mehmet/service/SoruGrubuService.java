package org.mehmet.service;


import org.mehmet.repository.ISoruGrubuRepository;
import org.mehmet.repository.entity.SoruGrubu;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SoruGrubuService extends ServiceManager<SoruGrubu,Long> {
    private final ISoruGrubuRepository soruGrubuRepository;

    public SoruGrubuService(ISoruGrubuRepository soruGrubuRepository) {
        super(soruGrubuRepository);
        this.soruGrubuRepository = soruGrubuRepository;
    }
}
