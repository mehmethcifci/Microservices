package org.mehmet.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.mehmet.repository.entity.UserProfile;
import org.mehmet.service.UserProfileService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileQueryResolver implements GraphQLQueryResolver {

    private final UserProfileService userProfileService;

    public Iterable<UserProfile> findAll(){
        return userProfileService.findTop1000();
    }

    public List<UserProfile>  findAllByUsername(String userName){
        return userProfileService.findAllByUserName(userName);
    }

    public List<String> bulBakalimBunlariEmailListesiniGetir(){
        return userProfileService.findAllEmailList();
    }
}
