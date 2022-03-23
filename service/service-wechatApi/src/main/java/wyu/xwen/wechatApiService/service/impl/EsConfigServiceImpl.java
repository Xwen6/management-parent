package wyu.xwen.wechatApiService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import wyu.xwen.wechatApiService.entity.EsConfig;
import wyu.xwen.wechatApiService.mapper.EsConfigMapper;
import wyu.xwen.wechatApiService.service.EsConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统配置 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-03-23
 */
@Service
public class EsConfigServiceImpl extends ServiceImpl<EsConfigMapper, EsConfig> implements EsConfigService {

    @Override
    public List<EsConfig> getSystemConfig() {
        List<EsConfig> list = new ArrayList<>();
        QueryWrapper<EsConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("config_group","system");
        list = baseMapper.selectList(wrapper);
        return list;
    }
}
