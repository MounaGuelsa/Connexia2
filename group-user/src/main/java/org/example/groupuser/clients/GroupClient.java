package org.example.groupuser.clients;

import org.example.group.dto.GroupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "group", url = "http://localhost:4044")
public interface GroupClient {
    @GetMapping("/group/{id}")
    ResponseEntity<GroupDTO> getGroup(@PathVariable(value = "id") Long group_id);
}

