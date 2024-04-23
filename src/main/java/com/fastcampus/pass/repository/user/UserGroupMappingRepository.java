package com.fastcampus.pass.repository.user;

import java.util.List;

public interface UserGroupMappingRepository {
    List<UserGroupMappingEntity> findByUserGroupId(String userGroupId);
}
