package com.giants2.domain.user;


import com.giants2.config.Timestamped;
import com.giants2.domain.board.Board;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String username;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

}
