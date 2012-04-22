package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import model.Component;
import model.PartsList;

public class View extends JFrame {

	final private PartsList manager;

	private static final long serialVersionUID = 1L;

	protected static final String NameCannotBeEmptyText = "Name darf nicht leer sein!"; // @jve:decl-index=0:

	protected static final String AmountMustBeIntegerText = "Anzahl muss ganze Zahl sein!"; // @jve:decl-index=0:

	protected static final String PriceMustBeIntegerText = "Neuer Preis muss ganze Zahl sein!"; // @jve:decl-index=0:

	protected static final String SelectWholeAndPartFirstText = "Bitte Ganzes und Teil auswählen!"; // @jve:decl-index=0:

	protected static final String SelectComponentFirstText = "Bitte Komponente auswählen!"; // @jve:decl-index=0:

	private JSplitPane mainSplitPane = null;

	private JPanel productPanel = null;

	private JPanel choicePanel = null;

	private JSplitPane productSplitPane = null;

	private JPanel productSelectPanel = null;

	private JPanel directPartPanel = null;

	private JToolBar productToolBar = null;

	private JLabel nameLabel = null;

	private JTextField nameTextField = null;

	private JButton newMaterialButton = null;

	private JButton newProductButton = null;

	private JScrollPane productScrollPane = null;

	private JList productList = null;

	private JScrollPane partsScrollPane = null;

	private JList partsList = null;

	private JToolBar choiceToolBar = null;

	private JScrollPane choiceScrollPane = null;

	private JList choiceList = null;

	private JButton addButton = null;

	private JLabel countLabel = null;

	private JTextField countTextField = null;

	private JLabel statusLabel = null;

	private JToolBar partsToolBar = null;

	private JLabel partsCountLabel = null;

	private JTextField partsCountTextField = null;

	public View(PartsList manager) {
		super();
		this.manager = manager;
		initialize();
		refresh();
	}

	private PartsList getManager() {
		return this.manager;
	}

	private void initialize() {
		statusLabel = new JLabel();
		statusLabel.setText("");
		this.setSize(900, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(getMainSplitPane(), BorderLayout.CENTER);
		this.add(statusLabel, BorderLayout.SOUTH);
	}

	private JSplitPane getMainSplitPane() {
		if (mainSplitPane == null) {
			mainSplitPane = new JSplitPane();
			mainSplitPane.setDividerLocation(650);
			mainSplitPane.setRightComponent(getChoicePanel());
			mainSplitPane.setLeftComponent(getProductPanel());
		}
		return mainSplitPane;
	}

	private JPanel getProductPanel() {
		if (productPanel == null) {
			productPanel = new JPanel();
			productPanel.setLayout(new BorderLayout());
			productPanel.setBorder(BorderFactory.createTitledBorder(null,
					"Produkte und Materialien",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			productPanel.add(getProductSplitPane(), BorderLayout.CENTER);
		}
		return productPanel;
	}

	private JPanel getChoicePanel() {
		if (choicePanel == null) {
			choicePanel = new JPanel();
			choicePanel.setLayout(new BorderLayout());
			choicePanel.setBorder(BorderFactory.createTitledBorder(null,
					"Teile-Auswahl", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			choicePanel.add(getChoiceToolBar(), BorderLayout.SOUTH);
			choicePanel.add(getChoiceScrollPane(), BorderLayout.CENTER);
		}
		return choicePanel;
	}

	private JSplitPane getProductSplitPane() {
		if (productSplitPane == null) {
			productSplitPane = new JSplitPane();
			productSplitPane.setDividerLocation(400);
			productSplitPane.setRightComponent(getPartPanel());
			productSplitPane.setLeftComponent(getProductSelectPanel());
		}
		return productSplitPane;
	}

	private JPanel getProductSelectPanel() {
		if (productSelectPanel == null) {
			productSelectPanel = new JPanel();
			productSelectPanel.setLayout(new BorderLayout());
			productSelectPanel.add(getProductToolBar(), BorderLayout.NORTH);
			productSelectPanel.add(getPriceChangeToolBar(), BorderLayout.SOUTH);
			productSelectPanel.add(getProductScrollPane(), BorderLayout.CENTER);
		}
		return productSelectPanel;
	}
	private JToolBar priceChangeToolBar = null;
	private JToolBar getPriceChangeToolBar() {
		if (this.priceChangeToolBar == null){
			this.priceChangeToolBar = new JToolBar();
			this.priceChangeToolBar.add(getPriceChangeButton());
			this.priceChangeToolBar.add(getPriceChangeTextField());
		}
		return this.priceChangeToolBar;
	}
	private JTextField priceChangeTextField = null;
	private JTextField getPriceChangeTextField() {
		if (this.priceChangeTextField == null){
			this.priceChangeTextField = new JTextField();
		}
		return this.priceChangeTextField;
	}
	private JButton priceChangeButton = null;
	private JButton getPriceChangeButton() {
		if(this.priceChangeButton == null){
			this.priceChangeButton = new JButton();
			this.priceChangeButton.setText("Ändere Preis: ");
			this.priceChangeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					priceChanged_action();
				}
			});
		}
		return this.priceChangeButton;
	}
	protected void priceChanged_action() {
		Component selected = (Component) this.getProductList().getSelectedValue();
		if (selected != null){
			try {
				int newPrice = Integer.parseInt(this.getPriceChangeTextField().getText());
				this.getManager().changePrice(selected,newPrice);
				this.refresh();
				this.statusLabel.setText("");
			}catch(NumberFormatException nfe){
				this.statusLabel.setText(PriceMustBeIntegerText);
			}
		}else{
			this.statusLabel.setText(SelectComponentFirstText);
		}
	}
	private JPanel partPanel = null;

	private JPanel getPartPanel() {
		if (this.partPanel == null) {
			this.partPanel = new JPanel();
			this.partPanel.setLayout(new BorderLayout());
			this.partPanel.add(this.getPartSplitPane(), BorderLayout.CENTER);
		}
		return partPanel;
	}

	private JSplitPane partSplitPane = null;

	private JSplitPane getPartSplitPane() {
		if (this.partSplitPane == null) {
			this.partSplitPane = new JSplitPane();
			this.partSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			this.partSplitPane.setDividerLocation(150);
			this.partSplitPane.setLeftComponent(this.getDirectPartPanel());
			this.partSplitPane.setRightComponent(this.getMaterialListPanel());
		}
		return this.partSplitPane;
	}

	private JPanel materialListPanel = null;

	private JPanel getMaterialListPanel() {
		if (this.materialListPanel == null) {
			this.materialListPanel = new JPanel();
			this.materialListPanel.setLayout(new BorderLayout());
			this.materialListPanel.setBorder(BorderFactory.createTitledBorder(
					null, "Materialliste", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			this.materialListPanel.add(this.getMaterialListScrollPane(),
					BorderLayout.CENTER);
			this.materialListPanel.add(getPartsToolBar(), BorderLayout.NORTH);
			this.materialListPanel.add(getOverallPriceToolBar(), BorderLayout.SOUTH);
		}
		return this.materialListPanel;
	}
	private JToolBar overallPriceToolBar = null;
	private JToolBar getOverallPriceToolBar() {
		if(this.overallPriceToolBar == null){
			this.overallPriceToolBar = new JToolBar();
			this.overallPriceToolBar.add(new JLabel(" Gesamtpreis: "));
			this.overallPriceToolBar.add(this.getOverallPriceTextField());
		}
		return this.overallPriceToolBar;
	}
	private JTextField overallPriceTextField = null;
	private JTextField getOverallPriceTextField() {
		if (overallPriceTextField == null){
			this.overallPriceTextField = new JTextField();
		}
		return this.overallPriceTextField;
	}

	private JScrollPane materialListScrollPane = null;

	private JScrollPane getMaterialListScrollPane() {
		if (this.materialListScrollPane == null) {
			this.materialListScrollPane = new JScrollPane();
			this.materialListScrollPane.setViewportView(this.getMaterialList());
		}
		return this.materialListScrollPane;
	}

	private JList materialList = null;

	private JList getMaterialList() {
		if (this.materialList == null) {
			this.materialList = new JList();
		}
		return this.materialList;
	}

	private JPanel getDirectPartPanel() {
		if (directPartPanel == null) {
			directPartPanel = new JPanel();
			directPartPanel.setLayout(new BorderLayout());
			directPartPanel.setBorder(BorderFactory.createTitledBorder(null,
					"Teile", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			directPartPanel.add(getPartsScrollPane(), BorderLayout.CENTER);
		}
		return directPartPanel;
	}

	private JToolBar getProductToolBar() {
		if (productToolBar == null) {
			nameLabel = new JLabel();
			nameLabel.setText("Name: ");
			productToolBar = new JToolBar();
			productToolBar.add(nameLabel);
			productToolBar.add(getNameTextField());
			productToolBar.add(getNewMaterialButton());
			productToolBar.add(getNewProductButton());
			productToolBar.add(new JLabel(" Preis: "));
		productToolBar.add(getPriceTextField());
		}
		return productToolBar;
	}

	private JTextField priceTextField = null;

	private JTextField getPriceTextField() {
		if (this.priceTextField == null) {
			this.priceTextField = new JTextField();
			this.priceTextField.setText("1");
			this.priceTextField.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e) {
				}
				public void focusLost(FocusEvent e) {
					try {
						Integer.parseInt(getPriceTextField().getText());
					} catch (NumberFormatException nfe){
						View.this.priceTextField.setText("1");						
					}
				}
				
			});
		}
		return this.priceTextField;
	}

	private JTextField getNameTextField() {
		if (nameTextField == null) {
			nameTextField = new JTextField();
		}
		return nameTextField;
	}

	private JButton getNewMaterialButton() {
		if (newMaterialButton == null) {
			newMaterialButton = new JButton();
			newMaterialButton.setText("Erzeuge Material");
			newMaterialButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String name = getNameTextField().getText();
							int price = Integer.parseInt(getPriceTextField().getText());
							if (!name.equals("")) {
								try {
									getManager().createMaterial(name, price);
									refresh();
								} catch (Exception ex) {
									getStatus().setText(ex.getMessage());
								}
							} else {
								getStatus().setText(NameCannotBeEmptyText);
							}
						}
					});
		}
		return newMaterialButton;
	}

	protected void refresh() {
		Vector components = this.getManager().getComponents();
		this.getProductList().setListData(components);
		this.getChoiceList().setListData(components);
		this.getPartsList().setListData(new Vector());
		this.getPartsCountTextField().setText("");
		getStatus().setText("");
		this.getNameTextField().setText("");
		this.getCountTextField().setText("1");
		this.getNameTextField().grabFocus();
	}

	protected JLabel getStatus() {
		return this.statusLabel;
	}

	private JButton getNewProductButton() {
		if (newProductButton == null) {
			newProductButton = new JButton();
			newProductButton.setText("Erzeuge Produkt");
			newProductButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String name = getNameTextField().getText();
							int price = Integer.parseInt(getPriceTextField().getText());
							if (!name.equals("")) {
								try {
									getManager().createProduct(name,price);
									refresh();
								} catch (Exception ex) {
									getStatus().setText(ex.getMessage());
								}
							} else {
								getStatus().setText(NameCannotBeEmptyText);
							}
						}
					});
		}
		return newProductButton;
	}

	private JScrollPane getProductScrollPane() {
		if (productScrollPane == null) {
			productScrollPane = new JScrollPane();
			productScrollPane.setViewportView(getProductList());
		}
		return productScrollPane;
	}

	private JList getProductList() {
		if (productList == null) {
			productList = new JList();
			productList.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Component selected = (Component) getProductList()
							.getSelectedValue();
					if (selected != null) {
						getPartsList().setListData(getManager().getParts(selected));
						getPartsCountTextField().setText(new Integer(getManager().getPartCount(selected)).toString());
						getMaterialList().setListData(getManager().getMaterialList(selected));
						getOverallPriceTextField().setText(getManager().getOverallPrice(selected));
					}
				}
			});
		}
		return productList;
	}

	private JScrollPane getPartsScrollPane() {
		if (partsScrollPane == null) {
			partsScrollPane = new JScrollPane();
			partsScrollPane.setViewportView(getPartsList());
		}
		return partsScrollPane;
	}

	private JList getPartsList() {
		if (partsList == null) {
			partsList = new JList();
		}
		return partsList;
	}

	private JToolBar getChoiceToolBar() {
		if (choiceToolBar == null) {
			countLabel = new JLabel();
			countLabel.setText("Anzahl:");
			choiceToolBar = new JToolBar();
			choiceToolBar.add(countLabel);
			choiceToolBar.add(getCountTextField());
			choiceToolBar.add(getAddButton());
		}
		return choiceToolBar;
	}

	private JScrollPane getChoiceScrollPane() {
		if (choiceScrollPane == null) {
			choiceScrollPane = new JScrollPane();
			choiceScrollPane.setViewportView(getChoiceList());
		}
		return choiceScrollPane;
	}

	private JList getChoiceList() {
		if (choiceList == null) {
			choiceList = new JList();
		}
		return choiceList;
	}

	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText("Teil hinzufügen");
			addButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						int amount = Integer.parseInt(getCountTextField()
								.getText());
						Component whole = (Component) getProductList()
								.getSelectedValue();
						Component part = (Component) getChoiceList()
								.getSelectedValue();
						if (whole != null && part != null) {
							try {
								getManager().addPart(whole, part, amount);
								refresh();
							} catch (Exception ex) {
								getStatus().setText(ex.getMessage());
							}
						} else {
							getStatus().setText(SelectWholeAndPartFirstText);
						}
					} catch (NumberFormatException nfe) {
						getStatus().setText(AmountMustBeIntegerText);
					}
				}
			});
		}
		return addButton;
	}

	private JTextField getCountTextField() {
		if (countTextField == null) {
			countTextField = new JTextField();
		}
		return countTextField;
	}

	private JToolBar getPartsToolBar() {
		if (partsToolBar == null) {
			partsCountLabel = new JLabel();
			partsCountLabel.setText("Anzahl Teile: ");
			partsToolBar = new JToolBar();
			partsToolBar.add(partsCountLabel);
			partsToolBar.add(getPartsCountTextField());
		}
		return partsToolBar;
	}

	private JTextField getPartsCountTextField() {
		if (partsCountTextField == null) {
			partsCountTextField = new JTextField();
		}
		return partsCountTextField;
	}

	public static View create(PartsList list) {
		return new View(list);
	}
} // @jve:decl-index=0:visual-constraint="10,10"
