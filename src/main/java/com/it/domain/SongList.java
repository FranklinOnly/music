package com.it.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SongList implements Serializable {
    private Integer id;
    private String name;
    private String singer;
    private String url;
    private String time;
    private String category;
    private String lyric;
    private String album;
}
