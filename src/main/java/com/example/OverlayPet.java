package com.example;

import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.awt.*;

public class OverlayPet extends Overlay
{

    @Inject
    ExamplePlugin plugin;

    @Override
    public Dimension render(Graphics2D graphics)
    {
        
        graphics.draw(plugin.poly);

        return null;
    }
}
