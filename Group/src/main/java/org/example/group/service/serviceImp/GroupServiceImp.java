package org.example.group.service.serviceImp;

import jakarta.ws.rs.NotFoundException;
import org.example.group.dto.GroupDTO;
import org.example.group.entity.Group;
import org.example.group.event.groupevent;
import org.example.group.repository.GroupRepository;
import org.example.group.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ModelMapper modelMapper;

    private final KafkaTemplate<String, groupevent> kafkaTemplate;

    public GroupServiceImp(KafkaTemplate<String, groupevent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<GroupDTO> showGroups() {
        List<Group> groups=groupRepository.findByDeletedFalse();
        return groups.stream().map(g->modelMapper.map(g,GroupDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GroupDTO> findGroupByAdmin(Long adminId) {
        List<Group> groups=groupRepository.findGroupByAdmin(adminId);
        return groups.stream().map(g->modelMapper.map(g,GroupDTO.class)).collect(Collectors.toList());
    }

    @Override
    public GroupDTO getGroupById(Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            return modelMapper.map(group, GroupDTO.class);
        } else {
            throw new NotFoundException("Group not found with id: " + id);
        }
    }

    @Override
    public GroupDTO updateGroup(Long id ,GroupDTO groupDTO) {
        groupDTO.setId(id);
        return modelMapper.map(groupRepository.save(modelMapper.map(groupDTO, Group.class)),GroupDTO.class);
    }

    @Override
    public GroupDTO addGroup(GroupDTO groupDTO) {
        Group group=groupRepository.save(modelMapper.map(groupDTO, Group.class));
        kafkaTemplate.send("notificationTopic", new groupevent(group.getId().toString()));
        return modelMapper.map(group, GroupDTO.class);
    }

    @Override
    public Boolean deleteGroup(GroupDTO groupDTO) {
        groupDTO.setDeleted(Boolean.TRUE);
        Group group=groupRepository.save(modelMapper.map(groupDTO, Group.class));
        return group.getDeleted();
    }

    @Override
    public List<GroupDTO> findAllGroupsByGroupIds(List<Long> groupIds) {
        return null;
    }
}
