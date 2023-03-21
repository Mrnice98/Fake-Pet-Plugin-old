package com.example;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

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

    @Inject
    private ConfigManager configManager;

    private final JPanel petSelectionTitlePanel;

    private JPanel buildPetSelectionTitle()
    {
        petSelectionTitlePanel.removeAll();

        petSelectionTitlePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        petSelectionTitlePanel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));

        petSelectionTitlePanel.setLayout(new FlowLayout());


        if (plugin.petData == null)
        {
            plugin.petData = PetData.pets.get(config.pet().getIdentifier());
        }


        BufferedImage invisibleIcon = ImageUtil.loadImageResource(ExamplePlugin.class, "/invisible_icon.png");
        BufferedImage visibleIcon = ImageUtil.loadImageResource(ExamplePlugin.class, "/visible_icon.png");

        BufferedImage bufferedIcon = config.filter() ? visibleIcon : invisibleIcon;
        String hoverText = config.filter() ? "Filter Pets" : "Un-Filter Pets";

        JButton button = new JButton(new ImageIcon(bufferedIcon));

        button.setRolloverIcon(new ImageIcon(ImageUtil.luminanceOffset(bufferedIcon, -80)));
        Dimension dimension = new Dimension(5,5);
        button.setSize(dimension);
        button.setMaximumSize(dimension);
        button.setToolTipText(hoverText);
        button.addActionListener(e-> {

            try
            {
                update();

            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }


        });

        SwingUtil.removeButtonDecorations(button);



        JLabel title = new JLabel("Pet Selector");
        title.setFont(FontManager.getRunescapeBoldFont());
        title.setForeground(Color.LIGHT_GRAY);

        petSelectionTitlePanel.add(Box.createRigidArea(new Dimension(55, 0)),"Left");
        petSelectionTitlePanel.add(title,"Center");
        petSelectionTitlePanel.add(Box.createRigidArea(new Dimension(15, 0)),"Right");
        petSelectionTitlePanel.add(button,"Right");



        return petSelectionTitlePanel;
    }


    private void update() throws InterruptedException
    {
        configManager.setConfiguration("example","filter",!config.filter());
        buildPetButtonsPanel();
        buildPetSelectionTitle();
        //sleeping the swing thread for 1 client tick to allow the panel to update
        Thread.sleep(20);

        petButtonsPanel.revalidate();
        petSelectionTitlePanel.revalidate();
        petButtonsPanel.repaint();
        petSelectionTitlePanel.repaint();
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

        petButtonsPanel.removeAll();

        petButtonsPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        PetData[] petList = config.filter() ?  PetData.values() : PetData.petsToShow.toArray(new PetData[0]);

        for (PetData petData : petList)
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
            petButtonsPanel.add(button);
        }

        final int rowSize = ((petButtonsPanel.getComponents().length % 4 == 0) ? 0 : 1) + petButtonsPanel.getComponents().length / 4;
        petButtonsPanel.setLayout(new GridLayout(rowSize,4,2,2));

        return petButtonsPanel;
    }


}
