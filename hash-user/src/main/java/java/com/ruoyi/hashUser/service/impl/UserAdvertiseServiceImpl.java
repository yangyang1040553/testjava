package java.com.ruoyi.hashUser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.UserAdvertiseMapper;
import com.ruoyi.hashUser.domain.UserAdvertise;
import com.ruoyi.hashUser.service.IUserAdvertiseService;

/**
 * 广告管理Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-05
 */
@Service
public class UserAdvertiseServiceImpl implements IUserAdvertiseService 
{
    @Autowired
    private UserAdvertiseMapper userAdvertiseMapper;

    /**
     * 查询广告管理
     * 
     * @param id 广告管理主键
     * @return 广告管理
     */
    @Override
    public UserAdvertise selectUserAdvertiseById(Long id)
    {
        return userAdvertiseMapper.selectUserAdvertiseById(id);
    }

    /**
     * 查询广告管理列表
     * 
     * @param userAdvertise 广告管理
     * @return 广告管理
     */
    @Override
    public List<UserAdvertise> selectUserAdvertiseList(UserAdvertise userAdvertise)
    {
        return userAdvertiseMapper.selectUserAdvertiseList(userAdvertise);
    }

    /**
     * 新增广告管理
     * 
     * @param userAdvertise 广告管理
     * @return 结果
     */
    @Override
    public int insertUserAdvertise(UserAdvertise userAdvertise)
    {
        userAdvertise.setCreateTime(DateUtils.getNowDate());
        return userAdvertiseMapper.insertUserAdvertise(userAdvertise);
    }

    /**
     * 修改广告管理
     * 
     * @param userAdvertise 广告管理
     * @return 结果
     */
    @Override
    public int updateUserAdvertise(UserAdvertise userAdvertise)
    {
        userAdvertise.setUpdateTime(DateUtils.getNowDate());
        return userAdvertiseMapper.updateUserAdvertise(userAdvertise);
    }

    /**
     * 批量删除广告管理
     * 
     * @param ids 需要删除的广告管理主键
     * @return 结果
     */
    @Override
    public int deleteUserAdvertiseByIds(Long[] ids)
    {
        return userAdvertiseMapper.deleteUserAdvertiseByIds(ids);
    }

    /**
     * 删除广告管理信息
     * 
     * @param id 广告管理主键
     * @return 结果
     */
    @Override
    public int deleteUserAdvertiseById(Long id)
    {
        return userAdvertiseMapper.deleteUserAdvertiseById(id);
    }
}
