package com.example.dialog;

import javax.inject.Inject;

import com.example.ExamplePlugin;
import com.google.common.util.concurrent.Runnables;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.chatbox.ChatboxPanelManager;

public class DialogProvider
{

	private static final int PLAYER_TALK_1 = 567;

	private static final String ABYSSAL_ORPHAN_TITLE = "Abyssal Orphan";
	private static final int ABYSSAL_ORPHAN_ANIMATION = -1; // todo, don't have this pet
	
	private static final String LIL_ZIK_TITLE = "Lil' Zik";
	private static final int LIL_ZIK_ANIMATION = 610;

	@Inject
	private Client client;

	@Inject
	private ExamplePlugin plugin;

	// todo confirm line break placements
	public final DialogNode ABYSSAL_ORPHAN =
		DialogNode.builder()
			.npc(NpcID.ABYSSAL_ORPHAN_5884)
			.title(ABYSSAL_ORPHAN_TITLE)
			.animationId(ABYSSAL_ORPHAN_ANIMATION)
			.body("You killed my father.")
			.onContinue(() ->
			{
				// todo is this a dialogue option or randomly chosen?
				if (Math.random() < 0.5)
				{
					return DialogNode.builder()
						.player()
						.animationId(PLAYER_TALK_1) // todo confirm
						.body("Yeah, don't take it personally.")
						.next(

								DialogNode.builder()
							.npc(NpcID.ABYSSAL_ORPHAN_5884)
							.title(ABYSSAL_ORPHAN_TITLE)
							.animationId(ABYSSAL_ORPHAN_ANIMATION)
							.body("In his dying moment, my father poured<br>" +
								  "his last ounce of strength into my creation.<br>" +
								  "My being is formed from his remains.")


							.next(


								DialogNode.builder()
								.npc(NpcID.ABYSSAL_ORPHAN_5884)
								.title(ABYSSAL_ORPHAN_TITLE)
								.animationId(ABYSSAL_ORPHAN_ANIMATION)
								.body("When your own body is consumed to<br>" +
									  "nourish the Nexus, and an army of<br>" +
									  "scions arises from your corpse, I<br>" +
									  "trust you will not take it personally either.")

										.next(

											  DialogNode.builder()
												.player()
												.title(ABYSSAL_ORPHAN_TITLE)
												.animationId(PLAYER_TALK_1)
												.body("Suck my peen")
												.build())

								.build())
							.build())
						.build();
				}
				else
				{
					return DialogNode.builder()
						.player()
						.animationId(PLAYER_TALK_1) // todo confirm
						.body("No, I am your father.")
						.onContinue(() ->
						{
							if (client.getLocalPlayer().getPlayerComposition().getGender() == 1)
							{
								return DialogNode.builder()
									.npc(NpcID.ABYSSAL_ORPHAN_5884)
									.title(ABYSSAL_ORPHAN_TITLE)
									.animationId(ABYSSAL_ORPHAN_ANIMATION)
									.body("Human biology may be unfamiliar to me,<br>" +
										  "but nevertheless I doubt that very much.")
									.build();
							}
							else
							{
								return DialogNode.builder()
									.npc(NpcID.ABYSSAL_ORPHAN_5884)
									.title(ABYSSAL_ORPHAN_TITLE)
									.animationId(ABYSSAL_ORPHAN_ANIMATION)
									.body("No, you are not.")
									.build();
							}
						})
						.build();
				}
			})
			.build();

	public final DialogNode LIL_ZIK_4 =
		DialogNode.builder()
			.player()
			.animationId(PLAYER_TALK_1)
			.body("Hi, I'm here for my reward!")
			.next(DialogNode.builder()
				.npc(NpcID.LIL_ZIK_8337)
				.title(LIL_ZIK_TITLE)
				.body("Not again...")
				.animationId(LIL_ZIK_ANIMATION)
				.build()
			).build();


	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private FakePetDialog fakePetDialog;

	@Inject
	private ClientThread clientThread;

	public final DialogNode CALL_THE_WIZARD =
		 	DialogNode.builder()
					.player()
					.animationId(PLAYER_TALK_1)
					.body("Finally after 1800 tires ive got you.")
					.onContinue(() ->

							DialogNode.builder()
							.npc(NpcID.LIL_ZIK_8337)
							.title(LIL_ZIK_TITLE)
							.body("Thank heavens a top 5 gamer!<br>"+
									"Please hide me from the mean wizard<br>"+
									"He wants to take me back.")
							.animationId(LIL_ZIK_ANIMATION)
							.next
							(
									DialogNode.builder()
									.player()
									.body("Oh boy, this is a real head scratcher.")
									.animationId(PLAYER_TALK_1)
									.onContinue
									(()->
									{
										chatboxPanelManager
										.openTextMenuInput("Select an option")
										.option("Call the wizard",()-> clientThread.invokeLater(()->plugin.runCutScene()))
										.option("Do Nothing", Runnables.doNothing())
										.build();
										return null;
									}
									)
									.build()
							)
							.build()
					)
					.build();







}
