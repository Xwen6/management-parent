package wyu.xwen.userservice.service;

import wyu.xwen.userservice.entity.EsPet;
import com.baomidou.mybatisplus.extension.service.IService;
import wyu.xwen.userservice.entity.PetQuery;

import java.util.Map;

/**
 * <p>
 * 宠物信息表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-17
 */
public interface EsPetService extends IService<EsPet> {

    boolean addPet(EsPet esPet);

    boolean deletePet(Integer id);

    boolean batchDelete(Integer[] ids);

    boolean updatePet(EsPet pet);

    Map<String, Object> pageList(Integer current, Integer limit, PetQuery petQuery);

    EsPet etPetById(Integer id);
}
