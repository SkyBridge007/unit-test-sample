package org.michael.sample.manager;


import java.util.List;

import org.michael.sample.bo.UserInfoBO;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 上午9:33:33
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
public interface UserInfoManager {

    Boolean saveUserInfo(UserInfoBO userInfoBO);

    Boolean updateUserInfo(UserInfoBO userInfoBO);

    UserInfoBO getUserInfoByUserId(Long userId);

    UserInfoBO getUserInfoByMobile(String mobile);

    List<UserInfoBO> listUserInfoByUserIds(List<Long> userIds);

    Boolean removeUserInfoByUserId(Long userId);
}
