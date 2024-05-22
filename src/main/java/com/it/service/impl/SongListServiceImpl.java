package com.it.service.impl;

import com.it.domain.SongList;
import com.it.mapper.SongListMapper;
import com.it.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongListServiceImpl implements SongListService {
    @Autowired
    private SongListMapper songListMapper;


    public SongList findSongById(Integer id) {
        SongList song=songListMapper.findSongById(id);
        return song;
    }

    public List<SongList> findAllSong() {
        List<SongList> songLists=songListMapper.findAllSong();
        return songLists;
    }

    public List<SongList> findByName(String name) {
        List<SongList> songLists=songListMapper.findByName(name);
        return songLists;
    }

    public List<SongList> findByCategory(String category) {
        List<SongList> songLists=songListMapper.findByCategory(category);
        return songLists;
    }

    public int addSong(SongList song) {
        int i=songListMapper.addSong(song);
        return i;
    }
}
