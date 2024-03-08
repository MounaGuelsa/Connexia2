package org.example.group.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
public class groupevent extends ApplicationEvent {
    private String groupId;

    public groupevent(Object source, String groupId) {
        super(source);
        this.groupId = groupId;
    }
    public groupevent(String groupId) {
        super(groupId);
        this.groupId = groupId;
    }
}
