package org.example.group.service.serviceImp;

import org.example.group.dto.GroupDTO;
import org.example.group.entity.Group;
import org.example.group.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GroupServiceImpTest {

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GroupServiceImp groupService;

    private Group group1;
    private Group group2;

    @BeforeEach
    void setUp() {
        group1 = new Group();
        group1.setId(1L);
        group1.setNom("Group 1");
        group1.setAdmin(11L);
        group1.setDeleted(false);
        group1.setDescription("Description 1");

        group2 = new Group();
        group2.setId(2L);
        group2.setNom("Group 2");
        group2.setAdmin(12L);
        group2.setDeleted(false);
        group2.setDescription("Description 2");
    }

    @Test
    @DisplayName("Get All Groups")
    void testShowGroups() {
        when(groupRepository.findByDeletedFalse()).thenReturn(Arrays.asList(group1, group2));

        GroupDTO groupDTO1 = new GroupDTO();
        groupDTO1.setId(1L);
        groupDTO1.setNom("Group 1");
        groupDTO1.setAdmin(11L);
        groupDTO1.setDeleted(false);
        groupDTO1.setDescription("Description 1");

        GroupDTO groupDTO2 = new GroupDTO();
        groupDTO2.setId(2L);
        groupDTO2.setNom("Group 2");
        groupDTO2.setAdmin(12L);
        groupDTO2.setDeleted(false);
        groupDTO2.setDescription("Description 2");

        when(modelMapper.map(group1, GroupDTO.class)).thenReturn(groupDTO1);
        when(modelMapper.map(group2, GroupDTO.class)).thenReturn(groupDTO2);

        List<GroupDTO> result = groupService.showGroups();

        assertEquals(2, result.size());
        assertEquals(groupDTO1, result.get(0));
        assertEquals(groupDTO2, result.get(1));
    }
    @Test
    @DisplayName("Get All Groups By Admin Id ")
    void testFindGroupByAdmin() {
        when(groupRepository.findGroupByAdmin(11L)).thenReturn(Arrays.asList(group1));

        GroupDTO groupDTO1 = new GroupDTO();
        groupDTO1.setId(1L);
        groupDTO1.setNom("Group 1");
        groupDTO1.setAdmin(11L);
        groupDTO1.setDeleted(false);
        groupDTO1.setDescription("Description 1");

        when(modelMapper.map(group1, GroupDTO.class)).thenReturn(groupDTO1);

        List<GroupDTO> result = groupService.findGroupByAdmin(11L);

        assertEquals(1, result.size());
        assertEquals(groupDTO1, result.get(0));
    }

    @Test
    @DisplayName("Get Group By Id")
    void testGetGroupById() {
        when(groupRepository.findById(1L)).thenReturn(Optional.of(group1));

        GroupDTO groupDTO1 = new GroupDTO();
        groupDTO1.setId(1L);
        groupDTO1.setNom("Group 1");
        groupDTO1.setAdmin(11L);
        groupDTO1.setDeleted(false);
        groupDTO1.setDescription("Description 1");

        when(modelMapper.map(group1, GroupDTO.class)).thenReturn(groupDTO1);

        GroupDTO result = groupService.getGroupById(1L);

        assertNotNull(result);
        assertEquals(groupDTO1, result);
    }

    @Test
    @DisplayName("Update Group")
    public void testUpdateGroup() {
        Long id = 1L;
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(id);
        Group group = new Group();
        group.setId(id);

        when(modelMapper.map(groupDTO, Group.class)).thenReturn(group);
        when(groupRepository.save(group)).thenReturn(group);
        when(modelMapper.map(group, GroupDTO.class)).thenReturn(groupDTO);

        GroupDTO result = groupService.updateGroup(id, groupDTO);

        assertEquals(id, result.getId());
        verify(groupRepository, times(1)).save(group);
    }

    @Test
    @DisplayName("Add Group")
    public void testAddGroup() {
        GroupDTO groupDTO = new GroupDTO();
        Group group = new Group();

        when(modelMapper.map(groupDTO, Group.class)).thenReturn(group);
        when(groupRepository.save(group)).thenReturn(group);
        when(modelMapper.map(group, GroupDTO.class)).thenReturn(groupDTO);

        GroupDTO result = groupService.addGroup(groupDTO);

        assertEquals(groupDTO, result);
        verify(groupRepository, times(1)).save(group);
    }

    @Test
    @DisplayName("Delete Group")
    public void testDeleteGroup() {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(1L);
        groupDTO.setDeleted(false);
        Group group = new Group();
        group.setId(1L);
        group.setDeleted(false);

        when(modelMapper.map(groupDTO, Group.class)).thenReturn(group);
        when(groupRepository.save(group)).thenReturn(group);

        Boolean result = groupService.deleteGroup(groupDTO);

        assertEquals(true, groupDTO.getDeleted());
        verify(groupRepository, times(1)).save(group);
    }
}
