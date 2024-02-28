package org.example.group.service.serviceImp;

import org.example.group.dto.GroupDTO;
import org.example.group.entity.Group;
import org.example.group.repository.GroupRepository;
import org.example.group.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<GroupDTO> showGroups() {
        List<Group> groups=groupRepository.findByDeletedFalse();
        return groups.stream().map(g->modelMapper.map(g,GroupDTO.class)).collect(Collectors.toList());
    }

    @Override
    public GroupDTO getGroupById(Long id) {
        return modelMapper.map(groupRepository.findById(id),GroupDTO.class);
    }

    @Override
    public GroupDTO updateGroup(GroupDTO groupDTO) {
        return modelMapper.map(groupRepository.save(modelMapper.map(groupDTO, Group.class)),GroupDTO.class);
    }

    @Override
    public GroupDTO addGroup(GroupDTO groupDTO) {
        Group group=groupRepository.save(modelMapper.map(groupDTO, Group.class));
        return modelMapper.map(group, GroupDTO.class);
    }

    @Override
    public Boolean deleteGroup(GroupDTO groupDTO) {
        groupDTO.setDeleted(Boolean.TRUE);
        Group group=groupRepository.save(modelMapper.map(groupDTO, Group.class));
        return group.getDeleted();
    }
}
