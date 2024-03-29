package org.example.groupuser.service;

import org.example.group.dto.GroupDTO;
import org.example.groupuser.dto.GroupUserDTO;

import java.util.List;

public interface GrouUserService {
    List<GroupUserDTO> showGroupUsers();
    List<GroupDTO> findGroupByUserId(Long userId);
    GroupUserDTO getGroupUserById(Long id);
//    GroupUserDTO updateGroupUser(GroupUserDTO groupUserDTO);
    GroupUserDTO addGroupUser(GroupUserDTO groupUserDTO);
    Boolean deleteGroupUser(GroupUserDTO groupUserDTO);

}