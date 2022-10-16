package com.example.socket.domain.chat.domain;

import com.example.socket.domain.chat.domain.enums.RoomType;
import com.example.socket.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Member> members = new ArrayList<>();

    @Builder
    public Room(RoomType roomType, String name) {
        this.roomType = roomType;
        this.name = name;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

}
