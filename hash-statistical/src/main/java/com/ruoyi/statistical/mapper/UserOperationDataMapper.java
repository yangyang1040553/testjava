package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.UserOperationData;

/**
 * 玩家运营数据Mapper接口
 * 
 * @author xxk
 * @date 2022-05-28
 */
public interface UserOperationDataMapper 
{
    /**
     * 查询玩家运营数据
     * 
     * @param id 玩家运营数据主键
     * @return 玩家运营数据
     */
    public UserOperationData selectUserOperationDataById(String id);

    /**
     * 查询玩家运营数据列表
     * 
     * @param userOperationData 玩家运营数据
     * @return 玩家运营数据集合
     */
    public List<UserOperationData> selectUserOperationDataList(UserOperationData userOperationData);

    /**
     * 新增玩家运营数据
     * 
     * @param userOperationData 玩家运营数据
     * @return 结果
     */
    public int insertUserOperationData(UserOperationData userOperationData);

    /**
     * 修改玩家运营数据
     * 
     * @param userOperationData 玩家运营数据
     * @return 结果
     */
    public int updateUserOperationData(UserOperationData userOperationData);

    /**
     * 删除玩家运营数据
     * 
     * @param id 玩家运营数据主键
     * @return 结果
     */
    public int deleteUserOperationDataById(String id);

    /**
     * 批量删除玩家运营数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserOperationDataByIds(String[] ids);
}