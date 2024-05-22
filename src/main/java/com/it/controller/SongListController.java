package com.it.controller;

import com.it.domain.SongList;
import com.it.service.SongListService;
import com.it.utils.Code;
import com.it.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songList")
public class SongListController {
    @Autowired
    private SongListService songListService;

    @GetMapping("/find/{id}")
    public Result findSongById(@PathVariable("id") Integer id){
        SongList song=songListService.findSongById(id);
        Integer code=song!=null? Code.GET_OK:Code.GET_ERR;
        String msg=song!=null?"id查询成功！":"数据查询失败，请重试！";
        return new Result(song,code,msg);
    }

    @GetMapping("/find")
    public Result findAll(){
        List<SongList> list=songListService.findAllSong();
        Integer code=list!=null?Code.GET_OK:Code.GET_ERR;
        String msg=list!=null?"全部查询成功！":"数据查询失败，请重试！";
        return new Result(list,code,msg);
    }

    @GetMapping("/findName")
    public Result findByName(@Param("name") String name){
        List<SongList> list=songListService.findByName(name);
        Integer code=list!=null?Code.GET_OK:Code.GET_ERR;
        String msg=list!=null?"歌名模糊查询成功！":"数据查询失败，请重试！";
        return new Result(list,code,msg);
    }

    @GetMapping("/findCategory")
    public Result findByCategory(@Param("category") String category){
        List<SongList> list=songListService.findByCategory(category);
        Integer code=list!=null?Code.GET_OK:Code.GET_ERR;
        String msg=list!=null?"类型模糊查询成功！":"数据查询失败，请重试！";
        return new Result(list,code,msg);
    }

    @PostMapping("/add")
    public Result addSong(@RequestBody SongList songList){
        int i = songListService.addSong(songList);
        Integer code=i!=0?Code.SAVE_OK:Code.SAVE_ERR;
        String msg=i!=0?"添加成功！":"数据添加失败，请重试！";
        return new Result(i,code,msg);
    }
}
