package hipster.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import hipster.model.Book;
import hipster.controller.HipsterAppController;
import java.awt.event.*;

public class HipsterPanel extends JPanel
{
	private SpringLayout baseLayout;
	private HipsterPanel basePanel;
	private HipsterAppController baseController;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterAppController baseController)
	{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			phraseComboBox = new JComboBox<String>();
			bookPageCountLabel = new JLabel("The page count");
			bookAuthorLabel = new JLabel("The author");
			bookPriceLabel = new JLabel("The price");
			bookSubjectLabel = new JLabel("The subject");
			bookTitleLabel = new JLabel("The Title");
			changeBookButton = new JButton("Change books");
			maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
			startClick = 0;
			bookPriceLabel = new JLabel();
	
			setupComboBox();
			setupPanel();
			setupLayout();
			setupListeners();

	}

	private void setupComboBox()
	{
			String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
			DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
			phraseComboBox.setModel(phraseModel);
	}

	private void setupPanel()
	{
			this.setLayout(baseLayout);
			this.setBackground(Color.ORANGE);
			this.add(phraseComboBox);
			this.add(bookAuthorLabel);
			this.add(bookSubjectLabel);
			this.add(bookTitleLabel);
			this.add(bookPriceLabel);
			this.add(bookPageCountLabel);
			this.add(changeBookButton);
			
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 5, SpringLayout.NORTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 64, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, changeBookButton, -151, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 133, SpringLayout.EAST, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookTitleLabel, 22, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, bookTitleLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 20, SpringLayout.SOUTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 19, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookSubjectLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookPageCountLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookAuthorLabel, 5, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 10, SpringLayout.NORTH, this);
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int cyan = (int) (Math.random() * 256);
				int brown = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				setBackground(new Color(cyan, brown, green));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
			 
			changeBookButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
					if(startClick < maxClicks)
					{
						bookSubjectLabel.setText("Book subject: " + tempBooks[startClick].getSubject());
						bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
						bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
						bookPageCountLabel.setText("Book pages: " + tempBooks[startClick].getPageCount());
						bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
						startClick++;
					}
					else
					{
						startClick = 0;
						bookSubjectLabel.setText("Book subject: ");
						bookAuthorLabel.setText("Book author: ");
						bookTitleLabel.setText("Book title : ");
						bookPageCountLabel.setText("Book pages:");
						bookPriceLabel.setText("Book price: ");
					}
				}
			
			});
	} 
}
