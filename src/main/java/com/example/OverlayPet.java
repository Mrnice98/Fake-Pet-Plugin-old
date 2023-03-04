package com.example;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

public class OverlayPet extends Overlay
{

    ExamplePlugin plugin;

    Client client;

    @Inject
    public OverlayPet(ExamplePlugin plugin, Client client)
    {
        this.plugin = plugin;
        this.client = client;
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
    }


    @Override
    public Dimension render(Graphics2D graphics)
    {

        if (plugin.actor.isActive() && plugin.nextTravellingPoint != null && plugin.poly != null)
        {
            if (plugin.poly.contains(client.getMouseCanvasPosition().getX(),client.getMouseCanvasPosition().getY()))
            {
                graphics.setColor(Color.GREEN);
            }
            else
            {
                graphics.setColor(Color.WHITE);
            }

            graphics.draw(plugin.poly);

            WorldPoint wp = new WorldPoint(plugin.nextTravellingPoint.getX(),plugin.nextTravellingPoint.getY(),client.getPlane());
            LocalPoint point = LocalPoint.fromWorld(client,wp);
            graphics.draw(Perspective.getCanvasTilePoly(client,point));





            graphics.setFont(FontManager.getRunescapeBoldFont());


            Point canvasPoint2 = Perspective.getCanvasTextLocation(client,graphics,plugin.actor.getLocalLocation(),"BLAMMMOOOOOOOOOOO",plugin.actor.getRlObject().getModelHeight());
            OverlayUtil.renderTextLocation(graphics,canvasPoint2,"BLAMMMOOOOOOOOOOO",Color.YELLOW);



        }


        return null;
    }
}
