package com.example;

import net.runelite.api.FontID;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.*;
import net.runelite.client.game.chatbox.ChatboxInput;
import net.runelite.client.game.chatbox.ChatboxPanelManager;

import javax.inject.Inject;

public class ChatboxThing extends ChatboxInput
{
    @Inject
    ChatboxPanelManager chatboxPanelManager;

    public void createThing()
    {

        Widget header = chatboxPanelManager.getContainerWidget();

        if (header == null)
        {
            return;
        }

        //have another pet spawn and say 'sorry about that dont know how this one got out

        header.deleteAllChildren();

        //Creation of the search and toggle status buttons
        Widget musicSearchButton = header.createChild(-1, WidgetType.TEXT);
        musicSearchButton.setSpriteId(SpriteID.GE_SEARCH);
        musicSearchButton.setOriginalWidth(18);
        musicSearchButton.setOriginalHeight(17);
        musicSearchButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
        musicSearchButton.setOriginalX(5);
        musicSearchButton.setOriginalY(32);
        musicSearchButton.setText("test");
        musicSearchButton.setHasListener(true);
        musicSearchButton.setAction(1, "Open");
        musicSearchButton.setOnOpListener(null);
        musicSearchButton.setName("Search");
        musicSearchButton.setHidden(false);
        musicSearchButton.revalidate();

        open();

    }




}
