package com.example.springstudycode.domain.user.entity;

import com.example.springstudycode.domain.board.entity.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", nullable = false, length = 20)
    private Long accountId;

    @Column(name = "nickname", nullable = false, length = 10)
    private String nickname;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

}
