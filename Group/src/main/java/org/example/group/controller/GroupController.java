package org.example.group.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.group.dto.GroupDTO;
import org.example.group.service.serviceImp.GroupServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    @Autowired
    GroupServiceImp groupServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<GroupDTO>> showAllGroups(){
        List<GroupDTO> groupDTOS=groupServiceImp.showGroups();
        return new ResponseEntity<>(groupDTOS, HttpStatus.OK);
    }
    @GetMapping("/find-group-by-admin-id/{adminId}")
    public ResponseEntity<List<GroupDTO>> findGroupByAdmin(@PathVariable Long adminId){
        List<GroupDTO> groupDTOS=groupServiceImp.findGroupByAdmin(adminId);
        return new ResponseEntity<>(groupDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable(value = "id") Long group_id){
        GroupDTO groupDTO=groupServiceImp.getGroupById(group_id);
        return new ResponseEntity<>(groupDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupDTO groupDTO, @RequestHeader(name = "id_user") long admin){
        groupDTO.setAdmin(admin);
        GroupDTO group=groupServiceImp.addGroup(groupDTO);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTO, @PathVariable Long id){
        GroupDTO group=groupServiceImp.updateGroup(id, groupDTO);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,Boolean> deleteGroup(@PathVariable(value = "id") Long group_id){
        GroupDTO groupDTO=groupServiceImp.getGroupById(group_id);
        HashMap<String,Boolean> response=new HashMap<>();
        if(groupServiceImp.deleteGroup(groupDTO)){
            response.put("delete",Boolean.TRUE);
        }
        return response;
    }


}
