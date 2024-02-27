package org.example.group.service.serviceImp;

import org.example.group.dto.GroupDTO;
import org.example.group.entity.Group;
import org.example.group.repository.GroupRepository;
import org.example.group.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public GroupDTO addGroup(GroupDTO groupDTO) {
        Group group=groupRepository.save(modelMapper.map(groupDTO,Group.class));
        return modelMapper.map(group, GroupDTO.class);
    }

    @Override
    public Boolean deleteGroup(GroupDTO groupDTO) {
        groupDTO.setIs_deleted(Boolean.TRUE);
        Group group=groupRepository.save(modelMapper.map(groupDTO,Group.class));
        return group.getIs_deleted();
    }
}
