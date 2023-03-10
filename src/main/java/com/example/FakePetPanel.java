package com.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

@Singleton
public class FakePetPanel extends PluginPanel {

    private final ExamplePlugin plugin;
    private final ExampleConfig config;

    private static JLabel timerLabel;
    private static JButton button;

    @Inject
    public FakePetPanel(ExamplePlugin plugin, ExampleConfig config, JPanel sidePanel, JPanel titlePanel, JPanel petButtonsPanel, ItemManager itemManager, JPanel petSelectionTitlePanel, JPanel currentPetPanel)
    {
        this.plugin = plugin;
        this.config = config;
        this.sidePanel = sidePanel;
        this.titlePanel = titlePanel;
        this.petButtonsPanel = petButtonsPanel;


//        setLayout(new BorderLayout(0, 4));
//        setBackground(ColorScheme.DARK_GRAY_COLOR);
//        setBorder(new EmptyBorder(8, 8, 8, 8));
//        JPanel mainContent = new JPanel(new BorderLayout());
//
//        button = new JButton("Start");
//        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
//        button.setForeground(Color.WHITE);
//        button.setBackground(ColorScheme.DARKER_GRAY_COLOR);
//        button.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createMatteBorder(1, 1, 1, 1, ColorScheme.DARK_GRAY_COLOR),
//                new EmptyBorder(20, 4, 20, 4)
//        ));
//
//        timerLabel = new JLabel("3:30", SwingConstants.CENTER);
//        timerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
//
//        button.addActionListener(e -> Runnables.doNothing());
//
//        mainContent.add(timerLabel, BorderLayout.NORTH);
//        mainContent.add(button, BorderLayout.SOUTH);
//
//        add(mainContent, BorderLayout.CENTER);

        this.petSelectionTitlePanel = petSelectionTitlePanel;
        this.currentPetPanel = currentPetPanel;
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
        this.sidePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        this.sidePanel.add(this.buildCurrentPetPanel());
        this.sidePanel.add(this.buildPetSelectionTitle());
        this.sidePanel.add(this.buildPetButtonsPanel());







        this.add(sidePanel, "North");
    }

    private JPanel buildTitlePanel()
    {
        titlePanel.setBorder(new CompoundBorder(new EmptyBorder(5, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));
        titlePanel.setLayout(new BorderLayout());
        PluginErrorPanel errorPanel = new PluginErrorPanel();
        errorPanel.setBorder(new EmptyBorder(2, 0, 3, 0));
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

        JLabel title = new JLabel("Select A Pet");

        petSelectionTitlePanel.add(title,"Center");


        return petSelectionTitlePanel;
    }


    private final JPanel currentPetPanel;

    private JPanel buildCurrentPetPanel()
    {
        currentPetPanel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));

       // currentPetPanel.setLayout(new FlowLayout());

        if (plugin.petData == null)
        {
            plugin.petData = PetData.pets.get(config.pet().getIdentifier());
        }

        AsyncBufferedImage bossSprite = itemManager.getImage(plugin.petData.getIconID());

        ImageIcon imageIcon = new ImageIcon(resizeImage(bossSprite,bossSprite.getWidth(),bossSprite.getHeight()));

        JLabel title = new JLabel(imageIcon);



        currentPetPanel.add(title,"Center");


        return currentPetPanel;
    }

    public static BufferedImage resizeImage(BufferedImage image, int newWidth, int newHeight)
    {
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = scaledImage.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return scaledImage;
    }



    private JPanel buildPetButtonsPanel()
    {


        petButtonsPanel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new MatteBorder(0, 0, 1, 0, new Color(42, 255, 0, 89))));


        final int rowSize = ((PetData.values().length % 4 == 0) ? 0 : 1) + PetData.values().length / 4;

        petButtonsPanel.setLayout(new GridLayout(2,4,2,2));

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


    public void setButtonText(String text)
    {
        button.setText(text);
    }

    public void setTimerText(String text)
    {
        timerLabel.setText(text);
    }

    public void reset()
    {
        setTimerText("3:30");
        setButtonText("Start");
    }

}
