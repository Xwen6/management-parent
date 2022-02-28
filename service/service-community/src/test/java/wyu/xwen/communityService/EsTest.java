package wyu.xwen.communityService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import wyu.xwen.communityService.entity.EsParkingSpace;
import wyu.xwen.communityService.entity.EsParkingSpaceUse;

@SpringBootTest(classes = CommunityApplication.class)
public class EsTest {

    @Autowired
    ElasticsearchRestTemplate restTemplate;


    @Test
    void createIndex() {

       restTemplate.createIndex(EsParkingSpaceUse.class);
      restTemplate.putMapping(EsParkingSpaceUse.class);



    }
}
