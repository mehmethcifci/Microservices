package org.mehmet.service;


import org.mehmet.repository.IYarismaRepository;
import org.mehmet.repository.entity.Yarisma;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class YarismaService extends ServiceManager<Yarisma,Long> {
    private final IYarismaRepository yarismaRepository;

    public YarismaService(IYarismaRepository yarismaRepository) {
        super(yarismaRepository);
        this.yarismaRepository = yarismaRepository;
    }
}
