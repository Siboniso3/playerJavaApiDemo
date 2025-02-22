package com.example.demo.Service;

import com.example.demo.Player.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    List<Player> list = new ArrayList<>();

    public PlayerService() {
        list.add(new Player("Siboniso", "Ncube", 1, "2005-05-12"));
        list.add(new Player("Sibusiso", "Nkulu", 2, "2002-10-24"));
        list.add(new Player("Sipho", "Mbuli", 3, "2004-10-24"));
    }

    public List<Player> getAllPlayers() {
        return list;
    }

    public Player getById(int id) {
        for (Player player : list) {
            if (player.getId() == id) {
                return player;
            }

        }
        return null;
    }

    public Player deleteById(int id) {
        String e="";
        if(list.isEmpty()){
        return null;
        }else {
            for (Player player : list) {
                if (player.getId() == id) {
                    this.list.remove(player);

                }
            }
        }
        return null;
    }
    public void deletePlayer(int id){
        list.remove(id);
    }

    public void addPlayer(Player player) {
        this.list.add(player);
    }
    public void updatePlayer(Player player){
        for (Player p : list) {
            if (p.getId() == player.getId()) {
                p.setFirstName(player.getLastName());
            }
        }
    }
}
