package org.mehmet.service;

import org.mehmet.dto.request.EditProfileRequestDto;
import org.mehmet.dto.request.NewUserCreateDto;
import org.mehmet.mapper.IUserProfileMapper;
import org.mehmet.repository.IUserProfileRepository;
import org.mehmet.repository.entity.UserProfile;
import org.mehmet.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository repository;
    @Autowired
    CacheManager cacheManager;
    public UserProfileService(IUserProfileRepository repository){
        super(repository);
        this.repository = repository;
    }

    public UserProfile createUserProfile(NewUserCreateDto dto){
        return save(UserProfile.builder()
                .authid(dto.getAuthid())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto dto, Long authid){
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        Optional<UserProfile> optionalUserProfile = repository.findOptionalByAuthid(authid);
        if(optionalUserProfile.isEmpty()) return false;
        try{
            userProfile.setId(optionalUserProfile.get().getId());
            update(userProfile);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter, String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage,pageSize,sort);
        return repository.findAll(pageable);
    }

    public Slice<UserProfile> findallSlice(int currentPage, int pageSize, String sortParameter, String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable slice = PageRequest.of(currentPage, pageSize, sort);
        return repository.findAll(slice);
    }

    public void clearCache(String key,String parameter){
        cacheManager.getCache(key).evict(parameter);
    }
    /**
     * [Method Ad??] :: [De??er] -> id
     * Clear ->
     * */
    @Cacheable(value = "userprofile_getall")
    public List<UserProfile> getAllCache() {

        return repository.findAll();

    }
}


