public class StateB extends State
  {  
  public StateB(StateClient stateMachine)
    {
    stateMachine.setGenericButtonTexts(new String[]{"Liten", "Mellan", "Stor"});
    stateMachine.setMessage("Välj storlek");
    }

  @Override
  public void handleButton1(StateClient stateMachine)
    {
    setDrinkSize(DrinkSize.Small);
    setCoinsToPay(getCoinsToPay()-1);
    setState(new StateC(stateMachine));
    }

  @Override
  public void handleButton2(StateClient stateMachine)
    {
    setDrinkSize(DrinkSize.Medium);
    setState(new StateC(stateMachine));
    }

  @Override
  public void handleButton3(StateClient stateMachine)
    {
    setDrinkSize(DrinkSize.Large);
    setCoinsToPay(getCoinsToPay()+1);
    setState(new StateC(stateMachine));
    }

  @Override
  public void handleCancel(StateClient stateMachine)
    {
    setState(new StateA(stateMachine));        
    }
  }