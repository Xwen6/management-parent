package wyu.xwen.loginservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import wyu.xwen.feignApi.client.CommunityAdminClient;
import wyu.xwen.loginservice.entity.EsAdmin;
import wyu.xwen.loginservice.mapper.EsAdminMapper;
import wyu.xwen.loginservice.service.EsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-21
 */
@Service
public class EsAdminServiceImpl extends ServiceImpl<EsAdminMapper, EsAdmin> implements EsAdminService {

  /*  @Autowired
    private CommunityAdminClient client;*/


    @Override
    public String login(Map<String,String> data) {
        String username = data.get("username");
        String password = data.get("password");
        /*判断账号密码是否正确*/
        QueryWrapper<EsAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);

        EsAdmin esAdmin = baseMapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(esAdmin)){
           throw new RuntimeException("该账号不存在");
        }
        else {
            if (!esAdmin.getPassword().equals(password)){
                throw new RuntimeException("密码错误");
            }
        }

        return esAdmin.getId().toString();
    }
}
