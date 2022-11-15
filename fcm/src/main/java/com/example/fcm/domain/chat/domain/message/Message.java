package com.example.fcm.domain.chat.domain.message;

import com.example.fcm.domain.chat.domain.room.Room;
import com.example.fcm.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Builder
    public Message(String message, User user, Room room) {
        this.message = message;
        this.user = user;
        this.room = room;
    }

    public Long getRoomId() {
        return room.getId();
    }

    public String getUserName() {
        return user.getName();
    }

}
