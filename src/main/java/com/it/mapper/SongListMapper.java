package com.it.mapper;

import com.it.domain.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SongListMapper {
    SongList findSongById(Integer id);
    List<SongList> findAllSong();
    List<SongList> findByName(String name);
    List<SongList> findByCategory(String category);
    int addSong(SongList order);
//    int delSong(Integer id);
}
