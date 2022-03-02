package com.giants2.domain.study;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EditorsPick {

    @Id
    private Long epId;
    private String title;
    private String description;
    private String url;
    private String thumbnail;

}
