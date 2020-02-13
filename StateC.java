public class StateC extends State
  {  
  public StateC(StateClient stateMachine)
    {
    stateMachine.setGenericButtonTexts(new String[]{"Mild", "Medium", "Stark"});
    stateMachine.setMessage("Välj styrka");
    }

  @Override
  public void handleButton1(StateClient stateMachine)
    {
    setDrinkStrength(DrinkStrength.Mild);
    setState(new StateD(stateMachine));
    }

  @Override
  public void handleButton2(StateClient stateMachine)
    {
    setDrinkStrength(DrinkStrength.Medium);
    setState(new StateD(stateMachine));
    }

  @Override
  public void handleButton3(StateClient stateMachine)
    {
    setDrinkStrength(DrinkStrength.Strong);
    setState(new StateD(stateMachine));
    }

  @Override
  public void handleCancel(StateClient stateMachine)
    {
    setState(new StateA(stateMachine));    
    }
  }