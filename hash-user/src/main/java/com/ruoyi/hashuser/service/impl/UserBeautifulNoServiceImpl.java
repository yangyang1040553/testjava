package com.ruoyi.hashuser.service.impl;

import java.util.List;

import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.mapper.HashUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserBeautifulNoMapper;
import com.ruoyi.hashuser.domain.UserBeautifulNo;
import com.ruoyi.hashuser.service.IUserBeautifulNoService;

/**
 * 用户靓号申请Service业务层处理
 *
 * @author xxk
 * @date 2022-08-29
 */
@Service
public class UserBeautifulNoServiceImpl implements IUserBeautifulNoService {
    @Autowired
    private UserBeautifulNoMapper userBeautifulNoMapper;


    @Autowired
    private HashUserMapper hashUserMapper;

    /**
     * 查询用户靓号申请
     *
     * @param id 用户靓号申请主键
     * @return 用户靓号申请
     */
    @Override
    public UserBeautifulNo selectUserBeautifulNoById(String id) {
        return userBeautifulNoMapper.selectUserBeautifulNoById(id);
    }

    /**
     * 查询用户靓号申请列表
     *
     * @param userBeautifulNo 用户靓号申请
     * @return 用户靓号申请
     */
    @Override
    public List<UserBeautifulNo> selectUserBeautifulNoList(UserBeautifulNo userBeautifulNo) {
        return userBeautifulNoMapper.selectUserBeautifulNoList(userBeautifulNo);
    }

    /**
     * 新增用户靓号申请
     *
     * @param userBeautifulNo 用户靓号申请
     * @return 结果
     */
    @Override
    public int insertUserBeautifulNo(UserBeautifulNo userBeautifulNo) {

        if (userBeautifulNo.getId() == null) {
            throw new CaptchaException("账号不能为空！");
        }

        if (checkIdAndCode(userBeautifulNo, false) > 0) {
            return -1;
        }

        userBeautifulNo.setCreateTime(DateUtils.getNowDate());
        return userBeautifulNoMapper.insertUserBeautifulNo(userBeautifulNo);
    }


    /**
     * ID  CODE   均不能重复
     *
     * @param userBeautifulNo
     * @return
     */
    public int checkIdAndCode(UserBeautifulNo userBeautifulNo, boolean isEdith) {
        if (hashUserMapper.selectHashUserByCode(userBeautifulNo.getCode()) != null) {
            return 1;
        }

        if (!isEdith) {
            if (userBeautifulNoMapper.selectUserBeautifulNoById(userBeautifulNo.getId()) != null) {
                return 1;
            }
        }
        List<UserBeautifulNo> userBeautifulNos = userBeautifulNoMapper.selectUserBeautifulNoByCode(userBeautifulNo.getCode());
        if (userBeautifulNos != null && userBeautifulNos.size() > 0) {
            return 1;
        }
        return -1;
    }

    /**
     * 修改用户靓号申请
     *
     * @param userBeautifulNo 用户靓号申请
     * @return 结果
     */
    @Override
    public int updateUserBeautifulNo(UserBeautifulNo userBeautifulNo) {

        if (checkIdAndCode(userBeautifulNo, true) > 0) {
            return -1;
        }
        return userBeautifulNoMapper.updateUserBeautifulNo(userBeautifulNo);
    }

    /**
     * 批量删除用户靓号申请
     *
     * @param ids 需要删除的用户靓号申请主键
     * @return 结果
     */
    @Override
    public int deleteUserBeautifulNoByIds(String[] ids) {
        return userBeautifulNoMapper.deleteUserBeautifulNoByIds(ids);
    }

    /**
     * 删除用户靓号申请信息
     *
     * @param id 用户靓号申请主键
     * @return 结果
     */
    @Override
    public int deleteUserBeautifulNoById(String id) {
        return userBeautifulNoMapper.deleteUserBeautifulNoById(id);
    }
}
