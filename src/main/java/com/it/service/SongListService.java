package com.it.service;

import com.it.domain.SongList;

import java.util.List;

public interface SongListService {
    SongList findSongById(Integer id);
    List<SongList> findAllSong();
    List<SongList> findByName(String name);
    List<SongList> findByCategory(String category);
    int addSong(SongList order);
}
