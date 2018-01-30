package com.example.myapplication.samples.crud;

import com.example.myapplication.samples.backend.data.Product;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

//Class for creating a window for the release of a book. Offers also validation if a book is already released or not.

public class ReleaseWindows extends Window {
	private static final long serialVersionUID = 1L;

	public ReleaseWindows(ProductGrid griddata, Object object) {
		super("Bookapproval");
		center();
		VerticalLayout content = new VerticalLayout();
		content.setHeight("150px");
		content.setMargin(true);
		content.setStyleName(ValoTheme.WINDOW_TOP_TOOLBAR);

		// Checks if a book is already released or not.

		if (((Product) griddata.getValue(object)).getApprovedStatus() == false) {

			content.addComponent(new Label("Do you really want to approve the book: "));
			content.addComponent(new Label(((Product) griddata.getValue(object)).getProductName() + "?"));

			setContent(content);

			Button close = new Button("Yes");

			close.setWidth("50%");
			close.addClickListener(new ClickListener() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					close();
				}

			});
			Button closeit = new Button("No");

			closeit.addClickListener(new ClickListener() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					close();
				}

			});

			// A wide component bar
			HorizontalLayout horizontal = new HorizontalLayout();
			horizontal.setWidth("100%");

			// Have a component before the gap (a collapsing cell)
			Button button1 = new Button("Yes");
			horizontal.addComponent(button1);
			button1.setWidth("150px");
			button1.addClickListener(new ClickListener() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					close();
				}

			});

			// An expanding gap spacer
			Label expandingGap = new Label();
			expandingGap.setWidth("100%");
			horizontal.addComponent(expandingGap);
			horizontal.setExpandRatio(expandingGap, 1.0f);

			// A component after the gap (a collapsing cell)
			Button button2 = new Button("No");
			horizontal.addComponent(button2);
			button2.setWidth("150px");
			button2.addClickListener(new ClickListener() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					close();
				}

			});

			content.addComponent(horizontal);
			
			
			//Actions, when a book is already released
		} else {
			content.addComponent(new Label("The book " + ((Product) griddata.getValue(object)).getProductName()));
			content.addComponent(new Label("is already approved!"));
			setContent(content);
			Button close = new Button("Ok");
			close.setWidth("150px");
			close.addClickListener(new ClickListener() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					close();
				}

			});
			content.addComponent(close);
		}
	}
}