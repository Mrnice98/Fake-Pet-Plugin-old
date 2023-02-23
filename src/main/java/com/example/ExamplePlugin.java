package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import static com.example.JebScapeActor.radToJau;

@Slf4j
@PluginDescriptor(
	name = "Example"
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ExampleConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}


	JebScapeActor actor = new JebScapeActor();
	WorldArea nextTravellingPoint;
	Model pet;

	int tickdealy;

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getMessage().equals("!Set"))
		{
			//+64 + 30,+850 + 30,-30,-50,-30 .scale(65,65,65)
			pet = (Model) client.loadModelData(29631).light();
		}
		if (event.getMessage().equals("!Test"))
		{
			actor.init(client);
			//actor.setModel((Model) client.loadModel(11056).scale(64,64,64));
			WorldPoint wPoint = client.getLocalPlayer().getWorldLocation();
			//light(+64,+850,-30,-50,-30) are defualt values for npcs
			actor.setModel(pet);

			Player player = client.getLocalPlayer();


			double intx = actor.getWorldLocation().toWorldArea().getX() - player.getWorldLocation().toWorldArea().getX();
			double inty = actor.getWorldLocation().toWorldArea().getY() - player.getWorldLocation().toWorldArea().getY();



			WorldPoint point = new WorldPoint(client.getLocalPlayer().getWorldLocation().getX() - 1,client.getLocalPlayer().getWorldLocation().getY(),client.getPlane());

			actor.moveTo(point,radToJau(Math.atan2(intx,inty)),1678,true,false);

		}

	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Point petLoc = new Point(actor.getLocalLocation().getX(),actor.getLocalLocation().getY());
		Point destTileLoc = new Point(nextTravellingPoint.getX(),nextTravellingPoint.getY());

		Player player = client.getLocalPlayer();
		double intx = actor.getLocalLocation().getX() - player.getLocalLocation().getX();
		double inty = actor.getLocalLocation().getY() - player.getLocalLocation().getY();


		// System.out.println(client.getLocalPlayer().getWorldArea().getX() + " " + client.getLocalPlayer().getWorldArea().getY());
		//System.out.println(client.getLocalPlayer().getWorldLocation().getX() + " " + client.getLocalPlayer().getWorldLocation().getY());
		LocalPoint localPoint1 = LocalPoint.fromWorld(client,client.getLocalPlayer().getWorldLocation());
		//System.out.println(localPoint1.getX() + " " + localPoint1.getY());
		WorldArea worldArea1 = new WorldArea(WorldPoint.fromLocal(client,localPoint1),1,1);
		// System.out.println(worldArea1.getX());

		//actor.getLocalLocation().distanceTo(client.getLocalPlayer().getLocalLocation())
		//!actor.getWorldLocation().toWorldArea().isInMeleeDistance(client.getLocalPlayer().getWorldArea()) && !petLoc.equals(destTileLoc)
		if (!actor.getWorldLocation().toWorldArea().isInMeleeDistance(client.getLocalPlayer().getWorldArea()) && !petLoc.equals(destTileLoc))
		{

			if (tickdealy > 0)
			{
				tickdealy--;
			}

			if (tickdealy == 0)
			{
				actor.moveTo(nextTravellingPoint.toWorldPoint(), radToJau(Math.atan2(intx,inty)),-1,true,true);//7974 radToJau(Math.atan2(intx,inty))
			}

		}
		else
		{

			WorldPoint.fromLocalInstance(client,client.getLocalPlayer().getLocalLocation());
			tickdealy = 2;
			actor.moveTo(nextTravellingPoint.toWorldPoint(), radToJau(Math.atan2(intx,inty)),-1,true,true);//1678
		}



	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (actor != null)
		{
			WorldArea worldArea = actor.getWorldLocation().toWorldArea();
			nextTravellingPoint = worldArea.calculateNextTravellingPoint(client,client.getLocalPlayer().getWorldArea(),true);
			actor.onClientTick(event);
		}
	}

	@Provides
	ExampleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleConfig.class);
	}
}
