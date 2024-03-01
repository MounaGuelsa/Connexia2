package org.example.groupuser.service.serviceImp;

import org.example.group.dto.GroupDTO;
import org.example.groupuser.clients.GroupClient;
import org.example.groupuser.dto.GroupUserDTO;
import org.example.groupuser.entity.GroupUser;
import org.example.groupuser.repository.GroupUserRepository;
import org.example.groupuser.service.GrouUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupUserServiceImp implements GrouUserService {

    @Autowired
    GroupUserRepository groupUserRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private GroupClient groupClient;

    @Override
    public List<GroupUserDTO> showGroupUsers() {
        List<GroupUser> groups=groupUserRepository.findByDeletedFalse();
        return groups.stream().map(g->modelMapper.map(g,GroupUserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GroupDTO> findGroupByUserId(Long userId) {
        if (groupClient != null) {
            List<GroupDTO> groupDTOS = new ArrayList<>() ;
            List<GroupUser> groupUsers = groupUserRepository.findGroupUserByUserId(userId);
            List<Long> groupIds = groupUsers.stream()
                    .map(GroupUser::getGroupId)
                    .toList();
            for (Long id : groupIds){
                var groupDTO =  groupClient.getGroup(id);
                groupDTOS.add(groupDTO.getBody());
            }
            return groupDTOS;
        } else {
            return null;
        }

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
    public GroupUserDTO addMember(GroupUserDTO groupUserDTO, Long id_userA) {
        Long id_group = groupUserDTO.getGroupId();
        Long id_user = groupUserDTO.getUserId();

        if(id_group== 0){

        }
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
