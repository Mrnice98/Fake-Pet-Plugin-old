package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.geometry.SimplePolygon;
import net.runelite.api.model.Jarvis;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.awt.*;
import java.util.Arrays;

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

		Player player = client.getLocalPlayer();
		double intx = actor.getLocalLocation().getX() - player.getLocalLocation().getX();
		double inty = actor.getLocalLocation().getY() - player.getLocalLocation().getY();

		//1678
		actor.moveTo(nextTravellingPoint.toWorldPoint(), radToJau(Math.atan2(intx,inty)),-1,true,true);//7974 radToJau(Math.atan2(intx,inty))

	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{

		if (event.getMenuEntry().getNpc() != null && event.getMenuEntry().getNpc().getId() == NpcID.ABYSSAL_ORPHAN_5884)
		{
//			System.out.println(event.getMenuEntry().getOption());
//			System.out.println(event.getMenuEntry().getTarget());
//			System.out.println(event.getMenuEntry().getIdentifier());
//
//			System.out.println(event.getMenuEntry().getParam1() + " 1");
//			System.out.println(event.getMenuEntry().getParam0() + " 0");
//
			//System.out.println(client.getMouseCanvasPosition().getX() + " x");;

			client.getSelectedSceneTile();


			actor.getLocalLocation();
			if (actor.getLocalLocation() == client.getSelectedSceneTile().getLocalLocation())
			{
				System.out.println("ran");
			}

			client.getMouseCanvasPosition().getX();

		}
	}


	SimplePolygon poly;

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (actor != null)
		{


			WorldArea worldArea = actor.getWorldLocation().toWorldArea();
			WorldArea worldArea1 = new WorldArea(WorldPoint.fromLocalInstance(client,client.getLocalPlayer().getLocalLocation()),1,1);

			//nextTravellingPoint = worldAreaCustom.calculateNextTravellingPoint(client,worldArea1,true);

			Shape shape = Perspective.getClickbox(client,actor.getRlObject().getModel(), actor.getOrientation(),actor.getLocalLocation().getX(),actor.getLocalLocation().getY(),client.getPlane());


			//System.out.println(shape.contains(client.getMouseCanvasPosition().getX(), client.getCanvasHeight() - client.getMouseCanvasPosition().getY()));


//			Perspective.getCanvasTileAreaPoly(client,actor.getLocalLocation(),1).getBounds().contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY());
//			//System.out.println(	Perspective.getCanvasTileAreaPoly(client,actor.getLocalLocation(),1).contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()));
//
//			System.out.println(shape.getBounds().getMaxX() + " " + shape.getBounds().getMaxY());
//			System.out.println(client.getMouseCanvasPosition().getX() + " " + client.getMouseCanvasPosition().getY());

			//System.out.println(shape.getBounds().getX() + " " + shape.getBounds().getY() + " " + shape.getBounds().getWidth() + " " + shape.getBounds().getHeight());
			//System.out.println(client.getMouseCanvasPosition());


			//System.out.println(shape.contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()));

			LocalPoint lp = LocalPoint.fromWorld(client, actor.getWorldLocation());

			poly = calculateAABB(client,actor.getRlObject().getModel(),actor.getOrientation(),actor.getLocalLocation().getX(),actor.getLocalLocation().getY(),client.getPlane());


			//System.out.println(Arrays.toString(poly.getX()) + " " + Arrays.toString(poly.getY()));
			//System.out.println(poly.contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()));


			Point p = Perspective.localToCanvas(client, lp, client.getPlane(), actor.getRlObject().getModelHeight() / 2);

			if (p.distanceTo(client.getMouseCanvasPosition()) < 40)
			{
				//System.out.println("ran");
			}


			nextTravellingPoint = worldArea.calculateNextTravellingPoint(client,worldArea1,true);
			if (nextTravellingPoint == null)
			{
				System.out.println(worldArea.canTravelInDirection(client,1,0));
				WorldPoint point = new WorldPoint(actor.getWorldLocation().getX() + 1,actor.getWorldLocation().getY(),client.getPlane());
				nextTravellingPoint = new WorldArea(point,1,1);
			}

//			if (nextTravellingPoint == null)
//			{
//				System.out.println("issue");
//			}

			actor.onClientTick(event);
		}
	}

	private static SimplePolygon calculateAABB(Client client, Model m, int jauOrient, int x, int y, int z)
	{
		AABB aabb = m.getAABB(jauOrient);

		int x1 = aabb.getCenterX();
		int y1 = aabb.getCenterZ();
		int z1 = aabb.getCenterY();

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
