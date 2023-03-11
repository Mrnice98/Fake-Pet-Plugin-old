package com.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.AsyncBufferedImage;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

@Singleton
public class FakePetPanel extends PluginPanel {

    private final ExamplePlugin plugin;
    private final ExampleConfig config;

    @Inject
    public FakePetPanel(ExamplePlugin plugin,
                        ExampleConfig config,
                        JPanel sidePanel,
                        JPanel titlePanel,
                        JPanel petButtonsPanel,
                        ItemManager itemManager,
                        JPanel petSelectionTitlePanel,
                        JPanel currentPetTitle,
                        JPanel currentPetPanel,
                        JLabel currentPetIcon,
                        JPanel spacerPanel,
                        JPanel spacerPanelTop)
    {
        this.plugin = plugin;
        this.config = config;
        this.sidePanel = sidePanel;
        this.titlePanel = titlePanel;
        this.petButtonsPanel = petButtonsPanel;
        this.petSelectionTitlePanel = petSelectionTitlePanel;
        this.currentPetTitle = currentPetTitle;
        this.currentPetPanel = currentPetPanel;
        this.currentPetIcon = currentPetIcon;
        this.spacerPanelBottom = spacerPanel;
        this.spacerPanelTop = spacerPanelTop;
    }


    private final JPanel sidePanel;

    private final JPanel titlePanel;

    private final JPanel petButtonsPanel;


    public void sidePanelInitializer()
    {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel,BoxLayout.Y_AXIS));
        this.sidePanel.add(this.buildTitlePanel());
        //this.sidePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        this.sidePanel.add(this.buildCurrentPetTitle());
        this.sidePanel.add(this.buildCurrentPetPanel());
        this.sidePanel.add(this.buildSpacerPanelTop());
        this.sidePanel.add(this.buildPetSelectionTitle());
        this.sidePanel.add(this.buildPetButtonsPanel());
        this.sidePanel.add(this.buildSpacerPanelBottom());


        this.add(sidePanel, "North");
    }

    private JPanel buildTitlePanel()
    {
        titlePanel.setBorder(new CompoundBorder(new EmptyBorder(5, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));
        titlePanel.setLayout(new BorderLayout());
        PluginErrorPanel errorPanel = new PluginErrorPanel();
        errorPanel.setBorder(new EmptyBorder(2, 0, 3, 0));
        errorPanel.setFont(FontManager.getRunescapeBoldFont());
        errorPanel.setContent("Fake Pet Plugin", "Allows you to spawn any pet in the game");
        titlePanel.add(errorPanel, "Center");
        return titlePanel;
    }



    @Inject
    private ItemManager itemManager;

    @Inject
    private ClientThread clientThread;

    private final JPanel petSelectionTitlePanel;

    private JPanel buildPetSelectionTitle()
    {
        petSelectionTitlePanel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));

        petSelectionTitlePanel.setLayout(new FlowLayout());


        if (plugin.petData == null)
        {
            plugin.petData = PetData.pets.get(config.pet().getIdentifier());
        }

        JLabel title = new JLabel("Pet Selector");
        title.setFont(FontManager.getRunescapeBoldFont());
        title.setForeground(Color.LIGHT_GRAY);


        petSelectionTitlePanel.add(title,"Center");


        return petSelectionTitlePanel;
    }



    private final JPanel currentPetTitle;


    private JPanel buildCurrentPetTitle()
    {
        currentPetTitle.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));

        currentPetTitle.setLayout(new FlowLayout());


        if (plugin.petData == null)
        {
            plugin.petData = PetData.pets.get(config.pet().getIdentifier());
        }

        JLabel title = new JLabel("Current Pet");
        title.setFont(FontManager.getRunescapeBoldFont());
        title.setForeground(Color.LIGHT_GRAY);


        currentPetTitle.add(title,"Center");


        return currentPetTitle;
    }


    private final JPanel currentPetPanel;

    private final JLabel currentPetIcon;

    private JPanel buildCurrentPetPanel()
    {
        currentPetPanel.setBorder(new CompoundBorder(new EmptyBorder(0, 20, 0, 0), new MatteBorder(0, 0, 0, 0, new Color(42, 255, 0, 89))));

        currentPetPanel.setLayout(new BorderLayout());

        updateCurrentPetIcon();

        currentPetPanel.add(currentPetIcon,"Center");

        return currentPetPanel;
    }



    public void updateCurrentPetIcon()
    {
        if (plugin.petData == null)
        {
            plugin.petData = PetData.pets.get(config.pet().getIdentifier());
        }

        AsyncBufferedImage icon = itemManager.getImage(plugin.petData.getIconID());
        Runnable resize = () ->
        {
            currentPetIcon.setIcon(new ImageIcon(icon.getScaledInstance(200,200,Image.SCALE_SMOOTH)));
            currentPetIcon.setToolTipText(plugin.petData.getName());
        };
        icon.onLoaded(resize);
        resize.run();
    }


    private final JPanel spacerPanelBottom;
    private final JPanel spacerPanelTop;

    private JPanel buildSpacerPanelTop()
    {
        spacerPanelTop.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));
        return spacerPanelTop;
    }


    private JPanel buildSpacerPanelBottom()
    {
        spacerPanelBottom.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));
        return spacerPanelBottom;
    }


    private JPanel buildPetButtonsPanel()
    {

        petButtonsPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        final int rowSize = ((PetData.values().length % 4 == 0) ? 0 : 1) + PetData.values().length / 4;

        petButtonsPanel.setLayout(new GridLayout(rowSize,4,2,2));

        for (PetData petData : PetData.values())
        {
            Icon icon = new ImageIcon(itemManager.getImage(petData.getIconID()));

            JButton button = new JButton(icon);
            button.setToolTipText(petData.getName());
            button.setBackground(ColorScheme.DARKER_GRAY_COLOR);
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, ColorScheme.DARK_GRAY_COLOR),
                    new EmptyBorder(0, 5, 0, 0)
            ));


            button.addActionListener(e-> clientThread.invokeLater(()-> plugin.updatePet(petData)));
            //SwingUtil.removeButtonDecorations(button);
            petButtonsPanel.add(button);
        }

        return petButtonsPanel;
    }


}
