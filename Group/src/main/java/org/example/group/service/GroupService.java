package org.example.group.service;

import org.example.group.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> showGroups();
    GroupDTO getGroupById(Long id);
    GroupDTO updateGroup(GroupDTO groupDTO);
    GroupDTO addGroup(GroupDTO group);
    Boolean deleteGroup(GroupDTO group);


}
