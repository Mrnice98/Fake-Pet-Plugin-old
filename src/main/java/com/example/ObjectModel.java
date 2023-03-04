

//Code adapted and modified from Justin Ead (Jebrim)'s JebScapeActor class
package com.example;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;


public class ObjectModel
{
	private Client client;
	private RuneLiteObject rlObject;

	private class Target
	{
		public WorldPoint wpDest;
		public LocalPoint lpDest;
		public int currentDistance;
	}

	private final int MAX_TARGET_QUEUE_SIZE = 10;
	private Target[] targetQueue = new Target[MAX_TARGET_QUEUE_SIZE];
	private int cTargetIndex;
	private int targetQueueSize;
	private int lastDistance;

	private enum POSE_ANIM
	{
		IDLE,
		WALK,
		RUN,
	}

	public Animation[] animationPoses = new Animation[3];
	
	
	public void init(Client client)
	{
		this.client = client;
		this.rlObject = client.createRuneLiteObject();
		for (int i = 0; i < MAX_TARGET_QUEUE_SIZE; i++)
		{
			targetQueue[i] = new Target();
		}
	}
	
	public void setModel(Model model)
	{
		rlObject.setModel(model);
	}

	public RuneLiteObject getRlObject()
	{
		return rlObject;
	}
	
	public void spawn(WorldPoint position, int jauOrientation)
	{
		LocalPoint localPosition = LocalPoint.fromWorld(client, position);
		if (localPosition != null && client.getPlane() == position.getPlane())
		{
			rlObject.setLocation(localPosition, position.getPlane());
		}
		else
		{
			rlObject.setLocation(new LocalPoint(0, 0), client.getPlane());
		}

		rlObject.setOrientation(jauOrientation);
		rlObject.setShouldLoop(true);
		rlObject.setActive(true);
		this.lastDistance = 0;
		this.cTargetIndex = 0;
		this.targetQueueSize = 0;
	}
	
	public void despawn()
	{
		rlObject.setActive(false);
		this.lastDistance = 0;
		this.cTargetIndex = 0;
		this.targetQueueSize = 0;
	}
	
	public void setPoseAnimations(int idle, int walk, int run)
	{
		this.animationPoses[POSE_ANIM.IDLE.ordinal()] = client.loadAnimation(idle);//7125
		this.animationPoses[POSE_ANIM.WALK.ordinal()] = client.loadAnimation(walk);//7124
		this.animationPoses[POSE_ANIM.RUN.ordinal()] = client.loadAnimation(run);
	}
	
	public WorldPoint getWorldLocation()
	{
		return targetQueueSize > 0 ? targetQueue[cTargetIndex].wpDest : WorldPoint.fromLocal(client, rlObject.getLocation());
	}

	public void setAnimation(Animation animation)
	{
		rlObject.setAnimation(animation);
	}

	public LocalPoint getLocalLocation()
	{
		return rlObject.getLocation();
	}
	
	public boolean isActive()
	{
		return rlObject.isActive();
	}

	public int getOrientation()
	{
		return rlObject.getOrientation();
	}

	
	// moveTo() adds target movement states to the queue for later per-frame updating for rendering in onClientTick()
	// Set this every game tick for each new position (usually only up to 2 tiles out)
	// This is not set up for pathfinding to the final destination of distant targets (you will just move there directly)
	// It will, however, handle nearby collision detection (1-2 tiles away from you) under certain scenarios
	// jauOrientation is not used if isInteracting is false; it will instead default to the angle being moved towards
	public void moveTo(WorldPoint worldPosition, int jauOrientation)
	{

		// respawn this actor if it was previously despawned
		if (!rlObject.isActive())
		{
			spawn(worldPosition, jauOrientation);
		}

		// just clear the queue and move immediately to the destination if many ticks behind
		if (targetQueueSize >= MAX_TARGET_QUEUE_SIZE - 2)
		{
			targetQueueSize = 0;
		}


		int prevTargetIndex = (cTargetIndex + targetQueueSize - 1) % MAX_TARGET_QUEUE_SIZE;
		int newTargetIndex = (cTargetIndex + targetQueueSize) % MAX_TARGET_QUEUE_SIZE;
		LocalPoint localPosition = LocalPoint.fromWorld(client, worldPosition);

		if (localPosition == null)
		{
			return;
		}

		// use current position if nothing is in queue
		WorldPoint prevWorldPosition;
		if (targetQueueSize++ > 0)
		{
			prevWorldPosition = targetQueue[prevTargetIndex].wpDest;
		}
		else
		{
			prevWorldPosition = WorldPoint.fromLocal(client, rlObject.getLocation());
		}

		int distance = prevWorldPosition.distanceTo(worldPosition);

		this.targetQueue[newTargetIndex].wpDest = worldPosition;
		this.targetQueue[newTargetIndex].lpDest = LocalPoint.fromWorld(client,worldPosition);
		this.targetQueue[newTargetIndex].currentDistance = distance;

	}


	// onClientTick() updates the per-frame state needed for rendering actor movement
	public boolean onClientTick(ClientTick clientTick)
	{
		if (rlObject.isActive())
		{

			if (targetQueueSize > 0)
			{
				int targetPlane = targetQueue[cTargetIndex].wpDest.getPlane();

				LocalPoint targetPosition = targetQueue[cTargetIndex].lpDest;


				if (client.getPlane() != targetPlane || targetPosition == null || !targetPosition.isInScene())
				{
					// this actor is no longer in a visible area on our client, so let's despawn it
					despawn();
					return false;
				}

				//apply animation if move-speed / distance has changed
				if (lastDistance != targetQueue[cTargetIndex].currentDistance)
				{
					int distance = targetQueue[cTargetIndex].currentDistance;
					// we don't want to go beyond run (speed of 2)
					rlObject.setAnimation(distance > 2 ? null : animationPoses[distance]);

					if (rlObject.getAnimation() == null)
					{
						rlObject.setAnimation(animationPoses[1]);
					}

				}

				this.lastDistance = targetQueue[cTargetIndex].currentDistance;

				LocalPoint currentPosition = rlObject.getLocation();
				int dx = targetPosition.getX() - currentPosition.getX();
				int dy = targetPosition.getY() - currentPosition.getY();
				
				// are we not where we need to be?
				if (dx != 0 || dy != 0)
				{

					int speed = 4;

					if (speed > 0)
					{
						// only use the delta if it won't send up past the target
						if (Math.abs(dx) > speed)
						{
							dx = Integer.signum(dx) * speed;
						}

						if (Math.abs(dy) > speed)
						{
							dy = Integer.signum(dy) * speed;
						}

					}

					LocalPoint newLocation = new LocalPoint(currentPosition.getX() + dx, currentPosition.getY() + dy);
					rlObject.setLocation(newLocation, targetPlane);

					dx = targetPosition.getX() - rlObject.getLocation().getX();
					dy = targetPosition.getY() - rlObject.getLocation().getY();
				}


				double intx = rlObject.getLocation().getX() - client.getLocalPlayer().getLocalLocation().getX();
				double inty = rlObject.getLocation().getY() - client.getLocalPlayer().getLocalLocation().getY();

				boolean rotationDone = rotateObject(intx,inty);

				// have we arrived at our target?
				if (dx == 0 && dy == 0 && rotationDone)
				{
					// if so, pull out the next target
					cTargetIndex = (cTargetIndex + 1) % MAX_TARGET_QUEUE_SIZE;
					targetQueueSize--;
				}

			}

			return true;
		}
		
		return false;
	}

	public boolean rotateObject(double intx, double inty)
	{

		final int JAU_FULL_ROTATION = 2048;
		int targetOrientation = radToJau(Math.atan2(intx, inty));
		int currentOrientation = rlObject.getOrientation();

		int dJau = (targetOrientation - currentOrientation) % JAU_FULL_ROTATION;

		if (dJau != 0)
		{
			final int JAU_HALF_ROTATION = 1024;
			final int JAU_TURN_SPEED = 32;
			int dJauCW = Math.abs(dJau);

			if (dJauCW > JAU_HALF_ROTATION)// use the shortest turn
			{
				dJau = (currentOrientation - targetOrientation) % JAU_FULL_ROTATION;
			}

			else if (dJauCW == JAU_HALF_ROTATION)// always turn right when turning around
			{
				dJau = dJauCW;
			}


			// only use the delta if it won't send up past the target
			if (Math.abs(dJau) > JAU_TURN_SPEED)
			{
				dJau = Integer.signum(dJau) * JAU_TURN_SPEED;
			}


			int newOrientation = (JAU_FULL_ROTATION + rlObject.getOrientation() + dJau) % JAU_FULL_ROTATION;

			rlObject.setOrientation(newOrientation);

			dJau = (targetOrientation - newOrientation) % JAU_FULL_ROTATION;
		}

		return dJau == 0;
	}

	static int radToJau(double a)
	{
		int j = (int) Math.round(a / Perspective.UNIT); // [0, 2048) for a in [0, 2pi)
		return j & 2047;
	}

}
