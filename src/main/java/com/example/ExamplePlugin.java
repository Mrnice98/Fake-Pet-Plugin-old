package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.geometry.SimplePolygon;
import net.runelite.api.model.Jarvis;
import net.runelite.api.widgets.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.JebScapeActor.radToJau;
import static net.runelite.api.Perspective.COSINE;
import static net.runelite.api.Perspective.SINE;

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

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private OverlayPet overlayPet;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlayPet);
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlayPet);
		log.info("Example stopped!");
	}


	WorldPoint lastPlayerWP;
	WorldPoint lastActorWP;
	int lastActorOrientation;

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		System.out.println(gameStateChanged.getGameState());
		if (gameStateChanged.getGameState() == GameState.LOADING)
		{
			lastPlayerWP = client.getLocalPlayer().getWorldLocation();
			lastActorWP = actor.getWorldLocation();
			lastActorOrientation = actor.getOrientation();

			System.out.println(client.getLocalPlayer().getWorldLocation());
			actor.despawn();
		}

		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{

			System.out.println(lastPlayerWP.distanceTo(client.getLocalPlayer().getWorldLocation()));
			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			WorldPoint aWP = actor.getWorldLocation();

			double intx = aWP.toWorldArea().getX() - wp.toWorldArea().getX();
			double inty = aWP.toWorldArea().getY() - wp.toWorldArea().getY();

			if (lastPlayerWP.distanceTo(client.getLocalPlayer().getWorldLocation()) < 5)
			{
				actor.spawn(lastActorWP,lastActorOrientation);
				actor.setAnimation(actor.animationPoses[0]);
			}
			else
			{
				actor.spawn(getPathOutWorldPoint(client.getLocalPlayer().getWorldArea()),radToJau(Math.atan2(intx,inty)));
				actor.setAnimation(actor.animationPoses[0]);
			}


		}
	}


	JebScapeActor actor = new JebScapeActor();
	WorldArea nextTravellingPoint;
	Model pet;

	int tickdealy;

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{

		if (event.getScriptId() == ScriptID.CHAT_SEND)
		{

		}

	}


	@Inject
	ChatboxThing chatboxThing;

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getMessage().equals("!S"))
		{

			client.getWidget(WidgetInfo.CHATBOX_CONTAINER).deleteAllChildren();
			client.getWidget(WidgetInfo.CHATBOX_CONTAINER).createChild(-1,WidgetType.TEXT).setText("TEst").revalidate();


			//chatboxPanelManager.openTextMenuInput("test").option("option",null).build();

			//chatboxThing.createThing();



//			Widget container = client.getWidget(162,34);
//			container.deleteAllChildren();
//
//			Widget promptWidget = container.createChild(0, WidgetType.TEXT);
//			promptWidget.setText("this prompt");
//			promptWidget.setTextColor(0x800000);
//			promptWidget.setFontId(FontID.BARBARIAN);
//			promptWidget.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
//			promptWidget.setOriginalX(0);
//			promptWidget.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
//			promptWidget.setOriginalY(8);
//			promptWidget.setOriginalHeight(24);
//			promptWidget.setXTextAlignment(WidgetTextAlignment.CENTER);
//			promptWidget.setYTextAlignment(WidgetTextAlignment.CENTER);
//			promptWidget.setWidthMode(WidgetSizeMode.MINUS);
//			promptWidget.revalidate();






		}

		if (event.getMessage().equals("!Go"))
		{

		}


		String message = event.getMessage();
		if (message.equals("You do not have a follower.") && event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (actor.getRlObject() == null)
			{
				pet = (Model) client.loadModelData(29631).light();
				actor.init(client);
				actor.setModel(pet);
			}
			else if (actor.isActive())
			{
				actor.despawn();
			}

			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			WorldPoint aWP = actor.getWorldLocation();

			double intx = aWP.toWorldArea().getX() - wp.toWorldArea().getX();
			double inty = aWP.toWorldArea().getY() - wp.toWorldArea().getY();

			event.getMessageNode().setValue("");

			actor.spawn(getPathOutWorldPoint(client.getLocalPlayer().getWorldArea()),radToJau(Math.atan2(intx,inty)));
			actor.setAnimation(actor.animationPoses[0]); //0 == walk

		}




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



			WorldPoint point = new WorldPoint(client.getLocalPlayer().getWorldLocation().getX() ,client.getLocalPlayer().getWorldLocation().getY(),client.getPlane());

			actor.moveTo(point,radToJau(Math.atan2(intx,inty)),1678,true,false);

		}

	}


	private ChatboxPanelManager chatboxPanelManager;

	private MenuManager menuManager;


	@Subscribe
	public void onGameTick(GameTick event)
	{

		Player player = client.getLocalPlayer();
		double intx = actor.getLocalLocation().getX() - player.getLocalLocation().getX();
		double inty = actor.getLocalLocation().getY() - player.getLocalLocation().getY();

		if (nextTravellingPoint == null && client.getLocalPlayer().getLocalLocation().equals(actor.getLocalLocation()))
		{
			nextTravellingPoint = new WorldArea(getPathOutWorldPoint(actor.getWorldLocation().toWorldArea()),1,1);
		}

		if (actor.isActive())
		{
			actor.moveTo(nextTravellingPoint.toWorldPoint(), radToJau(Math.atan2(intx,inty)),-1,true,true);//7974 radToJau(Math.atan2(intx,inty))
		}

		//1678

	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{

		int firstMenuIndex = 0;

		for (int i = 0; i < client.getMenuEntries().length; i++)
		{
			if (client.getMenuEntries()[i].getOption().equals("Walk here"))
			{
				firstMenuIndex = i;
				break;
			}
		}

		List<String> options = Arrays.asList("Talk-to","Pick-up","Examine");


		for (String string : options)
		{
			if (poly.contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()))
			{
				client.createMenuEntry(firstMenuIndex)
						.setOption(string)
						.setTarget("<col=ffff00>" + "Abyssal orphan" + "</col>")
						.setType(MenuAction.RUNELITE)
						.setParam0(0)
						.setParam1(0)
						.setDeprioritized(true);

			}

		}

	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{


	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuTarget().contains("Abyssal orphan") && event.getMenuOption().equals("Pick-up"))
		{
			if (actor.isActive() && actor.getWorldLocation().toWorldArea().isInMeleeDistance(client.getLocalPlayer().getWorldArea()))
			{
				actor.despawn();
			}
		}


	}

	SimplePolygon poly;

	private int getRandomInt(int max, int min)
	{
		return min + (int)(Math.random() * ((max - min) + 1));
	}


	public WorldPoint getPathOutWorldPoint(WorldArea worldArea)
	{

		ArrayList<WorldPoint> points = new ArrayList<>();

		for (int i = -1; i < 2; i++)
		{
			if (i != 0)
			{
				if (worldArea.canTravelInDirection(client,i,0))
				{
					points.add(new WorldPoint(worldArea.getX() + i,worldArea.getY(),client.getPlane()));
				}
				if (worldArea.canTravelInDirection(client,0,i))
				{
					points.add(new WorldPoint(worldArea.getX(),worldArea.getY() + i,client.getPlane()));
				}
			}
		}


		if (!points.isEmpty())
		{
			return points.get(getRandomInt(points.size() - 1,0));
		}

		return null;
	}




	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (actor != null)
		{
//
//			WorldArea worldArea = new WorldArea(WorldPoint.fromLocalInstance(client,actor.getLocalLocation()),1,1);
//			WorldArea worldArea1 = new WorldArea(WorldPoint.fromLocalInstance(client,client.getLocalPlayer().getLocalLocation()),1,1);

			WorldArea worldArea = new WorldArea(WorldPoint.fromLocal(client,actor.getLocalLocation()),1,1);
			WorldArea worldArea1 = new WorldArea(WorldPoint.fromLocal(client,client.getLocalPlayer().getLocalLocation()),1,1);


			LocalPoint lp = actor.getLocalLocation();

//			System.out.println(worldArea.getX() + " " + worldArea.getY());
//			System.out.println(worldArea1.getX() + " " + worldArea1.getY());

			int zOff = Perspective.getTileHeight(client,lp,client.getPlane());
			poly = calculateAABB(client,actor.getRlObject().getModel(),actor.getOrientation(),actor.getLocalLocation().getX(),actor.getLocalLocation().getY(),client.getPlane(), zOff);



			nextTravellingPoint = worldArea.calculateNextTravellingPoint(client,worldArea1,true);
			//System.out.println(nextTravellingPoint);

			if (nextTravellingPoint == null && client.getLocalPlayer().getLocalLocation().equals(actor.getLocalLocation()))
			{
//				WorldPoint point = null;
//				List<WorldPoint> points = new ArrayList<>();
//
//				points.add(new WorldPoint(actor.getWorldLocation().getX() + 1,actor.getWorldLocation().getY(),client.getPlane()));
//				points.add(new WorldPoint(actor.getWorldLocation().getX() - 1,actor.getWorldLocation().getY(),client.getPlane()));
//				points.add(new WorldPoint(actor.getWorldLocation().getX(),actor.getWorldLocation().getY() + 1,client.getPlane()));
//				points.add(new WorldPoint(actor.getWorldLocation().getX(),actor.getWorldLocation().getY() - 1,client.getPlane()));
//
//
//				points = points.stream().filter(worldPoint -> worldArea.
//						canTravelInDirection(client
//								,Integer.compare(actor.getWorldLocation().getX(), worldPoint.getX())
//								,Integer.compare(actor.getWorldLocation().getY(), worldPoint.getY())))
//						.collect(Collectors.toList());
//
//
//				//point = points.get(getRandomInt(points.size(),0));
//				//nextTravellingPoint = new WorldArea(point,1,1);
//
//
//				points.clear();
//
//
//				for (int i = -1; i < 2; i++)
//				{
//					if (i != 0)
//					{
//						if (worldArea.canTravelInDirection(client,i,0))
//						{
//							point = new WorldPoint(actor.getWorldLocation().getX() + i,actor.getWorldLocation().getY(),client.getPlane());
//							points.add(point);
//						}
//						else if (worldArea.canTravelInDirection(client,0,i))
//						{
//							point = new WorldPoint(actor.getWorldLocation().getX(),actor.getWorldLocation().getY() + i,client.getPlane());
//							points.add(point);
//						}
//					}
//
              //nextTravellingPoint = new WorldArea(getPathOutWorldPoint(actor.getWorldLocation().toWorldArea()),1,1);

			}
		//	System.out.println(nextTravellingPoint.isInMeleeDistance(client.getLocalPlayer().getWorldArea()));
			actor.onClientTick(event);
			//System.out.println(actor.getRlObject().getAnimation().getId());

		}
	}

	private static SimplePolygon calculateAABB(Client client, Model m, int jauOrient, int x, int y, int z, int zOff)
	{
		AABB aabb = m.getAABB(jauOrient);

		int x1 = aabb.getCenterX();
		int y1 = aabb.getCenterZ();
		int z1 = aabb.getCenterY() + zOff;

		int ex = aabb.getExtremeX();
		int ey = aabb.getExtremeZ();
		int ez = aabb.getExtremeY();

		int x2 = x1 + ex;
		int y2 = y1 + ey;
		int z2 = z1 + ez;

		x1 -= ex;
		y1 -= ey;
		z1 -= ez;

		int[] xa = new int[]{
				x1, x2, x1, x2,
				x1, x2, x1, x2
		};
		int[] ya = new int[]{
				y1, y1, y2, y2,
				y1, y1, y2, y2
		};
		int[] za = new int[]{
				z1, z1, z1, z1,
				z2, z2, z2, z2
		};

		int[] x2d = new int[8];
		int[] y2d = new int[8];

		modelToCanvasCpu(client, 8, x, y, z, 0, xa, ya, za, x2d, y2d);

		return Jarvis.convexHull(x2d, y2d);
	}

	private static void modelToCanvasCpu(Client client, int end, int x3dCenter, int y3dCenter, int z3dCenter, int rotate, int[] x3d, int[] y3d, int[] z3d, int[] x2d, int[] y2d)
	{
		final int
				cameraPitch = client.getCameraPitch(),
				cameraYaw = client.getCameraYaw(),

				pitchSin = SINE[cameraPitch],
				pitchCos = COSINE[cameraPitch],
				yawSin = SINE[cameraYaw],
				yawCos = COSINE[cameraYaw],
				rotateSin = SINE[rotate],
				rotateCos = COSINE[rotate],

				cx = x3dCenter - client.getCameraX(),
				cy = y3dCenter - client.getCameraY(),
				cz = z3dCenter - client.getCameraZ(),

				viewportXMiddle = client.getViewportWidth() / 2,
				viewportYMiddle = client.getViewportHeight() / 2,
				viewportXOffset = client.getViewportXOffset(),
				viewportYOffset = client.getViewportYOffset(),

				zoom3d = client.getScale();

		for (int i = 0; i < end; i++)
		{
			int x = x3d[i];
			int y = y3d[i];
			int z = z3d[i];

			if (rotate != 0)
			{
				int x0 = x;
				x = x0 * rotateCos + y * rotateSin >> 16;
				y = y * rotateCos - x0 * rotateSin >> 16;
			}

			x += cx;
			y += cy;
			z += cz;

			final int
					x1 = x * yawCos + y * yawSin >> 16,
					y1 = y * yawCos - x * yawSin >> 16,
					y2 = z * pitchCos - y1 * pitchSin >> 16,
					z1 = y1 * pitchCos + z * pitchSin >> 16;

			int viewX, viewY;

			if (z1 < 50)
			{
				viewX = Integer.MIN_VALUE;
				viewY = Integer.MIN_VALUE;
			}
			else
			{
				viewX = (viewportXMiddle + x1 * zoom3d / z1) + viewportXOffset;
				viewY = (viewportYMiddle + y2 * zoom3d / z1) + viewportYOffset;
			}

			x2d[i] = viewX;
			y2d[i] = viewY;
		}
	}

	@Provides
	ExampleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleConfig.class);
	}
}
