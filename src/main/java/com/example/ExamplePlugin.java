package com.example;

import com.example.dialog.DialogProvider;
import com.example.dialog.FakePetDialog;
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
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.ObjectModel.radToJau;
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


	int delayForHouse;

	WorldPoint lastPlayerWP;
	WorldPoint lastActorWP;
	int lastActorOrientation;

	boolean petFollowing = false;

	boolean petEnterHouse;

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		System.out.println(gameStateChanged.getGameState());
		if (gameStateChanged.getGameState() == GameState.LOADING && pet.isActive())
		{
			lastPlayerWP = client.getLocalPlayer().getWorldLocation();
			lastActorWP = pet.getWorldLocation();
			lastActorOrientation = pet.getOrientation();

			pet.despawn();
		}

		if (gameStateChanged.getGameState() == GameState.LOGGED_IN && petFollowing && client.getVarbitValue(6719) == 0)
		{

			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			WorldPoint aWP = pet.getWorldLocation();

			double intx = aWP.toWorldArea().getX() - wp.toWorldArea().getX();
			double inty = aWP.toWorldArea().getY() - wp.toWorldArea().getY();


			if (lastPlayerWP.distanceTo(client.getLocalPlayer().getWorldLocation()) < 5)
			{
				pet.spawn(lastActorWP,lastActorOrientation);
				pet.setAnimation(pet.animationPoses[0]);
			}
			else
			{
				pet.spawn(client.getLocalPlayer().getWorldLocation(),radToJau(Math.atan2(intx,inty)));
				pet.setAnimation(pet.animationPoses[0]);
			}

			nextTravellingPoint = pet.getWorldLocation().toWorldArea();

		}


	}


	ObjectModel pet = new ObjectModel();
	WorldArea nextTravellingPoint;
	Model petModel;

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

	ObjectModel wizard = new ObjectModel();

	//add thing to handle hopping, when you hop your pet teles too you

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{

		String message = event.getMessage();
		if (message.equals("You do not have a follower.") && event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (pet.getRlObject() == null || !pet.isActive())
			{
				petModel = (Model) client.loadModelData(29631).light();


				ModelData modelData = client.loadModelData(29631).cloneVertices();//29631 //39196
				//modelData.scale(30,30,30);
				petModel = modelData.light();


				//Perspective.getCanvasTextLocation()
				pet.init(client);
				pet.setPoseAnimations(7125,7124,7124);
				pet.setModel(petModel);


//				actor.getRlObject().setDrawFrontTilesFirst(true);
//				actor.getRlObject().setRadius(1);

			}

			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			WorldPoint aWP = pet.getWorldLocation();

			boolean petHasLOS = wp.toWorldArea().hasLineOfSightTo(client,aWP);

			if (wp.toWorldArea().distanceTo(aWP.toWorldArea()) < 6 && petHasLOS && pet.isActive())
			{
				event.getMessageNode().setValue("Your follower is already close enough.");
				//return;
			}
			else if (pet.isActive())
			{
				pet.despawn();
			}


			double intx = aWP.toWorldArea().getX() - wp.toWorldArea().getX();
			double inty = aWP.toWorldArea().getY() - wp.toWorldArea().getY();

			event.getMessageNode().setValue("");

			petFollowing = true;

			pet.spawn(getPathOutWorldPoint(client.getLocalPlayer().getWorldArea()),radToJau(Math.atan2(intx,inty)));
			pet.setAnimation(pet.animationPoses[0]); //0 == walk
			nextTravellingPoint = pet.getWorldLocation().toWorldArea();

		}


		if (event.getMessage().equals("!Set"))
		{
			//+64 + 30,+850 + 30,-30,-50,-30 .scale(65,65,65)
			petModel = (Model) client.loadModelData(29631).light();
		}
		if (event.getMessage().equals("!Test"))
		{
			pet.init(client);
			//actor.setModel((Model) client.loadModel(11056).scale(64,64,64));
			WorldPoint wPoint = client.getLocalPlayer().getWorldLocation();
			//light(+64,+850,-30,-50,-30) are defualt values for npcs
			pet.setModel(petModel);

			Player player = client.getLocalPlayer();


			double intx = pet.getWorldLocation().toWorldArea().getX() - player.getWorldLocation().toWorldArea().getX();
			double inty = pet.getWorldLocation().toWorldArea().getY() - player.getWorldLocation().toWorldArea().getY();



			WorldPoint point = new WorldPoint(client.getLocalPlayer().getWorldLocation().getX() ,client.getLocalPlayer().getWorldLocation().getY(),client.getPlane());

			pet.moveTo(point,radToJau(Math.atan2(intx,inty)));

		}

		if (event.getMessage().equals("!Go"))
		{




		}

		if (event.getMessage().equals("!Anim"))
		{
			double intx = wizard.getWorldLocation().toWorldArea().getX() - pet.getWorldLocation().toWorldArea().getX();
			double inty = wizard.getWorldLocation().toWorldArea().getY() - pet.getWorldLocation().toWorldArea().getY();

			//343 graphic
			wizard.getRlObject().setAnimation(client.loadAnimation(714));
			wizard.spawn(getPathOutWorldPoint(pet.getWorldLocation().toWorldArea()),radToJau(Math.atan2(intx,inty)));

		}

	}

	private static ModelData createModel(Client client, ModelData... data)
	{
		return client.mergeModels(data);
	}

	private static ModelData createModel(Client client, int... data)
	{
		ModelData[] modelData = new ModelData[data.length];
		for (int i = 0; i < data.length; i++)
		{
			modelData[i] = client.loadModelData(data[i]);
		}
		return client.mergeModels(modelData);
	}





	private final List<WorldPoint> prevPlayerWPs = new ArrayList<>();



	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{

		if (varbitChanged.getVarbitId() == 6719 && varbitChanged.getValue() == 0)
		{
			petEnterHouse = petFollowing;
		}

	}

	WorldArea petWorldArea = null;

	private void spawnPetInHouse()
	{
		if (petEnterHouse && petFollowing)
		{
			petEnterHouse = false;
			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			WorldPoint aWP = pet.getWorldLocation();

			double intx = aWP.toWorldArea().getX() - wp.toWorldArea().getX();
			double inty = aWP.toWorldArea().getY() - wp.toWorldArea().getY();

			pet.spawn(client.getLocalPlayer().getWorldLocation(),radToJau(Math.atan2(intx,inty)));
			pet.setAnimation(pet.animationPoses[0]);
			nextTravellingPoint = pet.getWorldLocation().toWorldArea();
		}

	}

	@Subscribe
	public void onGameTick(GameTick event)
	{

		if (cutScene)
		{
			updateWizardActions();
		}

		spawnPetInHouse();

		if (pet == null || !pet.isActive())
		{
			return;
		}

		Player player = client.getLocalPlayer();
		double intx = pet.getLocalLocation().getX() - player.getLocalLocation().getX();
		double inty = pet.getLocalLocation().getY() - player.getLocalLocation().getY();



		if (nextTravellingPoint != null)
		{
			petWorldArea = nextTravellingPoint;
		}


		WorldPoint worldPoint = getAndUpdatePlayersDelayedLoc();
		WorldArea worldArea1 = new WorldArea(worldPoint,1,1);


		nextTravellingPoint = petWorldArea.calculateNextTravellingPoint(client,worldArea1,true);


		if (nextTravellingPoint == null && client.getLocalPlayer().getLocalLocation().distanceTo(pet.getLocalLocation()) < 100)
		{
			nextTravellingPoint = new WorldArea(getPathOutWorldPoint(pet.getWorldLocation().toWorldArea()),1,1);
		}

		if (pet.isActive() && nextTravellingPoint != null && !cutScene)
		{
			pet.moveTo(nextTravellingPoint.toWorldPoint(), radToJau(Math.atan2(intx,inty)));
		}


	}

	private WorldPoint getAndUpdatePlayersDelayedLoc()
	{

		WorldPoint worldPoint = null;

		prevPlayerWPs.add(0,client.getLocalPlayer().getWorldLocation());

		if (prevPlayerWPs.size() >= 2)
		{
			worldPoint = prevPlayerWPs.get(1);
		}

		if (worldPoint == null)
		{
			worldPoint = client.getLocalPlayer().getWorldLocation();
		}

		if (prevPlayerWPs.size() > 10)
		{
			prevPlayerWPs.subList(10, prevPlayerWPs.size()).clear();
		}

		return worldPoint;
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
			if (poly.contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()) && pet.isActive())
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


	@Inject
	private DialogProvider dialogProvider;

	@Inject
	private FakePetDialog fakePetDialog;

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuTarget().contains("Abyssal orphan") && event.getMenuOption().equals("Pick-up"))
		{
			if (pet.isActive() && pet.getWorldLocation().toWorldArea().isInMeleeDistance(client.getLocalPlayer().getWorldArea()))
			{
				petFollowing = false;
				pet.despawn();
			}

		}

		if (event.getMenuTarget().contains("Abyssal orphan") && event.getMenuOption().equals("Talk-to"))
		{
			if (pet.isActive() && pet.getWorldLocation().toWorldArea().isInMeleeDistance(client.getLocalPlayer().getWorldArea()))
			{

				fakePetDialog.open(dialogProvider.CALL_THE_WIZARD);


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







	boolean cutScene = false;
	int gameTickCutSceneStart;
	public String message;

	public void runCutScene()
	{
		if (cutScene)
		{
			return;
		}

		cutScene = true;
		gameTickCutSceneStart = client.getTickCount();

		short clothingColor = JagexColor.rgbToHSL(new Color(102, 93, 44).getRGB(), 0.6d);
		short blue = JagexColor.rgbToHSL(Color.BLUE.getRGB(), 1.0d);

		ModelData skirt = client.loadModelData(265).cloneColors().recolor((short)25238, clothingColor);

		ModelData shirt = client.loadModelData(292).cloneColors().recolor((short)8741, clothingColor);

		ModelData arms = client.loadModelData(170).cloneColors().recolor((short)8741, clothingColor);

		ModelData cape = client.loadModelData(323).cloneColors()
				.recolor((short) 926, blue) // Inside
				.recolor((short) 7700, blue) // Mail cape
				.recolor((short) 11200, (short)8741); // Trim

		ModelData partyhat = client.loadModelData(187).cloneColors().recolor((short)926, blue);

		ModelData mdf = createModel(client,
		  9103, // face
				4925, // beard
				176, // hands
				181); // feet

		mdf = createModel(client, mdf, skirt, shirt, arms, cape, partyhat);
		Model model = mdf.light();

		wizard.init(client);
		wizard.setModel(model);

		double intx = wizard.getWorldLocation().toWorldArea().getX() - pet.getWorldLocation().toWorldArea().getX();
		double inty = wizard.getWorldLocation().toWorldArea().getY() - pet.getWorldLocation().toWorldArea().getY();

		wizard.getRlObject().setAnimation(client.loadAnimation(813));
		wizard.spawn(getPathOutWorldPoint(pet.getWorldLocation().toWorldArea()),radToJau(Math.atan2(intx,inty)));

	}

	public void updateWizardActions()
	{
		switch (client.getTickCount() - gameTickCutSceneStart)
		{
			case 1:
				message = "Hey, How'd you get out of your cage?";
				wizard.getRlObject().setAnimation(client.loadAnimation(857));
				client.addChatMessage(ChatMessageType.GAMEMESSAGE,"", "MrNice98: <col=0000ff>"+message+"</col>","");
				break;

			case 10:
				message = "Dont you know your clippers pet";
				wizard.getRlObject().setAnimation(client.loadAnimation(813));
				client.addChatMessage(ChatMessageType.GAMEMESSAGE,"","MrNice98: <col=0000ff>"+message+"</col>","");
				break;

			case 20:
				message = "Sorry, i gotta bring him back to clipper";
				client.addChatMessage(ChatMessageType.GAMEMESSAGE,"","MrNice98: <col=0000ff>"+message+"</col>","");//<col=ef1020>58:40</col>58:40</col>
				break;

			case 30:
				message = "Best i can do is a dupe Lil' Grumble";
				client.addChatMessage(ChatMessageType.GAMEMESSAGE,"","MrNice98: <col=0000ff>"+message+"</col>","");
				break;

			case 35:
				message = "Toodaloo!";
				wizard.getRlObject().setAnimation(client.loadAnimation(714));
				client.addChatMessage(ChatMessageType.GAMEMESSAGE,"","MrNice98: <col=0000ff>"+message+"</col>","");
				break;

			case 37:
				wizard.getRlObject().setActive(false);
				pet.getRlObject().setActive(false);
				break;
		}
	}


	@Subscribe
	public void onClientTick(ClientTick event)
	{

		if (cutScene)
		{
			double intx = wizard.getWorldLocation().toWorldArea().getX() - pet.getWorldLocation().toWorldArea().getX();
			double inty = wizard.getWorldLocation().toWorldArea().getY() - pet.getWorldLocation().toWorldArea().getY();
			wizard.rotateObject(intx,inty);
		}

		if (pet != null)
		{

			List<LocalPoint> localPoints = new ArrayList<>();
			List<Player> nonLocalPlayers = client.getPlayers().stream().filter(player -> !player.getName().equals(client.getLocalPlayer().getName())).collect(Collectors.toList());
			nonLocalPlayers.forEach(player -> localPoints.add(player.getLocalLocation()));
			client.getNpcs().forEach(npc -> localPoints.add(npc.getLocalLocation()));

			boolean overlappingModel = localPoints.stream().anyMatch(localPoint -> localPoint.equals(pet.getLocalLocation()));

			if (pet.animationPoses[0].getId() == pet.getRlObject().getAnimation().getId() && overlappingModel)
			{
				pet.setModel(client.loadModel(0));
			}
			else if (!overlappingModel)
			{
				pet.setModel(petModel);
			}

			LocalPoint lp = pet.getLocalLocation();
			int zOff = Perspective.getTileHeight(client,lp,client.getPlane());

			poly = calculateAABB(client, pet.getRlObject().getModel(), pet.getOrientation(), pet.getLocalLocation().getX(), pet.getLocalLocation().getY(),client.getPlane(), zOff);

			if (!cutScene)
			{
				pet.onClientTick(event);
			}

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
