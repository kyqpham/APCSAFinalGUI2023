import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DessertBar
  {
    //home frame initializations
    //setting up
    private JFrame frame;
    private JPanel homePanel;
    private int itemCounter = 0;
    private JLabel generalGreetings, generalDirections;
        
    private JMenuBar menuBar;
    private JMenu drinkMenu, dessertMenu, snackMenu, exitMenu;

    //totals, prices, totals
    private int runningTotal = 0;
    private int tipPrice = 0;
    private JLabel totalNumberOfItems;
    private JLabel runningTotalLabel;

    //tip or no button
    private JRadioButton noTipOption;
    private JRadioButton tipOption;
    private ButtonGroup tipRadioButtonGroup;

    //setting up drink options
    private JMenuItem coffeeOption;
    private JMenuItem sparklingWaterOption;
    private JMenuItem teaOption;

    //setting up main dessert option
    private JMenuItem cakeOption;
    private JMenuItem macaronsOption;
    private JMenuItem icecreamOption;

    //setting up the snacks option
    private JMenuItem candyOption;
    private JMenuItem fruitOption;
    private JMenuItem cookiesOption;

    //check out options
    private JMenuItem exitOption;
    private JMenuItem checkOutOption;

    //exit buttons
    private JButton exitButton;

    //drink directions
    private JLabel coffeeDirections, sparklingWaterDirections, teaDirections;

    //setting up the coffee panel + components
    private JPanel coffeeFlavorPanel;
    
    private JCheckBox coffeeHazelnut, coffeeCaramel, coffeeVanillaBean;

    private int coffeeHazelnutPrice = 5;
    private int coffeeCaramelPrice = 6;
    private int coffeeVanillaBeanPrice = 7;

    //setting up the sparkling water panel + components
    private JPanel sparklingWaterFlavorPanel;
    
    private JCheckBox sparklingWaterKiwi, sparklingWaterOrange, sparklingWaterPassionfruit;

    private int sparklingWaterKiwiPrice = 3;
    private int sparklingWaterOrangePrice = 4;
    private int sparklingWaterPassionfruitPrice = 5;

    //setting up the tea panel + components
    private JPanel teaFlavorPanel;

    private JCheckBox teaPeppermint, teaJasmine, teaBlack;

    private int teaPeppermintPrice = 6;
    private int teaJasminePrice = 7;
    private int teaBlackPrice = 8;

    //dessert directions
    private JLabel cakeDirections, macaronDirections, icecreamDirections;

    //setting up the cake panel + components
    private JPanel cakeFlavorPanel;

    private JCheckBox cakeVanilla, cakeChocolate, cakeStrawberry;

    private int cakeChocolatePrice = 10;
    private int cakeVanillaPrice = 15;
    private int cakeStrawberryPrice = 20;

    //setting up the macaron panel + components    
    private JPanel macaronFlavorPanel;

    private JCheckBox macaronMango, macaronBlueberry, macaronPeach;

    private int macaronMangoPrice = 10;
    private int macaronBlueberryPrice = 11;
    private int macaronPeachPrice = 12;

    //setting up the ice cream panel + components
    private JPanel icecreamFlavorPanel;

    private JCheckBox icecreamRaspberry, icecreamMint, icecreamPistachio;

    private int icecreamRaspberryPrice = 15;
    private int icecreamMintPrice = 20;
    private int icecreamPistachioPrice = 25;

    //snack directions
    private JLabel candyDirections, fruitDirections, cookiesDirections;
    
    //setting up the candy flavor panel + components
    private JPanel candyFlavorPanel;

    private JCheckBox candyLollyPop, candyLaffyTaffy, candyMilkChocolate;

    private int candyLollyPopPrice = 2;
    private int candyLaffyTaffyPrice = 3;
    private int candyMilkChocolatePrice = 4;

    //setting up the fruit flavor panel + components
    private JPanel fruitFlavorPanel;

    private JCheckBox fruitPineapple, fruitNectarine, fruitGuava;

    private int fruitPineapplePrice = 10;
    private int fruitNectarinePrice = 20;
    private int fruitGuavaPrice = 30;

    //setting up the cookie flavor panel + components
    private JPanel cookiesFlavorPanel;

    private JCheckBox cookieRedVelvet, cookieSugar, cookieSnickerDoodle;

    private int cookieRedVelvetPrice = 8;
    private int cookieSugarPrice = 9;
    private int cookieSnickerDoodlePrice = 10;

    //check out frame
    private JFrame checkOutFrame;

    //check out panels in the frame
    private JPanel tipPanel, itemPanel, pricePanel, exitDirectionsPanel, returnHomePanel;

    //exit directions
    private JLabel exitDirectionsLabel;

    //final price set up
    private JLabel finalTotalLabel;
    private int finalTotal = 0;

    //returning home set up
    private JButton returnHomeButton;
    
    //tip panel set up
    private JLabel tipLabel;

    //item counter setup
    private int drinkCounter;
    private int dessertCounter;
    private int snackCounter;

    //item panel
    private JLabel drinkCounterLabel;
    private JLabel dessertCounterLabel;
    private JLabel snackCounterLabel;

    //declaring everything
    public DessertBar ()
    {
      homePanel = new JPanel();
      homePanel.setPreferredSize(new Dimension (225, 150));
      homePanel.setLayout(new GridLayout(5, 1));

      frame = new JFrame ("Dessert Bar");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());

      //intro + directions
      generalGreetings = new JLabel ("ZuZu's Famous Dessert Bar" + "   ");      
      //item + total counter
      totalNumberOfItems = new JLabel ("Items In Cart: " + itemCounter);
      runningTotalLabel = new JLabel ("Running Total: " + runningTotal);
      generalDirections = new JLabel ("Use the menu bar to order!");

      //tip option buttons
      tipOption = new JRadioButton("Tip");
      noTipOption = new JRadioButton("No Tip");
      tipRadioButtonGroup = new ButtonGroup();

      //radio button action listeners
      tipOption.addActionListener(new tipOptionListener());
      noTipOption.addActionListener(new tipOptionListener());
      
      tipRadioButtonGroup.add(tipOption);
      tipRadioButtonGroup.add(noTipOption);
      tipRadioButtonGroup.clearSelection();

      homePanel.add(generalGreetings);
      homePanel.add(totalNumberOfItems);
      homePanel.add(runningTotalLabel);
      homePanel.add(tipOption);
      homePanel.add(noTipOption);

      frame.getContentPane().add(homePanel, BorderLayout.NORTH);
      frame.getContentPane().add(generalDirections, BorderLayout.SOUTH);

      //setting up the menu
      menuBar = new JMenuBar();
      exitMenu = new JMenu("Exit");
      drinkMenu = new JMenu("Drinks");
      dessertMenu = new JMenu("Desserts");
      snackMenu = new JMenu("Snacks");
      frame.setJMenuBar(menuBar);
      menuBar.add(exitMenu);
      menuBar.add(drinkMenu);
      menuBar.add(dessertMenu);
      menuBar.add(snackMenu);

      //setting up the items of the check outs
      exitOption = new JMenuItem("Exit");
      checkOutOption = new JMenuItem("Checkout");
      exitMenu.add(exitOption);
      exitMenu.add(checkOutOption);

      //setting up the items of the drink 
      coffeeOption = new JMenuItem("Coffee");
      sparklingWaterOption = new JMenuItem("Sparkling Water");
      teaOption = new JMenuItem("Tea");
      drinkMenu.add(coffeeOption);
      drinkMenu.add(sparklingWaterOption);
      drinkMenu.add(teaOption);

      //setting up the items of the dessert
      cakeOption = new JMenuItem("Cake");
      macaronsOption = new JMenuItem("Macarons");
      icecreamOption = new JMenuItem("Ice Cream");
      dessertMenu.add(cakeOption);
      dessertMenu.add(macaronsOption);
      dessertMenu.add(icecreamOption);

      //setting up the items of the snacks
      fruitOption = new JMenuItem("Fruit");
      cookiesOption = new JMenuItem("Cookies");
      candyOption = new JMenuItem("Candy");
      snackMenu.add(fruitOption);
      snackMenu.add(cookiesOption);
      snackMenu.add(candyOption);

      //adding action listeners for drinks
      coffeeOption.addActionListener(new drinkActionListener());
      sparklingWaterOption.addActionListener(new drinkActionListener());
      teaOption.addActionListener(new drinkActionListener());  

      //setting the exit button
      exitButton = new JButton ("Home");

      //setting up the drink header + panel
      coffeeFlavorPanel = new JPanel();
      coffeeFlavorPanel.setPreferredSize(new Dimension (225, 150));
      coffeeFlavorPanel.setLayout(new GridLayout(5,1));
      
      coffeeDirections = new JLabel ("Choose a coffee flavor!");
      coffeeFlavorPanel.add(coffeeDirections);

      //setting the labels + radio groups for drinks
      coffeeHazelnut = new JCheckBox("Hazelnut: $" + coffeeHazelnutPrice);
      coffeeCaramel = new JCheckBox("Caramel: $" + coffeeCaramelPrice);
      coffeeVanillaBean = new JCheckBox("Vanilla Bean: $" + coffeeVanillaBeanPrice);

      //adding the flavors to the panel
      coffeeFlavorPanel.add(coffeeHazelnut);
      coffeeFlavorPanel.add(coffeeCaramel);
      coffeeFlavorPanel.add(coffeeVanillaBean);

      //setting up the sparkling water option
      //sparkling water header + panel + fundamentals
      sparklingWaterFlavorPanel = new JPanel();
      sparklingWaterFlavorPanel.setPreferredSize(new Dimension (225, 150));
      sparklingWaterFlavorPanel.setLayout(new GridLayout(5,1));
      
      //directions header
      sparklingWaterDirections = new JLabel ("Choose a water flavor!");
      sparklingWaterFlavorPanel.add(sparklingWaterDirections);

      //sparkling water flavor options
      sparklingWaterKiwi = new JCheckBox ("Kiwi: $" + sparklingWaterKiwiPrice);
      sparklingWaterOrange = new JCheckBox("Orange: $" + sparklingWaterOrangePrice);
      sparklingWaterPassionfruit = new JCheckBox ("Passionfruit $" + sparklingWaterPassionfruitPrice);

      //adding the flavors to the panel
      sparklingWaterFlavorPanel.add(sparklingWaterKiwi);
      sparklingWaterFlavorPanel.add(sparklingWaterOrange);
      sparklingWaterFlavorPanel.add(sparklingWaterPassionfruit);

      //setting up the  tea option
      //tea fundamentals
      teaFlavorPanel = new JPanel();
      teaFlavorPanel.setPreferredSize(new Dimension (225, 150));
      teaFlavorPanel.setLayout(new GridLayout(5,1));

      //tea directions header
      teaDirections = new JLabel ("Choose a tea flavor!");
      teaFlavorPanel.add(teaDirections);

      //tea flavors
        teaPeppermint = new JCheckBox ("Peppermint: $" + teaPeppermintPrice);
      teaBlack = new JCheckBox("Black: $" + teaBlackPrice);
      teaJasmine = new JCheckBox ("Jasmine:  $" + teaJasminePrice);

      //adding the flavors to the panel
      teaFlavorPanel.add(teaPeppermint);
      teaFlavorPanel.add(teaBlack);
      teaFlavorPanel.add(teaJasmine);

      //action listener
      exitButton.addActionListener(new exitButtonListener());

      //drink option listeners
      coffeeHazelnut.addItemListener(new coffeeOptionListener());
      coffeeCaramel.addItemListener(new coffeeOptionListener());
      coffeeVanillaBean.addItemListener(new coffeeOptionListener());

      sparklingWaterKiwi.addItemListener(new sparklingWaterOptionListener());
      sparklingWaterOrange.addItemListener(new sparklingWaterOptionListener());
      sparklingWaterPassionfruit.addItemListener(new sparklingWaterOptionListener());
      
      teaPeppermint.addItemListener(new teaOptionListener());
      teaBlack.addItemListener(new teaOptionListener());
      teaJasmine.addItemListener(new teaOptionListener());


      //creating panels for the the cake flavors + desserts
      cakeFlavorPanel = new JPanel();
      cakeFlavorPanel.setPreferredSize(new Dimension (225, 150));
      cakeFlavorPanel.setLayout(new GridLayout (5, 1));

      //cake directions
      cakeDirections = new JLabel ("Choose a cake flavor!");
      cakeFlavorPanel.add(cakeDirections);

      //initializing the checkboxes
      cakeChocolate = new JCheckBox ("Chocolate: $" + cakeChocolatePrice);
      cakeVanilla = new JCheckBox ("Vanilla: $" + cakeVanillaPrice);
      cakeStrawberry = new JCheckBox ("Strawberry: $" + cakeStrawberryPrice );

      cakeFlavorPanel.add(cakeChocolate);
      cakeFlavorPanel.add(cakeVanilla);
      cakeFlavorPanel.add(cakeStrawberry);

       //action listeners for cakes 
      cakeOption.addActionListener(new dessertOptionListener());

      cakeChocolate.addItemListener(new cakeOptionListener());
      cakeVanilla.addItemListener (new cakeOptionListener());
      cakeStrawberry.addItemListener(new cakeOptionListener());

      //setting up the macaron panel + components
      macaronFlavorPanel = new JPanel();
      macaronFlavorPanel.setPreferredSize(new Dimension(225, 150));
      macaronFlavorPanel.setLayout(new GridLayout(5, 1));

      //macaron directions
      macaronDirections = new JLabel ("Choose a macaron flavor!");
      macaronFlavorPanel.add(macaronDirections);

      //macaron option listener
      macaronsOption.addActionListener(new dessertOptionListener());

      //initializing the macaron flavors
      macaronMango = new JCheckBox("Mango: $" + macaronMangoPrice);
      macaronBlueberry = new JCheckBox("Blueberry: $" + macaronBlueberryPrice);
      macaronPeach = new JCheckBox ("Peach: $" + macaronPeachPrice);

      macaronFlavorPanel.add(macaronMango);
      macaronFlavorPanel.add(macaronBlueberry);
      macaronFlavorPanel.add(macaronPeach);

      //action listeners for the macarons
      macaronMango.addItemListener(new macaronsOptionListener());
      macaronBlueberry.addItemListener(new macaronsOptionListener());
      macaronPeach.addItemListener(new macaronsOptionListener());

      //setting up the ice cream panel + components
      icecreamFlavorPanel = new JPanel();
      icecreamFlavorPanel.setPreferredSize(new Dimension(225, 150));
      icecreamFlavorPanel.setLayout(new GridLayout(5, 1));

      //ice cream directions
      icecreamDirections = new JLabel("Choose an icecream flavor!");
      icecreamFlavorPanel.add(icecreamDirections);

      //icecream action listener
      icecreamOption.addActionListener(new dessertOptionListener());

      //initializing ice cream flavors
      icecreamRaspberry = new JCheckBox("Raspberry: $" + icecreamRaspberryPrice);
      icecreamMint = new JCheckBox("Mint: $" + icecreamMintPrice);
      icecreamPistachio = new JCheckBox("Pistachio: $" + icecreamPistachioPrice);

      icecreamFlavorPanel.add(icecreamRaspberry);
      icecreamFlavorPanel.add(icecreamMint);
      icecreamFlavorPanel.add(icecreamPistachio);

      //adding action listeners for ice cream flavors
      icecreamRaspberry.addItemListener(new icecreamOptionListener());
      icecreamMint.addItemListener(new icecreamOptionListener());
      icecreamPistachio.addItemListener(new icecreamOptionListener());

      //setting up the snacks panel
      //candy panel + components
      candyFlavorPanel = new JPanel();
      candyFlavorPanel.setPreferredSize(new Dimension(225, 150));
      candyFlavorPanel.setLayout(new GridLayout(5, 1));

      //candy directions
      candyDirections = new JLabel ("Choose a candy!");
      candyFlavorPanel.add(candyDirections);

      candyOption.addActionListener(new snackActionListener());

      candyLaffyTaffy = new JCheckBox("Laffy Taffy: $" + candyLaffyTaffyPrice);
      candyLollyPop = new JCheckBox("Lollypop: $" + candyLollyPopPrice);
      candyMilkChocolate = new JCheckBox("Milk Chocolate: $" + candyMilkChocolatePrice);

      candyFlavorPanel.add(candyLaffyTaffy);
      candyFlavorPanel.add(candyLollyPop);
      candyFlavorPanel.add(candyMilkChocolate);

      //adding action listeners for candy flavors
      candyLaffyTaffy.addItemListener (new candyOptionListener());
      candyLollyPop.addItemListener (new candyOptionListener());
      candyMilkChocolate.addItemListener (new candyOptionListener());

      //setting up the fruit panel + components
      fruitFlavorPanel = new JPanel();
      fruitFlavorPanel.setPreferredSize(new Dimension (225, 150));
      fruitFlavorPanel.setLayout(new GridLayout(5, 1));
      
      //fruit directions
      fruitDirections = new JLabel ("Choose a fruit!");
      fruitFlavorPanel.add(fruitDirections);

      fruitOption.addActionListener(new snackActionListener());

      fruitPineapple = new JCheckBox ("Pineapple: $" + fruitPineapplePrice);
      fruitNectarine = new JCheckBox ("Nectarine: $" + fruitNectarinePrice);
      fruitGuava = new JCheckBox ("Guava: $" + fruitGuavaPrice);

      fruitFlavorPanel.add(fruitPineapple);
      fruitFlavorPanel.add(fruitNectarine);
      fruitFlavorPanel.add(fruitGuava);

      //adding action listeners for the fruit
      fruitPineapple.addItemListener(new fruitOptionListener());
      fruitNectarine.addItemListener(new fruitOptionListener());
      fruitGuava.addItemListener(new fruitOptionListener());

      //setting up the  cookie panel + components
      cookiesFlavorPanel = new JPanel();
      cookiesFlavorPanel.setPreferredSize(new Dimension(225, 150));
      cookiesFlavorPanel.setLayout(new GridLayout(5, 1));

      cookiesDirections = new JLabel ("Choose a cookie flavor!");
      cookiesFlavorPanel.add(cookiesDirections);
      
      cookiesOption.addActionListener(new snackActionListener());

      cookieRedVelvet = new JCheckBox("Red Velvet: $" + cookieRedVelvetPrice);
      cookieSugar = new JCheckBox("Vanilla Sugar: $" + cookieSugarPrice);
      cookieSnickerDoodle  = new JCheckBox("Snicker Doodle: $" + cookieSnickerDoodlePrice);

      cookiesFlavorPanel.add(cookieRedVelvet);
      cookiesFlavorPanel.add(cookieSugar);
      cookiesFlavorPanel.add(cookieSnickerDoodle);

      //action listeners for the cookie flavors
      cookieRedVelvet.addItemListener(new cookieOptionListener());
      cookieSugar.addItemListener (new cookieOptionListener());
      cookieSnickerDoodle.addItemListener (new cookieOptionListener());

      //exit frame set up
      checkOutFrame = new JFrame ("Check Out");
      checkOutFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      checkOutFrame.setLayout(new BorderLayout());

      exitDirectionsPanel = new JPanel ();
      exitDirectionsPanel.setPreferredSize(new Dimension (100, 75));
      
      //exit directions
      exitDirectionsLabel  = new JLabel ("Proceed to check out.");
      exitDirectionsPanel.add(exitDirectionsLabel);

      //final prices
      pricePanel = new JPanel();
      pricePanel.setPreferredSize(new Dimension (100, 75));
      pricePanel.setBorder(BorderFactory.createTitledBorder("Final Price"));

      finalTotalLabel = new JLabel("Final Total: $" + finalTotal);

      pricePanel.add(finalTotalLabel);

      //exit panel
      returnHomePanel = new JPanel();
      returnHomePanel.setPreferredSize(new Dimension (100, 75));

      returnHomeButton = new JButton ("Return Home");
      returnHomePanel.add(returnHomeButton);

      //tip panel
      tipPanel = new JPanel();
      tipPanel.setPreferredSize(new Dimension(100, 75));
      tipPanel.setBorder(BorderFactory.createTitledBorder("Tip"));

      tipLabel = new JLabel("Tip: $" + tipPrice);
      tipPanel.add(tipLabel);

      //item panel
      itemPanel = new JPanel();
      itemPanel.setPreferredSize(new Dimension (100, 75));
      itemPanel.setLayout(new GridLayout (5, 1));
      itemPanel.setBorder (BorderFactory.createTitledBorder("Receipt"));

      drinkCounterLabel = new JLabel ("Drinks: " + drinkCounter);
      dessertCounterLabel = new JLabel ("Desserts: " + dessertCounter);
      snackCounterLabel = new JLabel ("Snacks: " + snackCounter);

      itemPanel.add(drinkCounterLabel);
      itemPanel.add(dessertCounterLabel);
      itemPanel.add(snackCounterLabel);

      checkOutFrame.getContentPane().add(exitDirectionsPanel, BorderLayout.NORTH);
      checkOutFrame.getContentPane().add(pricePanel, BorderLayout.EAST);
      checkOutFrame.getContentPane().add(tipPanel, BorderLayout.WEST);
      checkOutFrame.getContentPane().add(returnHomePanel, BorderLayout.SOUTH);
      checkOutFrame.getContentPane().add(itemPanel, BorderLayout.CENTER);

      //action listeners for check out frame button
      exitOption.addActionListener(new fileListener());
      checkOutOption.addActionListener (new fileListener());
      
      returnHomeButton.addActionListener(new exitButtonListener());
      
      //setting panels to visible or false
      homePanel.setVisible(false);
      coffeeFlavorPanel.setVisible(false);
      sparklingWaterFlavorPanel.setVisible(false);
      teaFlavorPanel.setVisible(false);
      cakeFlavorPanel.setVisible(false);
      macaronFlavorPanel.setVisible(false);
      icecreamFlavorPanel.setVisible(false);
      candyFlavorPanel.setVisible(false);
      fruitFlavorPanel.setVisible(false);
      cookiesFlavorPanel.setVisible(false);
      checkOutFrame.setVisible(false);
    }

    //creating file listeners
    private class fileListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
          Object source = event.getSource();
          if (source.equals(checkOutOption))
          {
            frame.setVisible(false);
            checkOutFrame.setVisible(true);
            checkOutFrame.pack();
          }
          else if (source.equals(exitOption))
          {
            System.exit(0);
          }
        }
      }

    //creating drink listeners
    private class drinkActionListener implements ActionListener
      {
        public void actionPerformed (ActionEvent event)
        {
          Object source = event.getSource();
          if (source.equals(coffeeOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(coffeeFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(coffeeFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);
          }
          else if (source.equals(sparklingWaterOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(sparklingWaterFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add (sparklingWaterFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);
          }
          else 
          {
            generalDirections.setVisible(false);
            panelVisibility(teaFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(teaFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);
          }
        }
      }
    
    private class coffeeOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == coffeeHazelnut)
          {
            if (coffeeHazelnut.isSelected()) 
            {
              runningTotal += coffeeHazelnutPrice;
              itemCounter++;
              drinkCounter++;
            }
            else 
            {
              runningTotal -= coffeeHazelnutPrice;
              itemCounter--;
            }
          }
          else if (event.getSource() == coffeeCaramel)
          {
            if (coffeeCaramel.isSelected()) 
            {
              runningTotal += coffeeCaramelPrice;
              itemCounter++;
              drinkCounter++;
            }
            else 
            {
              runningTotal -= coffeeCaramelPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          else if (event.getSource() == coffeeVanillaBean)
          {
            if (coffeeVanillaBean.isSelected()) 
            {
              runningTotal += coffeeVanillaBeanPrice;
              itemCounter++;
              drinkCounter++;
            }
            else 
            {
              runningTotal -= coffeeVanillaBeanPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);
          runningTotalLabel.setText("Running Total: " + runningTotal);
        }
      }

    private class sparklingWaterOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == sparklingWaterKiwi)
          {
            if (sparklingWaterKiwi.isSelected())
            {
              runningTotal += sparklingWaterKiwiPrice;
              itemCounter++;
              drinkCounter++;
            }
            else 
            {
              runningTotal -= sparklingWaterKiwiPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          else if (event.getSource() == sparklingWaterOrange)
          {
            if (sparklingWaterOrange.isSelected())
            {
              runningTotal += sparklingWaterOrangePrice;
              itemCounter++;
              drinkCounter++;
            }
            else
            {
              runningTotal-= sparklingWaterOrangePrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          else if (event.getSource() == sparklingWaterPassionfruit)
          {
            if (sparklingWaterPassionfruit.isSelected())
            {
              runningTotal += sparklingWaterPassionfruitPrice;
              itemCounter++;
              drinkCounter++;
            }
            else
            {
              runningTotal -= sparklingWaterPassionfruitPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);
          runningTotalLabel.setText("Running Total: " + runningTotal);
        }
      }

    private class teaOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == teaPeppermint)
          {
            if (teaPeppermint.isSelected())
            {
              runningTotal += teaPeppermintPrice;
              itemCounter++;
              drinkCounter++;
            }
            else
            {
              runningTotal -= teaPeppermintPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          else if (event.getSource() == teaBlack)
          {
            if (teaBlack.isSelected())
            {
              runningTotal += teaBlackPrice;
              itemCounter++;
              drinkCounter++;
            }
            else
            {
              runningTotal -= teaBlackPrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          else if (event.getSource() == teaJasmine)
          {         
            if (teaJasmine.isSelected())
            {
              runningTotal += teaJasminePrice;
              itemCounter++;
              drinkCounter++;
            }
            else
            {
              runningTotal -= teaJasminePrice;
              itemCounter--;
              drinkCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }

    private class dessertOptionListener implements ActionListener
      {
        public void actionPerformed (ActionEvent event)
        {
          Object source = event.getSource();
          if (source.equals(cakeOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(cakeFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(cakeFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);            
          }
          else if (source.equals(macaronsOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(macaronFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(macaronFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);
          }
          else if (source.equals(icecreamOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(icecreamFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(icecreamFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);
          }
        }
      }

    private class cakeOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == cakeChocolate)
          {
            if (cakeChocolate.isSelected())
            {
              runningTotal += cakeChocolatePrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= cakeChocolatePrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == cakeVanilla)
          {
            if (cakeVanilla.isSelected())
            {
              runningTotal += cakeVanillaPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= cakeVanillaPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == cakeStrawberry)
          {
            if (cakeStrawberry.isSelected())
            {
              runningTotal += cakeStrawberryPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= cakeStrawberryPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }
    
    private class macaronsOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == macaronMango)
          {
            if (macaronMango.isSelected())
            {
              runningTotal += macaronMangoPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= macaronMangoPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == macaronBlueberry)
          {
            if (macaronBlueberry.isSelected())
            {
              runningTotal += macaronBlueberryPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= macaronBlueberryPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == macaronPeach)
          {
            if (macaronPeach.isSelected())
            {
              runningTotal += macaronPeachPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= macaronPeachPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }

    private class icecreamOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == icecreamRaspberry)
          {
            if (icecreamRaspberry.isSelected())
            {
              runningTotal += icecreamRaspberryPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= icecreamRaspberryPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == icecreamMint)
          {
            if (icecreamMint.isSelected())
            {
              runningTotal += icecreamMintPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= icecreamMintPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          else if (event.getSource() == icecreamPistachio)
          {
            if (icecreamPistachio.isSelected())
            {
              runningTotal += icecreamPistachioPrice;
              itemCounter++;
              dessertCounter++;
            }
            else
            {
              runningTotal -= icecreamPistachioPrice;
              itemCounter--;
              dessertCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }

    private class snackActionListener implements ActionListener
      {
        public void actionPerformed (ActionEvent event)
        {
          Object source = event.getSource();
          if (source.equals(candyOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(candyFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(candyFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);            
          }
          else if (source.equals(fruitOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(fruitFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(fruitFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);  
          }
          else if (source.equals(cookiesOption))
          {
            generalDirections.setVisible(false);
            panelVisibility(cookiesFlavorPanel);
            exitButton.setVisible(true);
            frame.getContentPane().add(cookiesFlavorPanel);
            frame.getContentPane().add(exitButton, BorderLayout.SOUTH);  
          }
        }
      }

    private class candyOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == candyLaffyTaffy)
          {
            if (candyLaffyTaffy.isSelected())
            {
              runningTotal += candyLaffyTaffyPrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= candyLaffyTaffyPrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == candyLollyPop)
          {
            if (candyLollyPop.isSelected())
            {
              runningTotal += candyLollyPopPrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= candyLollyPopPrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == candyMilkChocolate)
          {
            if (candyMilkChocolate.isSelected())
            {
              runningTotal += candyMilkChocolatePrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= candyMilkChocolatePrice;
              itemCounter--;
              snackCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }

    private class fruitOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == fruitPineapple)
          {
            if (fruitPineapple.isSelected())
            {
              runningTotal += fruitPineapplePrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= fruitPineapplePrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == fruitNectarine)
          {
            if (fruitNectarine.isSelected())
            {
              runningTotal += fruitNectarinePrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= fruitNectarinePrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == fruitGuava)
          {
            if (fruitGuava.isSelected())
            {
              runningTotal += fruitGuavaPrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= fruitGuavaPrice;
              itemCounter--;
              snackCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }

    private class cookieOptionListener implements ItemListener
      {
        public void itemStateChanged (ItemEvent event)
        {
          if (event.getSource() == cookieRedVelvet)
          {
            if (cookieRedVelvet.isSelected())
            {
              runningTotal += cookieRedVelvetPrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= cookieRedVelvetPrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == cookieSugar)
          {
            if (cookieSugar.isSelected())
            {
              runningTotal += cookieSugarPrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= cookieSugarPrice;
              itemCounter--;
              snackCounter--;
            }
          }
          else if (event.getSource() == cookieSnickerDoodle)
          {
            if (cookieSnickerDoodle.isSelected())
            {
              runningTotal += cookieSnickerDoodlePrice;
              itemCounter++;
              snackCounter++;
            }
            else
            {
              runningTotal -= cookieSnickerDoodlePrice;
              itemCounter--;
              snackCounter--;
            }
          }
          totalNumberOfItems.setText("Items In Cart: " + itemCounter);          
          runningTotalLabel.setText("Running Total: " + runningTotal);
          updateFinalLabels();
        }
      }
    
    //creating the exit button listener
    private class exitButtonListener implements ActionListener
      {
        public void actionPerformed (ActionEvent event)
        {
          panelVisibility (homePanel);
          checkOutFrame.setVisible(false);
          frame.setVisible(true);
          exitButton.setVisible(false);
          generalDirections.setVisible(true);
        }
      }

    public void display ()
    {
      frame.setVisible(true);
      frame.getContentPane().add(homePanel, BorderLayout.NORTH);
      homePanel.setVisible(true);
      frame.pack();
    }

    private class tipOptionListener implements ActionListener
      {
        public void actionPerformed (ActionEvent event)
        {
          Object source = event.getSource();
          if (source == tipOption)
          {
            tipPrice = 5;
            tipLabel.setText("Tip: $" + tipPrice);
          }
          else if (source == noTipOption)
          {
            tipPrice = 0;
            tipLabel.setText("Tip: $" + tipPrice);
          }
        }
      }

    //setting things to visible settings method
    public void panelVisibility (JPanel x)
    {
      homePanel.setVisible(false);
      coffeeFlavorPanel.setVisible(false);
      sparklingWaterFlavorPanel.setVisible(false);
      teaFlavorPanel.setVisible(false);
      cakeFlavorPanel.setVisible(false);
      macaronFlavorPanel.setVisible(false);
      icecreamFlavorPanel.setVisible(false);
      candyFlavorPanel.setVisible(false);
      fruitFlavorPanel.setVisible(false);
      cookiesFlavorPanel.setVisible(false);
      x.setVisible(true);
    }

    public void updateFinalLabels ()
    {
      finalTotalLabel.setText("Total: $" + (runningTotal + tipPrice));
      drinkCounterLabel.setText("Drinks: " + drinkCounter);
      dessertCounterLabel.setText("Desserts: " + dessertCounter);
      snackCounterLabel.setText("Snacks: " + snackCounter);
    }
  }