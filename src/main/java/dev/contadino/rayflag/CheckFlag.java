package dev.contadino.rayflag;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckFlag implements CommandExecutor {


    static Map<String, ArrayList<String>> flagIstance = OresListener.minerali;

    String PREFIX = OresListener.PREFIX;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {



        if(args.length == 1 && commandSender.hasPermission("rayflag.checkflag")) {

        String player = args[0];

        if(flagIstance.containsKey(player)) {

            ArrayList<String> list = flagIstance.get(player);

            if(list.size() == 0) {

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + "&3" + player + " &bhasn't any flag."));
            }else {

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l &7&r&b&lRayFlag &7 &7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-"      /*PREFIX + "&3" + player + " &bhas &3" + list.size() + " &bflags."*/));
                for (int i = 0; i < list.size(); i++) {


                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l- &b[" + (list.size() - i) + "] &3" + player + " &bhas &3broke " + list.get(i)));

                }

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-&7&m&l-"      /*PREFIX + "&3" + player + " &bhas &3" + list.size() + " &bflags."*/));

            }

        } else if (!(flagIstance.containsKey(player))) {

            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + "&3" + player + " &bhasn't any flag."));

        }


        }else if(!(commandSender.hasPermission("rayflag.checkflag"))) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission to use this command." ));
        }




        return true;
    }
}
