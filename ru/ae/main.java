package ru.ae;


import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class main extends JavaPlugin implements Listener{

	boolean allow = false;
	//TODO MESSAGES
	String gsreload = ChatColor.YELLOW +"Файл перевода перезагружен.";
	String donate = ChatColor.GOLD +"На сервере нет донат услуг!";
	String permision = ChatColor.GOLD +"У вас нет разрешение.";
	String delvision = ChatColor.AQUA +"Выключен эффект «Ночного видения»";
	String setvision = ChatColor.AQUA +"Наложен эффект «Ночное зрение»";
	String delvisionuser = ChatColor.AQUA +"Выключен эффект «Ночного видения» для пользователя.";
	String setvisionuser = ChatColor.AQUA +"Наложен эффект «Ночное зрение» на игрока.";
	String setvisionot = ChatColor.AQUA +"На вас наложили эффект «Ночное зрение»";
	String cmdvision = ChatColor.YELLOW + "- Эффект ночного видения.";
	String cmdhelp = ChatColor.YELLOW + "- Посмотреть список команд.";
    String cmdts3 = ChatColor.YELLOW + "- Посмотреть адрес сервера TeamSpeak.";
	String cmdmess = "/message - Ваш текст";
	String help = ChatColor.WHITE +"------------------------- "+ ChatColor.GOLD + "Команды" + ChatColor.WHITE +" -------------------------";
	String badge = ChatColor.GREEN + "> ";
	String colorcommands = ChatColor.GREEN + "";
	String divm = ChatColor.WHITE + "-----------------";
	String nulluser = ChatColor.GOLD + "Пользователь не найден:";
	String consolevn = ChatColor.GOLD + "Используйте команду /vn [Игрок]";
	String teamspeak = ChatColor.GREEN +"Наш cервер TeamSpeak: ts3.ecruplay.ru";
    String versionauthor = " Версия 0.3.1 By SanyaFox ";
	String hack = ChatColor.DARK_PURPLE + "Вы попытались взломать сервер, но вы не смогли :-( \n Все данные были переданы в отдел по борьбе со взломам.";
	String message = ChatColor.GREEN +  "Ваше сообщение";
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		loadConfig();
	}
	@Override
	public void onDisable() {

	}
	public void loadConfig()
	{
        //TODO Перевод
		File file = new File("plugins/NineEyes/messages.lang");
		YamlConfiguration lang = YamlConfiguration.loadConfiguration(file);
		lang.addDefault("gsreload", ChatColor.GREEN +"Файл перевода перезагружен.");
		lang.addDefault("donate", ChatColor.GOLD +"На сервере нет донат услуг!");
		lang.addDefault("permision", ChatColor.RED +"У вас нет разрешение.");
		lang.addDefault("delvision", ChatColor.AQUA +"Выключен эффект «Ночного видения»");
		lang.addDefault("setvision", ChatColor.AQUA +"Наложен эффект «Ночное зрение»");
		lang.addDefault("delvisionuser", ChatColor.AQUA +"Выключен эффект «Ночного видения» для пользователя.");
		lang.addDefault("setvisionuser", ChatColor.AQUA +"Наложен эффект «Ночное зрение» на игрока.");
		lang.addDefault("setvisionot", ChatColor.AQUA +"На вас наложили эффект «Ночное зрение»");
		lang.addDefault("cmdvision", ChatColor.YELLOW +"- Эффект ночного видения.");
		lang.addDefault("cmdhelp", ChatColor.YELLOW +"- Посмотреть список команд");
        lang.addDefault("cmdts3", ChatColor.YELLOW + "- Посмотреть адрес сервера.");
		lang.addDefault("cmdmess", "/message - Ваш текст");
		lang.addDefault("help", ChatColor.WHITE +"------------------------- "+ ChatColor.GOLD + "Команды" + ChatColor.WHITE +" -------------------------");
		lang.addDefault("badge", ChatColor.GREEN + ">");
		lang.addDefault("colorcommands", ChatColor.GREEN + "");
		lang.addDefault("divm", ChatColor.WHITE + "-----------------");
		lang.addDefault("nulluser", ChatColor.GOLD +"Пользователь не найден:");
		lang.addDefault("consolevn", ChatColor.RED +"Используйте команду /vn [Игрок]");
		lang.addDefault("teamspeak", ChatColor.GREEN +"Наш cервер TeamSpeak: ts3.ecruplay.ru");
		lang.addDefault("hack", ChatColor.DARK_PURPLE + "Вы попытались взломать сервер, но вы не смогли :-( \n Все данные были переданы в отдел по борьбе со взломом.");
		lang.addDefault("message", ChatColor.GREEN + "Ваше сообщение");
		lang.options().copyDefaults(true);
		try {
			lang.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO LANG
		gsreload = lang.getString("gsreload");
		donate = lang.getString("donate");
		permision = lang.getString("permision");
		delvision = lang.getString("delvision");
		setvision = lang.getString("setvision");
		delvisionuser = lang.getString("delvisionuser");
		setvisionuser = lang.getString("setvisionuser");
		setvisionot = lang.getString("setvisionot");
		nulluser = lang.getString("nulluser");
		cmdvision = lang.getString("cmdvision");
		cmdhelp = lang.getString("cmdhelp");
		help = lang.getString("help");
		badge = lang.getString("badge");
		colorcommands = lang.getString("colorcommands");
		divm = lang.getString("divm");
		cmdmess = lang.getString("cmdmess");
        cmdts3 = lang.getString("cmdts3");
        consolevn = lang.getString("consolevn");
		teamspeak = lang.getString("teamspeak");
		hack = lang.getString("hack");
		message = lang.getString("message");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO Донат
		if(cmd.getName().equalsIgnoreCase("donate")){sender.sendMessage(donate);}
		//TODO message
		if(cmd.getName().equalsIgnoreCase("message")){ sender.sendMessage(message); }
		//TODO Hack
		if(cmd.getName().equalsIgnoreCase("hack")){ sender.sendMessage(hack);}
		//TODO TeamSpeak
		if(cmd.getName().equalsIgnoreCase("teamspeak")){sender.sendMessage(teamspeak);}
		//TODO Перезагрузка плагина
		if(cmd.getName().equalsIgnoreCase("gsreload")) {  loadConfig(); sender.sendMessage(gsreload); }
		//TODO Команды сервера
		if(cmd.getName().equalsIgnoreCase("nineeyes"))
		{
			sender.sendMessage(help);
			if(sender.hasPermission("nineeyes.vision")) { sender.sendMessage(badge + colorcommands +"/vision(/vn) "+ ChatColor.WHITE  + cmdvision); }
            sender.sendMessage(badge + colorcommands + "/ts3 "+ ChatColor.WHITE  + cmdts3);
            sender.sendMessage(badge + colorcommands + "/nineeyes(/ae) "+ ChatColor.WHITE  + cmdhelp);
			sender.sendMessage(badge + colorcommands + cmdmess);
            sender.sendMessage(divm +  versionauthor + divm);
		}
		//TODO Ночное зрение
		if(cmd.getName().equalsIgnoreCase("vision"))
		{
			if(args.length == 0)
			{
				if( !(sender instanceof Player)) { sender.sendMessage(consolevn); return true; }
				Player p = (Player) sender;
				if (args.length == 0){
					if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)  == true && p.hasPotionEffect(PotionEffectType.WATER_BREATHING) == true)
					{
						p.removePotionEffect(PotionEffectType.NIGHT_VISION);
						p.removePotionEffect(PotionEffectType.WATER_BREATHING);
						p.sendMessage(delvision);
						return true;
					}
					p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0));
					p.sendMessage(setvision);
					return true;
				}
			}
			getName();
			String name = args[0];
			Player p = Bukkit.getPlayer(name);
			if(sender.hasPermission("nineeyes.vision.other") && args[0].equalsIgnoreCase(name))
			{
				if (p == null) { sender.sendMessage( nulluser + " " + name);return true; }
				if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)  == true && p.hasPotionEffect(PotionEffectType.WATER_BREATHING) == true)
				{
					p.removePotionEffect(PotionEffectType.NIGHT_VISION);
					p.removePotionEffect(PotionEffectType.WATER_BREATHING);
					sender.sendMessage(delvisionuser + " " + name);
					p.sendMessage(delvision);
					return true;
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0));
				sender.sendMessage(setvisionuser + " " + name);
				p.sendMessage(setvisionot);
				return true;
			} else {  p.sendMessage(permision); return true; }
		}
		return true;
	}


}