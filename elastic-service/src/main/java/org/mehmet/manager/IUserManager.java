package org.mehmet.manager;



import org.mehmet.repository.entity.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



import java.util.List;

/**
 * Başka bir microserviceteki endpointleri çağırmak için kullanılır
 * Ulaşmak istediğiniz controllerın url bilgisini vermelisiniz
 * Tüm feign işlemlerine benzersiz adlandırmalar yapılmalıdır
 * */
@FeignClient(url= "${raceapplication.url.user}v1/api/user", name="user-service-profile", decode404 = true)
public interface IUserManager {

    @GetMapping("/findallelastic")
    ResponseEntity<List<UserProfile>> findAllElastic();
}
