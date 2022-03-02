package com.giants2.domain.stock;

import com.giants2.domain.board.Board;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String stockId;

    @NotNull
    private String stockName;

    @NotNull
    private String market;

    private String sector;

    private String product;

    private String homepage;

    @OneToMany(mappedBy = "stock")
    private List<Board> boards = new ArrayList<>();


}
