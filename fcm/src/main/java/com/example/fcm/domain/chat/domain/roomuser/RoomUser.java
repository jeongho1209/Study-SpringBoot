package com.example.fcm.domain.chat.domain.roomuser;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class RoomUser {

    @EmbeddedId
    private RoomUserId id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

}
