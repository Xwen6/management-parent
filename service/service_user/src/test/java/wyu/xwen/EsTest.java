package wyu.xwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import wyu.xwen.userservice.UserApplication;
import wyu.xwen.userservice.entity.EsPet;
import wyu.xwen.userservice.entity.EsUserInfo;
import wyu.xwen.userservice.entity.EsVehicle;

@SpringBootTest(classes = UserApplication.class)
public class EsTest {

    @Autowired
    ElasticsearchRestTemplate restTemplate;

    @Test
    void createIndex() {
        restTemplate.createIndex(EsPet.class);
        restTemplate.putMapping(EsPet.class);
    }
}
