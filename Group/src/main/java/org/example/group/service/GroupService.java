package org.example.group.service;

import org.example.group.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> showGroups();
    List<GroupDTO> findGroupByAdmin(Long admin_id);
    GroupDTO getGroupById(Long id);
    GroupDTO updateGroup(Long id ,GroupDTO groupDTO);
    GroupDTO addGroup(GroupDTO group);
    Boolean deleteGroup(GroupDTO group);
    List<GroupDTO> findAllGroupsByGroupIds(List<Long> groupIds);
}
