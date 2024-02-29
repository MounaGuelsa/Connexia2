package org.example.groupuser.controller;

import org.example.groupuser.dto.GroupUserDTO;
import org.example.groupuser.service.serviceImp.GroupUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/group-user")
public class GroupUserController {
    @Autowired
    GroupUserServiceImp groupUserServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<GroupUserDTO>> showAllGroupUsers(){
        List<GroupUserDTO> groupUserDTOS=groupUserServiceImp.showGroupUsers();
        return new ResponseEntity<>(groupUserDTOS, HttpStatus.OK);
    }
    @GetMapping("/find-group-id-by-user-id/{userId}")
    public ResponseEntity<List<Long>> findGroupByUserId(@PathVariable Long userId){
        List<Long> groups=groupUserServiceImp.findGroupByUserId(userId);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GroupUserDTO> getGroupUser(@PathVariable(value = "id") Long group_user_id){
        GroupUserDTO groupUserDTO=groupUserServiceImp.getGroupUserById(group_user_id);
        return new ResponseEntity<>(groupUserDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<GroupUserDTO> addGroupUser(@RequestBody GroupUserDTO groupUserDTO){
        GroupUserDTO group=groupUserServiceImp.addGroupUser(groupUserDTO);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }
//    @PutMapping("/update")
//    public ResponseEntity<GroupUserDTO> updateGroupUser(@RequestBody GroupUserDTO groupUserDTO){
//        GroupUserDTO groupUser=groupUserServiceImp.updateGroupUser(groupUserDTO);
//        return new ResponseEntity<>(groupUser, HttpStatus.OK);
//    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,Boolean> deleteGroupUser(@PathVariable(value = "id") Long group_user_id){
        GroupUserDTO groupUserDTO=groupUserServiceImp.getGroupUserById(group_user_id);
        HashMap<String,Boolean> response=new HashMap<>();
        if(groupUserServiceImp.deleteGroupUser(groupUserDTO)){
            response.put("delete",Boolean.TRUE);
        }
        return response;
    }
}
