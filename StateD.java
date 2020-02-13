public class StateD extends State
  {
  
  public StateD(StateClient stateMachine)
    {
    stateMachine.setGenericButtonTexts(new String[]{"", "", ""});
    stateMachine.setMessage("Betala "+getCoinsToPay()+" kronor");
    }

  @Override
  public void handleCoinInserted(StateClient stateMachine)
    {
    reduceCoinsToPay();
    stateMachine.setMessage("Återstår "+getCoinsToPay()+" kronor att betala");
    if(getCoinsToPay() == 0)
      setState(new StateE(stateMachine));
    }

  @Override
  public void handleCancel(StateClient stateMachine)
    {
    setState(new StateA(stateMachine));        
    }
  }