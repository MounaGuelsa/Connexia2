package org.example.group.service;

import org.example.group.dto.GroupDTO;

public interface GroupService {
    GroupDTO addGroup(GroupDTO group);
    Boolean deleteGroup(GroupDTO group);
}
