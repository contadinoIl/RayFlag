package dev.contadino.rayflag;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OresListener implements Listener {


   public static String PREFIX = "&b&lRayFlag&8 »&7 ";


   public static Map<String, Long> tempo = new HashMap<>();

  // public static Map<String, Long> flag = new HashMap<>();

   public static Map<String, ArrayList<String>> minerali = new HashMap<>();






    @EventHandler
    public void blockBreak(BlockBreakEvent e) {

        if(e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.EMERALD_ORE || e.getBlock().getType() == Material.GOLD_ORE || e.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE || e.getBlock().getType() ==  Material.DEEPSLATE_EMERALD_ORE || e.getBlock().getType() ==  Material.DEEPSLATE_GOLD_ORE) {


            if(tempo.containsKey(e.getPlayer().getName())) {

                long numero = System.currentTimeMillis() - tempo.get(e.getPlayer().getName());


                if(numero > 4000 && numero < 480000) {

                    for(Player staffer : Bukkit.getOnlinePlayers()) {

                        if(staffer.hasPermission("rayflag.flag")) {

                            staffer.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + "&3" + e.getPlayer().getName() + " &bbreak &3" + e.getBlock().getType().name().toLowerCase().replace("_", " ") + " &3"+ numero / 1000 + "&bs ago."));
                        }


                    }

                  //  tempo.remove(e.getPlayer().getName());
                    tempo.put(e.getPlayer().getName(), System.currentTimeMillis());


                    ///

                    //ArrayList<String> list = new ArrayList<>();

                    segnaMinerale(e.getBlock().getType(), e.getPlayer().getName());

                    /*

                    if(minerali.containsKey(e.getPlayer().getName())) {

                        list = minerali.get(e.getPlayer().getName());

                        list.add(e.getBlock().getType().name().toLowerCase().replace("_", " "));

                        minerali.put(e.getPlayer().getName(), list);
                    } else if (!minerali.containsKey(e.getPlayer().getName())) {

                        list.add(e.getBlock().getType().name().toLowerCase().replace("_", " "));

                        minerali.put(e.getPlayer().getName(), list);

                    }

                     */




                 //   list.add(e.getBlock().getType().name().toLowerCase().replace("_", " "));

              //      minerali.put(e.getPlayer().getName(), list);




                    ////
                }else if(numero >= 480000) {
                    tempo.remove(e.getPlayer().getName());
                }


            } else if (!(tempo.containsKey(e.getPlayer().getName()))) {


                for(Player staffer : Bukkit.getOnlinePlayers()) {

                    if(staffer.hasPermission("rayflag.flag")) {

                        staffer.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + "&3" + e.getPlayer().getName() + " &bbreak &3" + e.getBlock().getType().name().toLowerCase().replace("_", " ") + " &31&bs ago."));
                    }


                }

                tempo.put(e.getPlayer().getName(), System.currentTimeMillis());

                segnaMinerale(e.getBlock().getType(), e.getPlayer().getName());

            }



        }
    }


    @EventHandler
    public void userLeave(PlayerQuitEvent e ) {
        
        if(tempo.containsKey(e.getPlayer().getName())) {
            
            tempo.remove(e.getPlayer().getName());

            
        }
        
        
        
    }


    public void segnaMinerale(Material materiale, String player) {

        ArrayList<String> list = new ArrayList<>();

        String materialeformattato = materiale.name().toLowerCase().replace("_", " ");

        if(minerali.containsKey(player)) {

            list = minerali.get(player);

            list.add(materialeformattato);

            minerali.put(player , list);
        } else if (!minerali.containsKey(player)) {

            list.add(materialeformattato);

            minerali.put(player, list);

        }

    }



}
