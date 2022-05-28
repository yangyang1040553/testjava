package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.UserOperationDataMapper;
import com.ruoyi.statistical.domain.UserOperationData;
import com.ruoyi.statistical.service.IUserOperationDataService;

/**
 * 玩家运营数据Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-28
 */
@Service
public class UserOperationDataServiceImpl implements IUserOperationDataService 
{
    @Autowired
    private UserOperationDataMapper userOperationDataMapper;

    /**
     * 查询玩家运营数据
     * 
     * @param id 玩家运营数据主键
     * @return 玩家运营数据
     */
    @Override
    public UserOperationData selectUserOperationDataById(String id)
    {
        return userOperationDataMapper.selectUserOperationDataById(id);
    }

    /**
     * 查询玩家运营数据列表
     * 
     * @param userOperationData 玩家运营数据
     * @return 玩家运营数据
     */
    @Override
    public List<UserOperationData> selectUserOperationDataList(UserOperationData userOperationData)
    {
        return userOperationDataMapper.selectUserOperationDataList(userOperationData);
    }

    /**
     * 新增玩家运营数据
     * 
     * @param userOperationData 玩家运营数据
     * @return 结果
     */
    @Override
    public int insertUserOperationData(UserOperationData userOperationData)
    {
        return userOperationDataMapper.insertUserOperationData(userOperationData);
    }

    /**
     * 修改玩家运营数据
     * 
     * @param userOperationData 玩家运营数据
     * @return 结果
     */
    @Override
    public int updateUserOperationData(UserOperationData userOperationData)
    {
        return userOperationDataMapper.updateUserOperationData(userOperationData);
    }

    /**
     * 批量删除玩家运营数据
     * 
     * @param ids 需要删除的玩家运营数据主键
     * @return 结果
     */
    @Override
    public int deleteUserOperationDataByIds(String[] ids)
    {
        return userOperationDataMapper.deleteUserOperationDataByIds(ids);
    }

    /**
     * 删除玩家运营数据信息
     * 
     * @param id 玩家运营数据主键
     * @return 结果
     */
    @Override
    public int deleteUserOperationDataById(String id)
    {
        return userOperationDataMapper.deleteUserOperationDataById(id);
    }
}
