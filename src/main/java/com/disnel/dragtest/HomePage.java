package com.disnel.dragtest;

import java.util.Arrays;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.jquery.ui.interaction.draggable.DraggableBehavior;
import com.googlecode.wicket.jquery.ui.interaction.droppable.DroppableBehavior;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		WebMarkupContainer bd;
		add(bd = new WebMarkupContainer("bd"));
		
		bd.add(new ListView<String>("draggable", Arrays.asList("One", "Two", "Three", "Four"))
		{

			@Override
			protected void populateItem(ListItem<String> item)
			{
				item.add(new Label("content", Model.of(item.getModelObject())));
				
				item.add(new DraggableBehavior(".draggable")
				{
					
					@Override
					public void onDragStop(AjaxRequestTarget target, int top, int left)
					{
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onDragStart(AjaxRequestTarget target, int top, int left)
					{
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public boolean isStopEventEnabled()
					{
						// TODO Auto-generated method stub
						return false;
					}
				}
				.setOption("revert", "'invalid'")
				);
			}
		});
		
		WebMarkupContainer dropTarget;
		bd.add(dropTarget = new WebMarkupContainer("drop_target"));

		dropTarget.add(new DroppableBehavior("#drop_target")
		{
			
			@Override
			public void onOver(AjaxRequestTarget target, Component component)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onExit(AjaxRequestTarget target, Component component)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrop(AjaxRequestTarget target, Component component)
			{
				System.out.println("Dropped: " + component.getDefaultModelObjectAsString());
			}
			
			@Override
			public boolean isOverEventEnabled()
			{
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isExitEventEnabled()
			{
				// TODO Auto-generated method stub
				return false;
			}
		});
		
    }
}
