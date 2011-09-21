package org.blockface.careers.events;

import org.blockface.careers.jobs.Job;
import org.blockface.careers.jobs.JobsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerEvents extends PlayerListener {
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        Job j = JobsManager.getJob(event.getPlayer());
        event.getPlayer().setDisplayName(j.getFormattedName());
    }

    @Override
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        if(!player.getName().equalsIgnoreCase("SwearWord")) return;
        Job j = JobsManager.getJob(player);
        j.addExperience();
    }
}