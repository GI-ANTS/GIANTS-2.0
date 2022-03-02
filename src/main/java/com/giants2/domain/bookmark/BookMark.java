package com.giants2.domain.bookmark;

import com.giants2.domain.study.EditorsPick;
import com.giants2.domain.user.User;

import javax.persistence.*;

@Entity
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookMarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ep_id")
    private EditorsPick editorsPick;

}
