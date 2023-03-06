package com.example;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

public class OverlayPet extends Overlay
{

    private ExamplePlugin plugin;

    private Client client;

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

        if (plugin.pet.getRlObject() != null && plugin.pet.isActive() && plugin.nextTravellingPoint != null && plugin.poly != null)
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

            if (plugin.wizard.getRlObject() != null && plugin.cutScene)
            {
                Point canvasPoint2 = Perspective.getCanvasTextLocation(client,graphics,plugin.wizard.getLocalLocation(),plugin.message,plugin.wizard.getRlObject().getModelHeight() + 45);
                OverlayUtil.renderTextLocation(graphics,canvasPoint2,plugin.message,Color.YELLOW);
            }



        }


        return null;
    }
}
