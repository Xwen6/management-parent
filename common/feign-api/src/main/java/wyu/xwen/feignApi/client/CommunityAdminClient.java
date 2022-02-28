package wyu.xwen.feignApi.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "communityService",path = "CommunityAdmin")
public interface CommunityAdminClient {

    @GetMapping("getCCodeByAId/{adminId}")
    public String getCCode(@PathVariable Integer adminId );



}
