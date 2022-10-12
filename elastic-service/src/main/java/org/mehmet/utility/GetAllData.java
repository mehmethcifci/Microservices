package org.mehmet.utility;

import lombok.RequiredArgsConstructor;
import org.mehmet.manager.IUserManager;
import org.mehmet.service.UserProfileService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final UserProfileService userProfileService;
    private final IUserManager userManager;

    @PostConstruct
    public void init(){

    userProfileService.saveAll(userManager.findAllElastic().getBody());

    }

}
