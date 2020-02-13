public class StateA extends State
  {  
  public StateA(StateClient stateMachine)
    {
    stateMachine.setGenericButtonTexts(new String[]{"Te", "Kaffe", "Oboy"});
    stateMachine.setMessage("Ställ in din kopp och välj dryck");
    }

  @Override
  public void handleButton1(StateClient stateMachine)
    {
    setDrinkChoice(DrinkChoice.Tea);
    setCoinsToPay(5);
    setState(new StateB(stateMachine));
    }

  @Override
  public void handleButton2(StateClient stateMachine)
    {
    setDrinkChoice(DrinkChoice.Coffee);
    setCoinsToPay(8);
    setState(new StateB(stateMachine));
    }

  @Override
  public void handleButton3(StateClient stateMachine)
    {
    setDrinkChoice(DrinkChoice.Chocolate);
    setCoinsToPay(10);
    setState(new StateB(stateMachine));
    }
  }
