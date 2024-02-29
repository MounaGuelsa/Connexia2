package org.example.groupuser.service.serviceImp;

import org.example.groupuser.config.ModelMapperConfig;
import org.example.groupuser.dto.GroupUserDTO;
import org.example.groupuser.entity.GroupUser;
import org.example.groupuser.repository.GroupUserRepository;
import org.example.groupuser.service.GrouUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupUserServiceImp implements GrouUserService {

    @Autowired
    GroupUserRepository groupUserRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<GroupUserDTO> showGroupUsers() {
        List<GroupUser> groups=groupUserRepository.findByDeletedFalse();
        return groups.stream().map(g->modelMapper.map(g,GroupUserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<Long> findGroupByUserId(Long userId) {
        List<GroupUser> groupUsers = groupUserRepository.findGroupUserByUserId(userId);
        List<Long> groupIds = groupUsers.stream()
                .map(GroupUser::getGroupId)
                .collect(Collectors.toList());
        return groupIds;
    }

    @Override
    public GroupUserDTO getGroupUserById(Long id) {
        return modelMapper.map(groupUserRepository.findById(id),GroupUserDTO.class);

    }

//    @Override
//    public GroupUserDTO updateGroupUser(GroupUserDTO groupUserDTO) {
//        return modelMapper.map(groupUserRepository.save(modelMapper.map(groupUserDTO, GroupUser.class)),GroupUserDTO.class);
//    }

    @Override
    public GroupUserDTO addGroupUser(GroupUserDTO groupUserDTO) {
        GroupUser groupUser=groupUserRepository.save(modelMapper.map(groupUserDTO, GroupUser.class));
        return modelMapper.map(groupUser, GroupUserDTO.class);
    }

    @Override
    public Boolean deleteGroupUser(GroupUserDTO groupUserDTO) {
        groupUserDTO.setDeleted(Boolean.TRUE);
        GroupUser groupUser=groupUserRepository.save(modelMapper.map(groupUserDTO, GroupUser.class));
        return groupUser.getDeleted();
    }
}
