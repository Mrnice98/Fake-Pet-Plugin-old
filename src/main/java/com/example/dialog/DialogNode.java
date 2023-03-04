package com.example.dialog;

import java.util.function.Supplier;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class DialogNode
{
	
	public static final DialogNode TERMINAL = DialogNode.builder().build();

	DialogType type;

	boolean player;
	int npcId;
	int animationId;
	
	@Builder.Default
	String title = null;
	String body;

	@Builder.Default
	Supplier<DialogNode> onContinue = () -> TERMINAL;
	
	public DialogNode getNext()
	{
		if (this.onContinue == null)
		{
			return null;
		}

		return this.onContinue.get();
	}

	public int getLineHeight()
	{
		switch (this.body.split("<br>").length)
		{
			case 2:
				return 28;
			case 3:
				return 20;
			default:
				return 16;
		}
	}

	public static class DialogNodeBuilder
	{
		private DialogNodeBuilder npcId(int npcId) 
		{
			return this;
		}
		
		private DialogNodeBuilder type(DialogType type) 
		{
			return this;
		}
		
		public DialogNodeBuilder player()
		{
			this.player = true;
			this.type = DialogType.DIALOG_HEAD_RIGHT;
			return this;
		}

		public DialogNodeBuilder npc(int npcId)
		{
			this.npcId = npcId;
			this.type = DialogType.DIALOG_HEAD_LEFT;
			return this;
		}
		
		public DialogNodeBuilder next(DialogNode next)
		{
			this.onContinue(() -> next);
			return this;
		}
	}

}
