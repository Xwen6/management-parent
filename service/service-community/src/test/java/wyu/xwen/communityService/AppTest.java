package wyu.xwen.communityService;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import wyu.xwen.communityService.entity.vo.DeviceQuery;
import wyu.xwen.communityService.entity.vo.DeviceVo;
import wyu.xwen.communityService.mapper.EsDeviceMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = CommunityApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Autowired
    EsDeviceMapper esDeviceMapper;
    @Test
    public void shouldAnswerWithTrue()
    {
        List<DeviceVo> deviceVos = esDeviceMapper.pageList(1, 3, new DeviceQuery());
    }
}
