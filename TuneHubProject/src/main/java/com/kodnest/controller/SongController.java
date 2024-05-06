package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Song;
import com.kodnest.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
 @PostMapping("/addsongs")
  public String addSong(@ModelAttribute Song song)
  {
	 
	 String name=song.getName();
	 
	boolean songStatus= songService.songExists(name);
	
	
	if(songStatus==false)
	{
	songService.saveSong(song);
	System.out.println("Song added successfully");
	}
	else {
		System.out.println("Duplicate Song");
	}
	return "adminhome";
	}
	 
 
 @GetMapping("/playsongs")
 public String playSongs(Model model)
 {
	 boolean premium = false;
	 
	 if(premium) {
		 
		 List<Song> songslist = songService.fetchAllSongs();
		 model.addAttribute("songs", songslist);
		 
		 System.out.println(songslist);
		return "displaysongs";
		 
	 }
	 else {
		 
		 return "pay";
		 
	 }
  }
 
 @GetMapping("/viewsongs")
 public String viewsongs(Model model) {
	 
	 List<Song> songslist = songService.fetchAllSongs();
	 model.addAttribute("songs", songslist);
	 
	 System.out.println(songslist);
	return "viewsongs";
	
 }
 
}







