package org.mehmet.graphql.mutation;

import lombok.RequiredArgsConstructor;
import org.mehmet.graphql.model.UserProfileInput;
import org.mehmet.repository.entity.UserProfile;
import org.mehmet.service.UserProfileService;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {

    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput profile){

        userProfileService.save(UserProfile.builder()
                        .id(454_543L)
                        .authid(profile.getAuthid())
                        .username(profile.getUsername())
                        .name(profile.getName())
                        .surname(profile.getSurname())
                .build());
        return true;
    }

}
