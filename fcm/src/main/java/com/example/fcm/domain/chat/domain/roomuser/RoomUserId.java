package com.example.fcm.domain.chat.domain.roomuser;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Embeddable
@EqualsAndHashCode
public class RoomUserId implements Serializable {

    private Long room;
    private Long user;

}
