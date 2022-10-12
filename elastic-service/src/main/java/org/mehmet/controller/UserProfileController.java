package org.mehmet.controller;

import lombok.RequiredArgsConstructor;
import org.mehmet.repository.entity.UserProfile;
import org.mehmet.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.mehmet.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfile userProfile){
        userProfileService.save(userProfile);
        return ResponseEntity.ok(true);
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UserProfile userProfile){
        userProfileService.update(userProfile);
        return ResponseEntity.ok(true);
    }
    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody UserProfile userProfile){
        userProfileService.delete(userProfile);
        return ResponseEntity.ok(true);
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<Iterable<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

}
