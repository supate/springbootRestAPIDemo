package com.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dao.Player;
import com.springboot.jpa.dao.PlayerDao;

@RestController
public class RestAPIController {

	@Autowired
	PlayerDao playerDao;
	
	@GetMapping("/hi")
	public String welcome() {
		return "Welcome to first REST API";	
	}
	
	@GetMapping("/getPlayer/{id}")
	public Player getPlayerById(@PathVariable("id") int playerId) {
		return playerDao.getPlayerById(playerId);
	}
	
	@PostMapping("/addPlayer")
	public String addPlayer(@RequestBody Player player) {
		int id = playerDao.savePlayerData(player);
		if(id == player.getId()) {
			return "Successfully Added";
		}
		return "Failed to add";
	}
	
	@GetMapping("/getPlayers")
	public List<Player> getPlayers() {
		return playerDao.getPlayers();
	}
}
