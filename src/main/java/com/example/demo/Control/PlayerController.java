package com.example.demo.Control;

import com.example.demo.Player.Player;
import com.example.demo.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/player")
public class PlayerController {
    private PlayerService service;
    public PlayerController(PlayerService service) {
        this.service = service;
    }
    @GetMapping(value = "")
    public List<Player> getAll(){
        return service.getAllPlayers();
    }
    @GetMapping(value = "/{id}")
    public Player getById(@PathVariable int id){
        System.out.println(id);
        return this.service.getById(id);
    }
    @GetMapping(value = "/{id}/delete")
    public Player DeletePlayerByID(@PathVariable int id){
        return this.service.deleteById(id);
    }
//    @GetMapping(value = "/{id}/deletePlayer")
//    public void deletePlayer(@PathVariable int id){
//        this.service.deletePlayer(id);
//    }
     @PostMapping("{}")
    public void addPlayer(@RequestBody Player player){
        this.service.addPlayer(player);
    }


}
