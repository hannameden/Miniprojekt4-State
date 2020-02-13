public abstract class State
  {
  protected static DrinkChoice drinkChoice;
  protected static DrinkStrength drinkStrength;
  protected static DrinkSize drinkSize;
  protected static int coinsToPay; 
  private static State currentState;
  
  public void handleCoinInserted(StateClient stateMachine) { }
  public void handleButton1(StateClient stateMachine)      { }
  public void handleButton2(StateClient stateMachine)      { }
  public void handleButton3(StateClient stateMachine)      { }
  public void handleCancel(StateClient stateMachine)       { }
  
  public static void reset(StateClient client)
    {
    setState(new StateA(client));  
    }
  
  protected static void setState(State newState)
    {
    currentState = newState;
    }
  
  public static State getState()
    {
    return currentState;
    }
  
  protected void setDrinkChoice(DrinkChoice choice)
    {
    drinkChoice = choice;
    }
  
  protected void setDrinkStrength(DrinkStrength strength)
    {
    drinkStrength = strength;
    }
  
  protected void setDrinkSize(DrinkSize size)
    {
    drinkSize = size;
    }
  
  protected void setCoinsToPay(int coins)
    {
    coinsToPay = coins;
    }
  
  protected int getCoinsToPay()
    {
    return coinsToPay;
    }

  protected void reduceCoinsToPay()
    {
    if(coinsToPay > 0)
      coinsToPay--;
    }
  }
