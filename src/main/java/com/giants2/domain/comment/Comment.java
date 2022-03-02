package com.giants2.domain.comment;


import com.giants2.config.Timestamped;
import com.giants2.domain.board.Board;
import com.giants2.domain.disclusure.Disclosure;
import com.giants2.domain.user.User;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotNull
    private String content;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ep_id")
    private Disclosure disclosure;


}
