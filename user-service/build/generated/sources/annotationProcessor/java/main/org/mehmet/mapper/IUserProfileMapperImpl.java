package org.mehmet.mapper;

import javax.annotation.processing.Generated;
import org.mehmet.dto.request.EditProfileRequestDto;
import org.mehmet.repository.entity.UserProfile;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-11T15:37:02+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile toUserProfile(EditProfileRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder userProfile = UserProfile.builder();

        userProfile.username( dto.getUsername() );
        userProfile.name( dto.getName() );
        userProfile.surname( dto.getSurname() );
        userProfile.email( dto.getEmail() );
        userProfile.phone( dto.getPhone() );
        userProfile.photo( dto.getPhoto() );
        userProfile.address( dto.getAddress() );
        userProfile.about( dto.getAbout() );

        return userProfile.build();
    }
}
